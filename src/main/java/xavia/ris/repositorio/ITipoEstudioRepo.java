package xavia.ris.repositorio;

import xavia.ris.modelo.TipoEstudio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEstudioRepo extends JpaRepository<TipoEstudio, Long> {
  @Query(
    "SELECT t FROM TipoEstudio t WHERE t.nombreComun LIKE %?1%" +
    "OR t.nombreDICOM LIKE %?1%" +
    "OR t.localizacionAnatomica LIKE %?1%"
  )
  public List<TipoEstudio> findAll(String palBuscarTipoEstudio);
}
