package de.stuttgart.hft.infrastructure.repository;

import de.stuttgart.hft.domain.HotelBuchung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface HotelBuchungRepository extends JpaRepository<HotelBuchung, Integer> {

}
