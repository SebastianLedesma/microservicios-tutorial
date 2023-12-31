package com.ledesma.ricardo.moto.service.repositories;

import com.ledesma.ricardo.moto.service.entities.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

    List<Moto> findByUsuarioId(Integer id);
}
