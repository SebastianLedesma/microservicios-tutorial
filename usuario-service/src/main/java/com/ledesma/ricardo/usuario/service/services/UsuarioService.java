package com.ledesma.ricardo.usuario.service.services;

import com.ledesma.ricardo.usuario.service.entities.Usuario;
import com.ledesma.ricardo.usuario.service.models.Auto;
import com.ledesma.ricardo.usuario.service.models.Moto;

import java.util.List;
import java.util.Map;

public interface UsuarioService {

    List<Usuario> getAll();

    Usuario getById(Integer id);

    Usuario save(Usuario usuario);

    List<Auto> getAutos(int usuarioId);

    List<Moto> getMotos(int usuarioId);

    Auto saveAuto(int usuarioId, Auto auto);

    Moto saveMoto(int usuarioId, Moto moto);

    Map<String,Object> getVehiculesByUserId(int userId);
}
