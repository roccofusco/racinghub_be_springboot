package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.TipoSessione;

@Repository
public interface TipoSessioneRepository extends JpaRepository<TipoSessione, String> {
}
