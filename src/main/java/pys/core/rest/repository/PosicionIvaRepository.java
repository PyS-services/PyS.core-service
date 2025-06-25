package pys.core.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pys.core.rest.model.PosicionIva;

import java.util.Optional;

public interface PosicionIvaRepository extends JpaRepository<PosicionIva, Integer> {

    Optional<PosicionIva> findByPosicionIvaId(Integer posicionIvaId);

}
