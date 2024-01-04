package pys.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pys.api.rest.kotlin.model.Comprobante;
import pys.api.rest.service.ComprobanteService;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    private final ComprobanteService service;

    @Autowired
    public ComprobanteController(ComprobanteService service) {
        this.service = service;
    }

    @GetMapping("/{comprobanteId}")
    public ResponseEntity<Comprobante> findByComprobanteId(@PathVariable Integer comprobanteId) {
        return new ResponseEntity<>(service.findByComprobanteId(comprobanteId), HttpStatus.OK);
    }
}
