package com.ledesma.ricardo.auto.service.controllers;

import com.ledesma.ricardo.auto.service.entities.Auto;
import com.ledesma.ricardo.auto.service.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping
    public ResponseEntity<List<Auto>> getAll(){
        List<Auto> allAutos = this.autoService.getAll();
        if(allAutos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allAutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getById(@PathVariable Integer id){
        Auto auto = this.autoService.getById(id);
        if(auto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auto);
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<Auto>> getByUserId(@PathVariable Integer userId){
        List<Auto> allAutosByUser= this.autoService.getByUsuarioId(userId);
        if(allAutosByUser.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(allAutosByUser);
    }

    @PostMapping
    public ResponseEntity<Auto> save(@RequestBody Auto auto){
        Auto save = this.autoService.save(auto);
        return ResponseEntity.ok(save);
    }
}
