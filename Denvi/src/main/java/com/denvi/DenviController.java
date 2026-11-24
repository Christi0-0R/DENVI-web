package com.denvi;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class DenviController {

    private final EjecutorService servicio;

    public DenviController(EjecutorService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/ejecutar")
    public RespuestaEjecucion ejecutar(@RequestBody EjecutarRequest req) {
        return servicio.ejecutar(req.codigo(), req.entradas());
    }

    @PostMapping("/analizar")
    public RespuestaEjecucion analizar(@RequestBody EjecutarRequest req) {
        return servicio.analizar(req.codigo());
    }

    @GetMapping("/salud")
    public Map<String, String> salud() {
        return Map.of("estado", "ok");
    }
}