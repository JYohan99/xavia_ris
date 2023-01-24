package xavia.ris.repositorio;

import xavia.ris.modelo.Equipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepo extends JpaRepository<Equipo, Long> {
  @Query(
    "SELECT e FROM Equipo e WHERE e.nombreEquipo LIKE %?1%" +
    "OR e.local LIKE %?1%" +
    "OR e.estadoOperacional LIKE %?1%"
  )
  public List<Equipo> findAll(String palBuscarEquipo);
}
