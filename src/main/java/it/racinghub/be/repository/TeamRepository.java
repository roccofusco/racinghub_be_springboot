package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
