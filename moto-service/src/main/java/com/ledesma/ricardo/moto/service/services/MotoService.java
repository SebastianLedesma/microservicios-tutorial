package com.ledesma.ricardo.moto.service.services;

import com.ledesma.ricardo.moto.service.entities.Moto;

import java.util.List;

public interface MotoService {

    List<Moto> getAll();

    Moto getById(Integer id);

    Moto save(Moto moto);

    List<Moto> getByUsuarioId(Integer usuarioId);
}
