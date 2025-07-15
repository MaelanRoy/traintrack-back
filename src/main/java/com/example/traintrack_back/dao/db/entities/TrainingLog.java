package com.example.traintrack_back.dao.db.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representation of training log in the database
 */
@Entity
@Table(name = "training_log")
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TrainingLog {
    
     /**
     * Autoincrement identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * User associated with the training log
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Exercise associated with the training log
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;

    /**
     * Program associated with the training log
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    /**
     * Date of the training log
     */
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * Sets of the exercise performed during the training
     */
    @Column(name = "sets")
    private Integer sets;

    /**
     * Repetitions of the exercise performed during the training
     */
    @Column(name = "reps")
    private Integer reps;

    /**
     * Duration of the exercise performed during the training
     */
    @Column(name = "duration")
    private Integer duration;

    /**
     * Equipment weight in kg for this exercise
     */
    @Column(name = "equipment_weight")
    private Integer equipmentWeight;


    /**
     * Calories burned during the training
     */
    @Column(name = "calories_burned")
    private Float caloriesBurned;





}
