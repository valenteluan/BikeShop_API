package com.maisprati.BikeShop_API.domain;

import com.maisprati.BikeShop_API.entity.Bike;
import com.maisprati.BikeShop_API.entity.BikeDTO;
import com.maisprati.BikeShop_API.repository.BikeRepository;
import com.maisprati.BikeShop_API.service.BikeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.maisprati.BikeShop_API.common.BikeConstants.BIKE;
import static com.maisprati.BikeShop_API.common.BikeConstants.INVALID_BIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BikeServiceTest {

    @InjectMocks
    private BikeService bikeService;

    @Mock
    private BikeRepository bikeRepository;

    @Test
    void createBike_WithValidData_ReturnBike() {
        when(bikeRepository.save(BIKE)).thenReturn(BIKE);
        Bike sut = bikeService.cadastrar(new BikeDTO(BIKE));
        assertThat(sut).isEqualTo(BIKE);
    }

    @Test
    void createBike_WithInvalidData_ThrowsException() {
        when(bikeRepository.save(INVALID_BIKE)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> bikeService.cadastrar(new BikeDTO(INVALID_BIKE))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getBike_ByExistingId_ReturnsBike() {
        when(bikeRepository.findById(1L)).thenReturn(Optional.of(BIKE));

        Optional<Bike> sut = Optional.ofNullable(bikeService.listarPorId(1L));

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(BIKE);
    }
}