package com.cinestar.sistema;

import com.cinestar.sistema.core.entities.Boleto;
import com.cinestar.sistema.core.repositories.BoletoRepository;
import com.cinestar.sistema.core.services.CineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CineServiceUnitTest {

    private BoletoRepository boletoRepository;
    private CineService cineService;

    @BeforeEach
    public void setUp() {
        // Creamos un simulacro (mock) del repositorio
        boletoRepository = Mockito.mock(BoletoRepository.class);
        cineService = new CineService(boletoRepository);
    }

    @Test
    public void testCalcularPrecioConDescuento_ClienteFrecuente() {
        double precioBase = 100.0;
        // 15% de descuento deberia dar 85.0
        double precioEsperado = 85.0; 
        
        double precioObtenido = cineService.calcularPrecioConDescuento(precioBase, true);
        
        assertEquals(precioEsperado, precioObtenido, "El descuento del 15% para cliente frecuente no se aplico correctamente.");
    }

    @Test
    public void testCalcularPrecioConDescuento_ClienteNormal() {
        double precioBase = 100.0;
        double precioEsperado = 100.0; // Sin descuento
        
        double precioObtenido = cineService.calcularPrecioConDescuento(precioBase, false);
        
        assertEquals(precioEsperado, precioObtenido, "A un cliente normal no se le deberia aplicar descuento.");
    }
}