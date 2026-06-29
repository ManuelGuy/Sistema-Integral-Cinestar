package com.cinestar.sistema;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class HelpDeskController {

    // Lista en memoria para guardar los tickets temporalmente
    private final List<String> tickets = new ArrayList<>();

    @PostMapping
    public String crearTicket(@RequestBody String detalleTicket) {
        if (detalleTicket == null || detalleTicket.trim().isEmpty()) {
            return "Error: El detalle del ticket no puede estar vacío.";
        }
        tickets.add(detalleTicket);
        return "¡Ticket creado con éxito! Folio asignado: #" + tickets.size();
    }

    @GetMapping
    public List<String> listarTickets() {
        return tickets;
    }
}