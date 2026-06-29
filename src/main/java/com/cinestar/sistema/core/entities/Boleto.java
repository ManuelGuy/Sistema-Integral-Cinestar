package com.cinestar.sistema.core.entities;

import jakarta.persistence.*;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pelicula;
    private int sala;
    private String asiento;
    private double precio;

    public Boleto() {}
    
    public Boleto(String pelicula, int sala, String asiento, double precio) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public String getPelicula() { return pelicula; }
    public int getSala() { return sala; }
    public String getAsiento() { return asiento; }
    public double getPrecio() { return precio; }
}