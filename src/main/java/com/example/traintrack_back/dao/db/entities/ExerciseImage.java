package com.example.traintrack_back.dao.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representation of exercise image in the database
 */
@Entity
@Table(name = "exercise_image")
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ExerciseImage {

    /**
     * Autoincrement identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the image.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The image
     */
    @Column(name = "image", nullable = false)
    private byte[] imageData;

    /**
     * The image type
     */
    @Column(name = "type", nullable = false)
    private String imageType;

    /**
     * The exercise this image is associated with
     */
    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private Exercise exercise;    
}
