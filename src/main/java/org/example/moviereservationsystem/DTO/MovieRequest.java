package org.example.moviereservationsystem.DTO;

public record MovieRequest(String title, String description, int durationMinutes, String genre) {}
