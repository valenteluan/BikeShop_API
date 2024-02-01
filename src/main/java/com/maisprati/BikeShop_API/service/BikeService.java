package com.maisprati.BikeShop_API.service;

import com.maisprati.BikeShop_API.entity.Bike;
import com.maisprati.BikeShop_API.entity.BikeDTO;
import com.maisprati.BikeShop_API.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public Bike cadastrar(BikeDTO dados) {
        Bike bike = new Bike(dados);
        bikeRepository.save(bike);
        return bike;
    }

    public List<Bike> listarTodasBikes() {
        List<Bike> bikes = bikeRepository.findAll();
        return bikes;
    }

    public Bike listarPorId(Long id) {
        Optional<Bike> bike = bikeRepository.findById(id);
        return bike.orElseThrow(() -> new RuntimeException("Bike não encontrada: Id " + id));
    }

    public void deletarBike(Long id) {
        bikeRepository.deleteById(id);
    }

    public Bike atualizarTodosCampos(BikeDTO dados) {
        var bike = bikeRepository.getReferenceById(dados.id());
        bike.atulizar(dados);
        return bike;
    }

}
