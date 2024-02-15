package com.maisprati.BikeShop_API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String modelo;

    private Double preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_compra")
    private LocalDate dataCompra;

    private String comprador;

    private String loja;

    public Bike() {
    }

    public Bike(String descricao, String modelo, Double preco, LocalDate dataCompra, String comprador, String loja) {
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

    public void atualizar(BikeDTO dto) {
        this.descricao = dto.descricao();
        this.modelo = dto.modelo();
        this.preco = dto.preco();
        this.dataCompra = dto.dataCompra();
        this.comprador = dto.comprador();
        this.loja = dto.loja();
    }

    public void atualizarParcial(BikeDTO dto) {
        if (dto.descricao() != null) {
            this.descricao = dto.descricao();
        }
        if (dto.modelo() != null) {
            this.modelo = dto.modelo();
        }
        if (dto.preco() != null) {
            this.preco = dto.preco();
        }
        if (dto.dataCompra() != null) {
            this.dataCompra = dto.dataCompra();
        }
        if (dto.comprador() != null) {
            this.comprador = dto.comprador();
        }
        if (dto.loja() != null) {
            this.loja = dto.loja();
        }
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

    public void setPreco(Double preco) {
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bike bike = (Bike) object;
        return Objects.equals(id, bike.id) && Objects.equals(descricao, bike.descricao) && Objects.equals(preco, bike.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, preco);
    }
}
