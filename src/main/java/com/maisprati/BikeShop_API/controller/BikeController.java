package com.maisprati.BikeShop_API.controller;

import com.maisprati.BikeShop_API.entity.Bike;
import com.maisprati.BikeShop_API.entity.BikeDTO;
import com.maisprati.BikeShop_API.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<BikeDTO>> findAll() {
        List<Bike> bikeList = service.listarTodasBikes();
        List<BikeDTO> listDto = bikeList.stream().map(obj -> new BikeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BikeDTO> list(@PathVariable Long id) {
        Bike bike = service.listarPorId(id);
        return ResponseEntity.ok().body(new BikeDTO(bike));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BikeDTO> delete(@PathVariable Long id) {
        service.deletarBike(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<BikeDTO> update(@RequestBody BikeDTO dados) {
        Bike bike = service.atualizarTodosCampos(dados);
        return ResponseEntity.ok().body(new BikeDTO(bike));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BikeDTO> patchUpdate(@PathVariable Long id, @RequestBody BikeDTO dados) {
        Bike bike = service.atualizarParcial(dados);
        return ResponseEntity.ok().body(new BikeDTO(bike));
    }

}
