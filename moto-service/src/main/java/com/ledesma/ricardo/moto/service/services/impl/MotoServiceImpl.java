package com.ledesma.ricardo.moto.service.services.impl;

import com.ledesma.ricardo.moto.service.entities.Moto;
import com.ledesma.ricardo.moto.service.repositories.MotoRepository;
import com.ledesma.ricardo.moto.service.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public List<Moto> getAll() {
        return this.motoRepository.findAll();
    }

    @Override
    public Moto getById(Integer id) {
        return this.motoRepository.findById(id).orElse(null);
    }

    @Override
    public Moto save(Moto moto) {
        return this.motoRepository.save(moto);
    }

    @Override
    public List<Moto> getByUsuarioId(Integer usuarioId) {
        return this.motoRepository.findByUsuarioId(usuarioId);
    }
}
