package org.example.moviereservationsystem.DTO;

import org.example.moviereservationsystem.model.ReservationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ReservationResponse(UUID id,
                                  UUID showtimeId,
                                  String movieTitle,
                                  LocalDateTime startTime,
                                  List<UUID> seatIds,
                                  ReservationStatus status,
                                  LocalDateTime createdAt) {}

