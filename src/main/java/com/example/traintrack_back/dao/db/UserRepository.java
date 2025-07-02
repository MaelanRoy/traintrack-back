package com.example.traintrack_back.dao.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.traintrack_back.dao.db.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);
   User findByEmail(String email);
    
}
