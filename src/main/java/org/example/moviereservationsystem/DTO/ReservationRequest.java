package org.example.moviereservationsystem.DTO;

import java.util.List;
import java.util.UUID;

public record ReservationRequest(UUID showtimeId, List<UUID> seatIds) {}
