package com.maisprati.BikeShop_API.controller;

import com.maisprati.BikeShop_API.entity.Bike;
import com.maisprati.BikeShop_API.entity.BikeDTO;
import com.maisprati.BikeShop_API.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    private BikeService service;

    @PostMapping
    public ResponseEntity<BikeDTO> create(@RequestBody BikeDTO dados, UriComponentsBuilder uriBuilder) {
        Bike bike = service.cadastrar(dados);
        var uri = uriBuilder.path("/bikes/{id}").buildAndExpand(bike.getId()).toUri();
        return ResponseEntity.created(uri).body(new BikeDTO(bike));
    }

}