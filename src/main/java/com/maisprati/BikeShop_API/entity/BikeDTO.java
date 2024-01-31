package com.maisprati.BikeShop_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record BikeDTO(

        String descricao,
        String modelo,
        double preco,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCompra,
        String comprador,

        String loja
) {
}
