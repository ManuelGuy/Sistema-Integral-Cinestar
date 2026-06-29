package com.cinestar.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CineStarApplication {
    public static void main(String[] args) {
        // Este comando enciende el servidor interno y monta la aplicación de Cine Star
        SpringApplication.run(CineStarApplication.class, args);
    }
}