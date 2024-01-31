package com.maisprati.BikeShop_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String modelo;

    private double preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;

    private String comprador;

    private String loja;

    public Bike() {
    }

    public Bike(String descricao, String modelo, double preco, LocalDate dataCompra, String comprador, String loja) {
        this.descricao = descricao;
        this.modelo = modelo;
        this.preco = preco;
        this.dataCompra = dataCompra;
        this.comprador = comprador;
        this.loja = loja;
    }

    public Bike(BikeDTO dto) {
        this.descricao = dto.descricao();
        this.modelo = dto.modelo();
        this.preco = dto.preco();
        this.dataCompra = dto.dataCompra();
        this.comprador = dto.comprador();
        this.loja = dto.loja();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
}
