package pys.core.rest.extern.client.common;

import org.jetbrains.annotations.Nullable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pys.core.rest.extern.model.ArticuloDto;

@FeignClient("common-service/api/common-service/articulo")
public interface ArticuloClient {

    @GetMapping("/codigo/articulo/{codigoArticulo}")
    ArticuloDto findByCodigoArticulo(@PathVariable String codigoArticulo);

    @PostMapping("/addOrUpdate")
    ArticuloDto addOrUpdate(ArticuloDto articuloDto);

}
