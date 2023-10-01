package com.ledesma.ricardo.usuario.service.controller;

import com.ledesma.ricardo.usuario.service.entities.Usuario;
import com.ledesma.ricardo.usuario.service.models.Auto;
import com.ledesma.ricardo.usuario.service.models.Moto;
import com.ledesma.ricardo.usuario.service.services.UsuarioService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> allUsers = this.usuarioService.getAll();
        if(allUsers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id){
        Usuario usuario = this.usuarioService.getById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario save = this.usuarioService.save(usuario);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/autos/{userId}")
    public ResponseEntity<List<Auto>> getAutos(@PathVariable int userId){
        Usuario usuario = this.usuarioService.getById(userId);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Auto> autoList = this.usuarioService.getAutos(userId);
        return ResponseEntity.ok(autoList);
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable int userId){
        Usuario usuario = this.usuarioService.getById(userId);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }

        List<Moto> motoList = this.usuarioService.getMotos(userId);
        return ResponseEntity.ok(motoList);
    }

    @PostMapping("/auto/{userId}")
    public ResponseEntity<Auto> saveAuto(@PathVariable Integer userId,@RequestBody Auto auto){
        Auto autoSave= this.usuarioService.saveAuto(userId,auto);
        return ResponseEntity.status(HttpStatus.CREATED).body(autoSave);
    }

    @PostMapping("/moto/{userId}")
    public ResponseEntity<Moto> saveMoto(@PathVariable Integer userId,@RequestBody Moto moto){
        Moto motoSave= this.usuarioService.saveMoto(userId,moto);
        return ResponseEntity.status(HttpStatus.CREATED).body(motoSave);
    }

    @GetMapping("todos/{userId}")
    public ResponseEntity<Map<String, Object>> getListOfVehicules(@PathVariable Integer userId){
       Map<String, Object> result = this.usuarioService.getVehiculesByUserId(userId);
       return ResponseEntity.ok(result);
    }

}
