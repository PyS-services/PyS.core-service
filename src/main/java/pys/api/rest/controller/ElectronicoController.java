package pys.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pys.api.rest.kotlin.model.Electronico;
import pys.api.rest.service.ElectronicoService;

@RestController
@RequestMapping("/electronico")
public class ElectronicoController {

    private final ElectronicoService service;

    @Autowired
    public ElectronicoController(ElectronicoService service) {
        this.service = service;
    }

    @GetMapping("/comprobante/{comprobanteId}/{puntoventa}/{numerocomprobante}")
    public ResponseEntity<Electronico> findByComprobante(@PathVariable Integer comprobanteId,
                                                         @PathVariable Integer puntoventa, @PathVariable Long numerocomprobante) {
        return new ResponseEntity<>(service.findByUnique(comprobanteId, puntoventa, numerocomprobante),
                HttpStatus.OK);
    }
}
