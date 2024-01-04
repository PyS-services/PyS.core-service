package pys.api.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.api.rest.kotlin.model.Articulo
import java.util.Optional

@Repository
interface IArticuloRepository : JpaRepository<Articulo, String> {

    fun findByArticuloId(articuloId: String): Optional<Articulo?>?

}