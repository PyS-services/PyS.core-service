package pys.core.rest.service.extern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pys.core.rest.extern.client.afip.FacturacionAfipClient;
import pys.core.rest.kotlin.model.dto.FacturacionDto;

@Service
@Slf4j
public class FacturacionElectronicaService {

    private final FacturacionAfipClient facturacionAfipClient;

    public FacturacionElectronicaService(FacturacionAfipClient facturacionAfipClient) {
        this.facturacionAfipClient = facturacionAfipClient;
    }

    public FacturacionDto makeFactura(FacturacionDto facturacionDto) {
        log.debug("Processing FacturacionElectronicaService. makeFactura");
        logFacturacion(facturacionDto);
        log.debug("Calling facturador");
        facturacionDto = facturacionAfipClient.facturador(facturacionDto);
        log.debug("Resultado facturador");
        logFacturacion(facturacionDto);
        return facturacionDto;
    }

    private void logFacturacion(FacturacionDto facturacionDto) {
        try {
            log.debug("FacturacionDto -> {}", JsonMapper
                    .builder()
                    .findAndAddModules()
                    .build()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(facturacionDto)
            );
        } catch (JsonProcessingException e) {
            log.debug("FacturacionDto jsonify error -> {}", e.getMessage());
        }
    }

}
