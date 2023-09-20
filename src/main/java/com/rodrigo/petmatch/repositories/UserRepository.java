package com.rodrigo.petmatch.repositories;

import com.rodrigo.petmatch.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuarios, Long> {
}
