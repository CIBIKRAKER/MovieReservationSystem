package org.example.moviereservationsystem.DTO;

import java.util.UUID;

public record HallResponse(UUID id, String name, int totalSeats) {}

