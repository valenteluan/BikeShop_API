package com.maisprati.BikeShop_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public record BikeDTO(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String descricao,
        String modelo,
        double preco,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCompra,
        String comprador,

        String loja
) {
}
