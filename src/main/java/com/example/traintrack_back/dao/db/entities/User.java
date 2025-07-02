package com.example.traintrack_back.dao.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Representation of user in the database
 */
@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    
    /**
     * Autoincrement identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Username of the user
     */
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    /**
     * Password of the user
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Email of the user
     */
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    /**
     * Role of the user
     */
    @Column(name = "role", nullable = false)
    private String role;

}
