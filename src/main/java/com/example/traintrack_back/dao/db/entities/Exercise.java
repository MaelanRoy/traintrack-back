package com.example.traintrack_back.dao.db.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representation of exercise in the database
 */
@Entity
@Table(name = "exercise")
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Exercise {

    /**
     * Autoincrement identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Name of the exercise
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * Description of the exercise
     */
    @Column(name = "description")
    private String description;

    /**
     * Category of the exercise
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    /**
     * Calories burned per minute for this exercise
     */
    @Column(name = "calories_per_minute")
    private Float caloriesPerMinute;

    /**
     * Calories burned per repetition for this exercise
     */
    @Column(name = "calories_per_repetition")
    private Float caloriesPerRepetition;

    /**
     * Default duration of the exercise in seconds
     */
    @Column(name = "default_duration")
    private Integer defaultDuration;

    /**
     * Default number of repetitions for the exercise
     */
    @Column(name = "default_reps")
    private Integer defaultRepetitions;

    /**
     * Default number of sets for the exercise
     */
    @Column(name = "default_sets")
    private Integer defaultSets;

    /**
     * Default equipment weight for the exercise in kilograms
     */
    @Column(name = "default_equipment_weight")
    private Integer defaultEquipmentWeight;

  /**
     * The zones this exercise targets
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "exercise_zone_link",
        joinColumns = @JoinColumn(name = "exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "zone_id")
    )
    private Set<ExerciseZone> zones;


}