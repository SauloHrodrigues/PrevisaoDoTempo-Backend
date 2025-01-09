package com.projeto_final.PrevisaoDoTempo.repositories;

import com.projeto_final.PrevisaoDoTempo.core.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNome(String nome);
}
