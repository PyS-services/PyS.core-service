package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.ArticuloMovimiento


@Repository
interface IArticuloMovimientoRepository : JpaRepository<ArticuloMovimiento?, Long?> {

    fun findAllByClientemovimientoId(clientemovimientoId: Long?): List<ArticuloMovimiento?>?
}

