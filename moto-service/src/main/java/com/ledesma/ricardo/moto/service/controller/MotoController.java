package com.ledesma.ricardo.moto.service.controller;

import com.ledesma.ricardo.moto.service.entities.Moto;
import com.ledesma.ricardo.moto.service.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getAll(){
        List<Moto> allMotos = this.motoService.getAll();
        if(allMotos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allMotos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> getById(@PathVariable Integer id){
        Moto moto = this.motoService.getById(id);
        if(moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<Moto>> getByUserId(@PathVariable Integer userId){
        List<Moto> allMotosByUser= this.motoService.getByUsuarioId(userId);
        if(allMotosByUser.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(allMotosByUser);
    }

    @PostMapping
    public ResponseEntity<Moto> save(@RequestBody Moto moto){
        Moto save = this.motoService.save(moto);
        return ResponseEntity.ok(save);
    }
}
