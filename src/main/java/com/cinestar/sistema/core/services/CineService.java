package com.cinestar.sistema.core.services;

import com.cinestar.sistema.core.entities.Boleto;
import com.cinestar.sistema.core.repositories.BoletoRepository;
import org.springframework.stereotype.Service;

@Service
public class CineService {

    private final BoletoRepository boletoRepository;

    public CineService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public double calcularPrecioConDescuento(double precioBase, boolean esClienteFrecuente) {
        if (esClienteFrecuente) {
            return precioBase * 0.85; // 15% de descuento (Programa de Lealtad)
        }
        return precioBase;
    }

    public Boleto emitirBoleto(String pelicula, int sala, String asiento, boolean esClienteFrecuente) {
        double precioFinal = calcularPrecioConDescuento(100.0, esClienteFrecuente);
        Boleto nuevoBoleto = new Boleto(pelicula, sala, asiento, precioFinal);
        return boletoRepository.save(nuevoBoleto);
    }
}