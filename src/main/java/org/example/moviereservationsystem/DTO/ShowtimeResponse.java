package org.example.moviereservationsystem.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ShowtimeResponse(UUID id,
                               UUID movieId,
                               String movieTitle,
                               UUID hallId,
                               String hallName,
                               LocalDateTime startTime,
                               BigDecimal price) {}

