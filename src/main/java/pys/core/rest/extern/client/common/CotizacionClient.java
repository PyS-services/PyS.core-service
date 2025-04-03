package pys.core.rest.extern.client.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pys.core.rest.extern.model.CotizacionDto;

import java.util.List;

@FeignClient("common-service/api/common-service/cotizacion")
public interface CotizacionClient {

    @GetMapping("/")
    List<CotizacionDto> findAll();

    @PostMapping("/addOrUpdate")
    CotizacionDto addOrUpdate(@RequestBody CotizacionDto cotizacionDto);

}
