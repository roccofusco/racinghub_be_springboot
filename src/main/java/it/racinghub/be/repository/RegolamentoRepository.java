package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.racinghub.be.entity.Regolamento;

public interface RegolamentoRepository extends JpaRepository<Regolamento, Integer> {
}
