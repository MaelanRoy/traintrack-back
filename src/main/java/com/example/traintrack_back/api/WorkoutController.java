package com.example.traintrack_back.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.traintrack_back.api.configuration.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
@Tag(name = "Entraînements", description = "Gestion des entraînements sportifs")
@SecurityRequirement(name = "Bearer Authentication")
public class WorkoutController {

    @GetMapping
    @Operation(
        summary = "Lister les entraînements", 
        description = "Récupère la liste des entraînements. **Accessible aux utilisateurs normaux et administrateurs.**"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste des entraînements récupérée avec succès"),
        @ApiResponse(responseCode = "401", description = "Non authentifié"),
        @ApiResponse(responseCode = "403", description = "Accès refusé")
    })
    @PreAuthorize(Constants.Authority.NORMAL + " or " + Constants.Authority.ADMINISTRATOR)
    public ResponseEntity<?> getAllWorkouts() {
        // Logique pour récupérer les entraînements
        return ResponseEntity.ok("Liste des entraînements (Normal/Admin)");
    }

    @PostMapping
    @Operation(
        summary = "Créer un entraînement", 
        description = "Crée un nouvel entraînement. **Accessible aux utilisateurs normaux et administrateurs.**"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Entraînement créé avec succès"),
        @ApiResponse(responseCode = "400", description = "Données invalides"),
        @ApiResponse(responseCode = "401", description = "Non authentifié"),
        @ApiResponse(responseCode = "403", description = "Accès refusé")
    })
    @PreAuthorize(Constants.Authority.NORMAL + " or " + Constants.Authority.ADMINISTRATOR)
    public ResponseEntity<?> createWorkout() {
        // Logique pour créer un entraînement
        return ResponseEntity.ok("Entraînement créé (Normal/Admin)");
    }

    @DeleteMapping("/admin/{id}")
    @Operation(
        summary = "Supprimer un entraînement (Admin)", 
        description = "Supprime un entraînement du système. **Réservé aux administrateurs uniquement.**"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Entraînement supprimé avec succès"),
        @ApiResponse(responseCode = "404", description = "Entraînement non trouvé"),
        @ApiResponse(responseCode = "401", description = "Non authentifié"),
        @ApiResponse(responseCode = "403", description = "Accès refusé - Rôle Administrator requis")
    })
    @PreAuthorize(Constants.Authority.ADMINISTRATOR)
    public ResponseEntity<?> deleteWorkout(@PathVariable Long id) {
        // Logique pour supprimer un entraînement
        return ResponseEntity.ok("Entraînement supprimé (Admin uniquement)");
    }

    @GetMapping("/admin/stats")
    @Operation(
        summary = "Statistiques globales", 
        description = "Récupère les statistiques globales des entraînements. **Réservé aux administrateurs uniquement.**"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Statistiques récupérées avec succès"),
        @ApiResponse(responseCode = "401", description = "Non authentifié"),
        @ApiResponse(responseCode = "403", description = "Accès refusé - Rôle Administrator requis")
    })
    @PreAuthorize(Constants.Authority.ADMINISTRATOR)
    public ResponseEntity<?> getGlobalStats() {
        // Logique pour récupérer les statistiques globales
        return ResponseEntity.ok("Statistiques globales (Admin uniquement)");
    }

    @GetMapping("/my")
    @Operation(
        summary = "Mes entraînements", 
        description = "Récupère les entraînements de l'utilisateur connecté. **Accessible à tous les utilisateurs authentifiés.**"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Entraînements personnels récupérés avec succès"),
        @ApiResponse(responseCode = "401", description = "Non authentifié")
    })
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getMyWorkouts() {
        // Logique pour récupérer les entraînements de l'utilisateur connecté
        return ResponseEntity.ok("Mes entraînements (utilisateur authentifié)");
    }
}
