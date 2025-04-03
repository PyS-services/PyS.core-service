package pys.core.rest.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pys.core.rest.kotlin.model.Proveedor
import java.util.Optional

@Repository
interface ProveedorRepository : JpaRepository<Proveedor, Long> {

    fun findByProveedorId(proveedorId: Long): Optional<Proveedor?>?

}