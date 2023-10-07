package com.ledesma.ricardo.usuario.service.services.impl;

import com.ledesma.ricardo.usuario.service.entities.Usuario;
import com.ledesma.ricardo.usuario.service.feingClient.AutoFeignClient;
import com.ledesma.ricardo.usuario.service.feingClient.MotoFeignClient;
import com.ledesma.ricardo.usuario.service.models.Auto;
import com.ledesma.ricardo.usuario.service.models.Moto;
import com.ledesma.ricardo.usuario.service.repositories.UsuarioRepository;
import com.ledesma.ricardo.usuario.service.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AutoFeignClient autoFeignClient;

    @Autowired
    private MotoFeignClient motoFeignClient;


    @Override
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Integer id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Auto> getAutos(int usuarioId){
        List<Auto> autoList = this.restTemplate.getForObject("http://auto-service/api/auto/usuario/" + usuarioId,List.class);
        return  autoList;
    }

    public List<Moto> getMotos(int usuarioId){
        List<Moto> motoList = this.restTemplate.getForObject("http://moto-service/api/moto/" + usuarioId,List.class);
        return motoList;
    }

    public Auto saveAuto(int usuarioId, Auto auto){
        auto.setUsuarioId(usuarioId);
        Auto save = this.autoFeignClient.save(auto);
        return save;
    }

    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto save = this.motoFeignClient.save(moto);
        return save;
    }

    public Map<String,Object> getVehiculesByUserId(int userId){
        Map<String,Object> result = new HashMap<>();
        Usuario usuario = this.usuarioRepository.findById(userId).orElse(null);

        if(usuario == null){
            result.put("mensaje","El usuario con ID "+ userId + " no existe.");
        }
        result.put("Usuario",usuario);
        List<Auto> autos = this.autoFeignClient.getByUserId(userId);

        if(autos == null || autos.isEmpty()){
            result.put("autos","El usuario no tiene autos.");
        }else{
            result.put("autos",autos);
        }

        List<Moto> motos = this.motoFeignClient.getByUserId(userId);
        if(motos == null || motos.isEmpty()){
            result.put("motos","El usuario no tiene motos.");
        }else{
            result.put("motos",motos);
        }

        return result;
    }
}
