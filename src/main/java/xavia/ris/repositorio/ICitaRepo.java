package xavia.ris.repositorio;

import xavia.ris.modelo.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepo extends JpaRepository<Cita, Long> {
  @Query(
    "SELECT c FROM Cita c WHERE c.fechaCita LIKE %?1%"
  )
  public List<Cita> findAll(String palBuscarCita);
}
