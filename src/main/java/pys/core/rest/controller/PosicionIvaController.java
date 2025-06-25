package pys.core.rest.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pys.core.rest.exception.PosicionIvaException;
import pys.core.rest.model.PosicionIva;
import pys.core.rest.service.PosicionIvaService;

@RestController
@RequestMapping({"/posicionIva", "/api/core/posicionIva"})
public class PosicionIvaController {

    private final PosicionIvaService service;

    public PosicionIvaController(PosicionIvaService service) {
        this.service = service;
    }

    @GetMapping("/{posicionIvaId}")
    public ResponseEntity<PosicionIva> findByPosicionIvaId(@PathVariable Integer posicionIvaId) {
        try {
            return ResponseEntity.ok(service.findByPosicionIvaId(posicionIvaId));
        } catch (PosicionIvaException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
