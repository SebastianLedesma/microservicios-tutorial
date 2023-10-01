package com.ledesma.ricardo.usuario.service.repositories;

import com.ledesma.ricardo.usuario.service.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
