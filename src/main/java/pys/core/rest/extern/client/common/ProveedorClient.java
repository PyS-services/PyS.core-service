package pys.core.rest.extern.client.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pys.core.rest.extern.model.ProveedorDto;

import java.util.List;
import java.util.UUID;

@FeignClient("common-service/api/common-service/proveedor")
public interface ProveedorClient {

    @GetMapping("/")
    List<ProveedorDto> findAll();

    @GetMapping("/{proveedorId}")
    ProveedorDto findByProveedorId(@PathVariable UUID proveedorId);

    @GetMapping("/old/{proveedorIdOld}")
    ProveedorDto findByProveedorIdOld(@PathVariable Long proveedorIdOld);

    @PostMapping("/addOrUpdate")
    ProveedorDto addOrUpdate(ProveedorDto proveedorDto);

}
