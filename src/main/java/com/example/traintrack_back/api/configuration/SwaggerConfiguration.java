package com.example.traintrack_back.api.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Swagger pour TrainTrack API
 */
@Slf4j
@Configuration
public class SwaggerConfiguration {

    /**
     * La version de l'application
     */
    @Value("${spring.application.name:TrainTrack API}")
    private String applicationName;

    /**
     * Configuration OpenAPI pour Swagger
     *
     * @return la documentation OpenAPI
     */
    @Bean
    public OpenAPI openApi() {        Info info = new Info()
                .title(applicationName)
                .version("1.0.0")
                .description("API de gestion d'entraînements sportifs\n\n" +
                        "## Description\n" +
                        "TrainTrack est une application de suivi et gestion d'entraînements sportifs permettant aux utilisateurs de planifier, suivre et analyser leurs séances d'entraînement.\n\n" +
                        "## Authentification\n" +
                        "Cette API utilise l'authentification JWT Bearer Token.\n\n" +
                        "## Rôles\n" +
                        "- **NORMAL** : Peut créer et gérer ses propres entraînements, consulter ses statistiques\n" +
                        "- **ADMIN** : Accès complet - gestion des utilisateurs, modération, statistiques globales\n\n" +
                        "Pour tester les endpoints protégés, cliquez sur 'Authorize' et saisissez votre token JWT.");

        Contact contact = new Contact()
                .name("Équipe TrainTrack")
                .email("support@traintrack-sport.com");

        return new OpenAPI()
                .info(info.contact(contact))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Saisissez votre token JWT (sans 'Bearer' au début)")
                        )
                );
    }
}
