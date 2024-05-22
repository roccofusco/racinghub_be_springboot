package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Pista;

@Repository
public interface PistaRepository extends JpaRepository<Pista, Integer> {
}
