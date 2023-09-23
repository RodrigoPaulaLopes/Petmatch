package com.rodrigo.petmatch.repositories;

import com.rodrigo.petmatch.entities.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {
}
