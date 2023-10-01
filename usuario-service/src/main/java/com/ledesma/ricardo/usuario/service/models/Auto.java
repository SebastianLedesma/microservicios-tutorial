package com.ledesma.ricardo.usuario.service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auto {

    private String marca;
    private String modelo;
    private Integer usuarioId;
}
