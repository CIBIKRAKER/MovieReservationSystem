package org.example.moviereservationsystem.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record MovieResponse(UUID id, String title, String description, int durationMinutes, String genre, LocalDateTime createdAt) {}

