package com.maisprati.BikeShop_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record BikeDTO(

        String descricao,
        String modelo,
        double preco,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Column(name = "data_compra")
        LocalDate dataCompra,
        String comprador,

        String loja) {

        public BikeDTO(Bike bike) {
                this(bike.getDescricao(), bike.getModelo(), bike.getPreco(), bike.getDataCompra(), bike.getComprador(), bike.getLoja());
        }
}
