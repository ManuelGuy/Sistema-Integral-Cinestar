package com.cinestar.sistema.core.repositories;

import com.cinestar.sistema.core.entities.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
}