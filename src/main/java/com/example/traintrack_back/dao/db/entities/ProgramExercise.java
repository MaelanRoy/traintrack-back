package com.example.traintrack_back.dao.db.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representation of program exercise in the database
 */
@Entity
@Table(name = "program_exercise")
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ProgramExercise {

    /**
     * Autoincrement identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The program this exercise belongs to
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private Program program;

    /**
     * The exercise in this program
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private Exercise exercise;

    /**
     * Position of the exercise in the program
     */
    @Column(name = "position")
    private Integer position;

    /**
     * Number of sets for this exercise in this program
     */
    @Column(name = "sets")
    private Integer sets;

    /**
     * Number of repetitions per set
     */
    @Column(name = "reps")
    private Integer reps;

    /**
     * Equipment weight in kg for this exercise
     */
    @Column(name = "equipment_weight")
    private Integer equipmentWeight;

    /**
     * Duration in seconds for this exercise
     */
    @Column(name = "duration")
    private Integer duration;
}