package com.example.traintrack_back.business.mappers;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.traintrack_back.api.configuration.mappers.GenericMapper;
import com.example.traintrack_back.api.models.TrainingLogDto;
import com.example.traintrack_back.dao.db.entities.TrainingLog;

/**
 * Maps TrainingLog and TrainingLogDto
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrainingLogMapper extends GenericMapper<TrainingLog, TrainingLogDto> {

    /**
     * Maps java.sql.Date to ZonedDateTime
     *
     * @param date the sql date
     * @return the zoned date time
     */
    default ZonedDateTime map(Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate().atStartOfDay(ZoneId.systemDefault());
    }

    /**
     * Maps ZonedDateTime to java.sql.Date
     *
     * @param zonedDateTime the zoned date time
     * @return the sql date
     */
    default Date map(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        return Date.valueOf(zonedDateTime.toLocalDate());
    }
}
