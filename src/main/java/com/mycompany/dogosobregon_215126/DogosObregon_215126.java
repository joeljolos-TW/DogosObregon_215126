/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dogosobregon_215126;

import DAO.IHotDogDAO;
import DAO.Impl.HotDogDAO;
import Entities.HotDog;
import Service.IHotdogService;
import Service.impl.HotdogService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

/**
 *
 * @author Laboratorios
 */
public class DogosObregon_215126 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        IHotdogService iHotdogService = new HotdogService();
        HotDog hd1 = new HotDog("Clásico", new BigDecimal("45.00"));
        HotDog hd2 = new HotDog("Texano BBQ", new BigDecimal("58.50"));
        HotDog hd3 = new HotDog("Chilango Picante", new BigDecimal("52.75"));
        HotDog hd4 = new HotDog("Alemán con Salchicha Bratwurst", new BigDecimal("65.00"));
        HotDog hd5 = new HotDog("Vegetariano Deluxe", new BigDecimal("49.90"));
        HotDog hd6 = null;

        iHotdogService.agregarHotDog(hd1);
        iHotdogService.agregarHotDog(hd2);
        iHotdogService.agregarHotDog(hd3);
        iHotdogService.agregarHotDog(hd4);
        iHotdogService.agregarHotDog(hd5);
        iHotdogService.agregarHotDog(hd6);

        for (HotDog hotDog : iHotdogService.listarHotDogsPorNombreDESC()) {
            System.out.println(hotDog.getNombre());
        }
        System.out.println("aqui termina");

    }
}
