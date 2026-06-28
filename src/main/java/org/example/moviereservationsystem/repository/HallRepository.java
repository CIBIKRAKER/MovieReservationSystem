package org.example.moviereservationsystem.repository;

import org.example.moviereservationsystem.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<Hall, UUID> {
}
