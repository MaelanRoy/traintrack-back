package com.example.traintrack_back.api.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.traintrack_back.api.AbstractRestController;
import com.example.traintrack_back.api.ExerciseImageController;
import com.example.traintrack_back.api.exceptions.TechnicalException;
import com.example.traintrack_back.api.models.ExerciseImageDto;
import com.example.traintrack_back.business.ExerciseImageService;

import static com.example.traintrack_back.api.configuration.Constants.Api.EXERCISE_IMAGE;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * implementation of {@link ExerciseImageController}
 */
@Slf4j
@RestController
public class ExerciseImageControllerImpl extends AbstractRestController implements ExerciseImageController {

    /**
     * Controls for exercise image
     */
    private final ExerciseImageService exerciseImageService;

    /**
     * Injection constructor
     *
     * @param exerciseImageService Controls for exercise image
     */
    public ExerciseImageControllerImpl(ExerciseImageService exerciseImageService) {
        this.exerciseImageService = exerciseImageService;
    }

    /**
     * {@inheritDoc}
     */
    public List<ExerciseImageDto> findByExerciseId(Long exerciseId) {
        log.info("Rest : GET - {}", EXERCISE_IMAGE);
        return logResponse(log, "GET", exerciseImageService.findByExerciseId(exerciseId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseImageDto create(MultipartFile image, Long exerciseId, Integer position) {
        log.info("Rest : POST - {}", EXERCISE_IMAGE);

        long sizeInMb = image.getSize() / (1024 * 1024);
        if (sizeInMb > 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is too large");
        }

        if (!Arrays.asList("image/jpeg", "image/png").contains(image.getContentType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid image type. Only JPEG and PNG are supported.");
        }

        try {
            ExerciseImageDto newImage = ExerciseImageDto.builder()
                    .imageType(image.getContentType())
                    .imageData(image.getBytes())
                    .exerciseId(exerciseId)
                    .name(image.getOriginalFilename())
                    .position(position)
                    .build();
            return logResponse(log, "POST", exerciseImageService.create(newImage));
        } catch (IOException e) {
            throw new TechnicalException("Failed to read image data", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseImageDto updateById(Long id, MultipartFile image, Long exerciseId, Integer position) {
        log.info("Rest : PUT - {}/{}", EXERCISE_IMAGE, id);

        long sizeInMb = image.getSize() / (1024 * 1024);
        if (sizeInMb > 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is too large");
        }

        if (!Arrays.asList("image/jpeg", "image/png").contains(image.getContentType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid image type. Only JPEG and PNG are supported.");
        }

        try {
            ExerciseImageDto updatedImage = ExerciseImageDto.builder()
                    .id(id)
                    .exerciseId(exerciseId)
                    .imageType(image.getContentType())
                    .imageData(image.getBytes())
                    .name(image.getOriginalFilename())
                    .position(position)
                    .build();
            return logResponse(log, "PUT", exerciseImageService.updateById(id, updatedImage));
        } catch (IOException e) {
            throw new TechnicalException("Failed to read image data", e);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        log.info("Rest : DELETE - {}/{}", EXERCISE_IMAGE, id);
        exerciseImageService.deleteById(id);
        logResponse(log, "DELETE");
    }
}
