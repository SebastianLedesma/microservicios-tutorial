package com.ledesma.ricardo.usuario.service.feingClient;

import com.ledesma.ricardo.usuario.service.models.Auto;
import com.ledesma.ricardo.usuario.service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "auto-service")
public interface AutoFeignClient {

    @GetMapping("/usuario/{userId}")
    List<Auto> getByUserId(@PathVariable Integer userId);

    @PostMapping
    Auto save(@RequestBody Auto auto);
}
