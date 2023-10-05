package com.ledesma.ricardo.usuario.service.feingClient;

import com.ledesma.ricardo.usuario.service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-service")
public interface MotoFeignClient {

    @GetMapping("/usuario/{userId}")
    List<Moto> getByUserId(@PathVariable Integer userId);

    @PostMapping
    Moto save(@RequestBody Moto moto);
}
