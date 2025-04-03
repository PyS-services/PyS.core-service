package pys.core.rest.controller.facade;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pys.core.rest.kotlin.model.dto.FacturacionDto;
import pys.core.rest.service.extern.FacturacionElectronicaService;
import pys.core.rest.service.facade.FacturaPdfService;
import pys.core.rest.service.facade.MakeFacturaService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping({"/makefactura", "/api/core/makefactura"})
@Slf4j
public class MakeFacturaController {

    private final MakeFacturaService service;
    private final FacturaPdfService facturaPdfService;
    private final FacturacionElectronicaService facturacionElectronicaService;

    public MakeFacturaController(FacturaPdfService facturaPdfService,
                                 FacturacionElectronicaService facturacionElectronicaService,
                                 MakeFacturaService service) {
        this.facturaPdfService = facturaPdfService;
        this.facturacionElectronicaService = facturacionElectronicaService;
        this.service = service;
    }

    @GetMapping("/pdf/{clientemovimientoId}")
    public ResponseEntity<Resource> makePdf(@PathVariable Long clientemovimientoId) throws FileNotFoundException {
        String filename = facturaPdfService.generatePdf(clientemovimientoId);
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=factura.pdf");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }

    @PostMapping("/afip/make")
    public ResponseEntity<FacturacionDto> makeFactura(@RequestBody FacturacionDto facturacionDto) {
        log.debug("Processing request for makeFactura");
        return new ResponseEntity<>(facturacionElectronicaService.makeFactura(facturacionDto), HttpStatus.OK);
    }

    @GetMapping("/send/{clienteMovimientoId}/{email}")
    public ResponseEntity<String> send(@PathVariable Long clienteMovimientoId, @PathVariable String email) throws MessagingException {
        return new ResponseEntity<>(service.send(clienteMovimientoId, email), HttpStatus.OK);
    }

}
