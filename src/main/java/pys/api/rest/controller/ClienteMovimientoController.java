package pys.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pys.api.rest.kotlin.model.ClienteMovimiento;
import pys.api.rest.service.ClienteMovimientoService;

import java.util.List;

@RestController
@RequestMapping("/clientemovimiento")
public class ClienteMovimientoController {

    private final ClienteMovimientoService service;

    @Autowired
    public ClienteMovimientoController(ClienteMovimientoService service) {
        this.service = service;
    }

    @GetMapping("/asociable/{clienteId}")
    public ResponseEntity<List<ClienteMovimiento>> findAllAsociables(@PathVariable Long clienteId) {
        return new ResponseEntity<>(service.findAllAsociables(clienteId), HttpStatus.OK);
    }

    @GetMapping("/{clienteMovimientoId}")
    public ResponseEntity<ClienteMovimiento> findByClientemovimientoId(@PathVariable Long clienteMovimientoId) {
        return new ResponseEntity<>(service.findByClientemovimientoId(clienteMovimientoId),
                HttpStatus.OK);
    }

}
