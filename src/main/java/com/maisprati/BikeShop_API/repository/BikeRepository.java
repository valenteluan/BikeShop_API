package com.maisprati.BikeShop_API.repository;

import com.maisprati.BikeShop_API.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
