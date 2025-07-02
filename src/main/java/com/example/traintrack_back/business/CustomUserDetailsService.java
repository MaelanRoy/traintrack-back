package com.example.traintrack_back.business;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.traintrack_back.dao.db.UserRepository;
import com.example.traintrack_back.dao.db.entities.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Tentative de chargement de l'utilisateur avec email: {}", email);
        
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("Utilisateur non trouvé avec email: {}", email);
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        
        log.info("Utilisateur trouvé: {} avec rôle: {}", user.getEmail(), user.getRole());
        
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );        
    }
    
}
