package pys.core.rest.extern.client.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import pys.core.rest.extern.model.ArticuloAliasDto;

@FeignClient("common-service/api/common-service/articuloAlias")
public interface ArticuloAliasClient {

    @PostMapping("/addOrUpdate")
    ArticuloAliasDto addOrUpdate(ArticuloAliasDto articuloAliasDto);

}

