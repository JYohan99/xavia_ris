package xavia.ris.repositorio;

import xavia.ris.modelo.Medico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepo extends JpaRepository<Medico, Long> {
  @Query(
    "SELECT m FROM Medico m WHERE m.nombre LIKE %?1%" +
    "OR m.apellido LIKE %?1%" +
    "OR m.especialidad LIKE %?1%" +
    "OR m.nIdentidadM LIKE %?1%"
  )
  public List<Medico> findAll(String palBuscarMedico);
}
