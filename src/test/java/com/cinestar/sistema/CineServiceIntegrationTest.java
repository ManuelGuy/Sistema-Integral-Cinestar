package com.cinestar.sistema;

import com.cinestar.sistema.core.entities.Boleto;
import com.cinestar.sistema.core.services.CineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CineServiceIntegrationTest {

    @Autowired
    private CineService cineService;

    @Test
    public void testEmitirBoletoYPersistirEnBaseDeDatos() {
        // Ejecutamos la accion del servicio
        Boleto boletoGuardado = cineService.emitirBoleto("Avengers", 3, "H-12", true);
        
        // Verificaciones (Asserts)
        assertNotNull(boletoGuardado.getId(), "El boleto deberia tener un ID generado por la base de datos.");
        assertEquals(85.0, boletoGuardado.getPrecio(), "El precio guardado deberia incluir el descuento.");
        assertEquals("Avengers", boletoGuardado.getPelicula());
    }
}