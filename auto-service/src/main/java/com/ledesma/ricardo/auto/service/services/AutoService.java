package com.ledesma.ricardo.auto.service.services;

import com.ledesma.ricardo.auto.service.entities.Auto;

import java.util.List;

public interface AutoService {

    List<Auto> getAll();

    Auto getById(Integer id);

    Auto save(Auto auto);

    List<Auto> getByUsuarioId(Integer usuarioId);
}
