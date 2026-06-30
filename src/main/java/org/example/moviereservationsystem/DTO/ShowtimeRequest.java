package org.example.moviereservationsystem.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowtimeRequest(UUID movieId, UUID hallId, LocalDateTime startTime, BigDecimal price) {}

