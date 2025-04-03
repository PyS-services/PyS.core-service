package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.ArticuloAlias
import java.util.Optional

@Repository
interface ArticuloAliasRepository : JpaRepository<ArticuloAlias, Long> {

    fun findByAlias(alias: String): Optional<ArticuloAlias?>?

}