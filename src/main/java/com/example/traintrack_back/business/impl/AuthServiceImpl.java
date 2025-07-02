package com.example.traintrack_back.business.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.traintrack_back.api.configuration.JwtUtils;
import com.example.traintrack_back.api.models.AuthResponseDto;
import com.example.traintrack_back.api.models.LoginRequestDto;
import com.example.traintrack_back.api.models.RegisterRequestDto;
import com.example.traintrack_back.business.AuthService;
import com.example.traintrack_back.dao.db.UserRepository;
import com.example.traintrack_back.dao.db.entities.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of (@link AuthService)
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequest) {
        log.info("Tentative d'inscription avec email: {}", registerRequest.getEmail());

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            log.warn("Email déjà existant: {}", registerRequest.getEmail());
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            log.warn("Nom d'utilisateur déjà existant: {}", registerRequest.getUsername());
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role("NORMAL") // Rôle par défaut
                .build();

        // Sauvegarder l'utilisateur
        User savedUser = userRepository.save(user);
        log.info("Inscription réussie pour: {} avec le rôle: {}", savedUser.getEmail(), savedUser.getRole());

        // Générer le token JWT
        String token = jwtUtils.generateToken(savedUser.getEmail(), savedUser.getRole());

        return AuthResponseDto.builder()
                .token(token)
                .type("Bearer")
                .build();
    }

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequest) {
        log.info("Tentative de connexion avec email: {}", loginRequest.getEmail());

        try {
            // Authentifier l'utilisateur
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            if (!authentication.isAuthenticated()) {
                throw new RuntimeException("Authentication failed");
            }

            // Récupérer l'utilisateur depuis la base de données
            User user = userRepository.findByEmail(loginRequest.getEmail());
            if (user == null) {
                log.error("Utilisateur non trouvé après authentification: {}", loginRequest.getEmail());
                throw new RuntimeException("User not found after authentication");
            }

            log.info("Connexion réussie pour: {}", user.getEmail());

            // Générer le token JWT
            String token = jwtUtils.generateToken(user.getEmail(), user.getRole());

            return AuthResponseDto.builder()
                    .token(token)
                    .type("Bearer")
                    .build();

        } catch (AuthenticationException e) {
            log.error("Échec de l'authentification pour {}: {}", loginRequest.getEmail(), e.getMessage());
            throw new RuntimeException("Invalid email or password");
        }
    }
}
