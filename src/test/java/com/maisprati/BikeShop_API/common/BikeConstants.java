package com.maisprati.BikeShop_API.common;

import com.maisprati.BikeShop_API.entity.Bike;

import java.time.LocalDate;

public class BikeConstants {

    public static final Bike BIKE = new Bike("Bike de Trilha", "Caloy", 850.50, LocalDate.now(), "Jose Nunes", "Decathlon");
    public static final Bike INVALID_BIKE = new Bike("", "", 0.0, LocalDate.now(), "", "");

}
