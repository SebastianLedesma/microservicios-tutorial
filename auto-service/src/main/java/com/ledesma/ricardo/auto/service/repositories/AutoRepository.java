package com.ledesma.ricardo.auto.service.repositories;

import com.ledesma.ricardo.auto.service.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {

    List<Auto> findByUsuarioId(Integer usuarioId);

}
