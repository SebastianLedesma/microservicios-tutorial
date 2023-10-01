package com.ledesma.ricardo.auto.service.services.impl;

import com.ledesma.ricardo.auto.service.entities.Auto;
import com.ledesma.ricardo.auto.service.repositories.AutoRepository;
import com.ledesma.ricardo.auto.service.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public List<Auto> getAll() {
        return this.autoRepository.findAll();
    }

    @Override
    public Auto getById(Integer id) {
        return this.autoRepository.findById(id).orElse(null);
    }

    @Override
    public Auto save(Auto auto) {
        return this.autoRepository.save(auto);
    }

    public List<Auto> getByUsuarioId(Integer usuarioId){
        return this.autoRepository.findByUsuarioId(usuarioId);
    }
}
