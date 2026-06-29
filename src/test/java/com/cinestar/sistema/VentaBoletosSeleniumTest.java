package com.cinestar.sistema;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VentaBoletosSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
    
        System.setProperty("webdriver.chrome.driver", "/Users/josemanuelsanchezdeluna/WebDriver/chromedriver");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
public void testSimulacionNavegacionTaquilla() {
    // Selenium ahora abrirá la interfaz real de tu propio sistema de cine
    driver.get("http://localhost:8080");
    String tituloPagina = driver.getTitle();
    
    // Validamos que cargue tu título personalizado
    assertTrue(tituloPagina.contains("Cine Star"), "Selenium no pudo cargar la interfaz de Cine Star.");
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador de forma automatica al terminar
        }
    }
}