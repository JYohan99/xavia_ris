package xavia.ris.repositorio;

import xavia.ris.modelo.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Long> {
  @Query(
    "SELECT p FROM Paciente p WHERE p.nombre LIKE %?1%" +
    "OR p.apellido LIKE %?1%" +
    "OR p.fechaNacimiento LIKE %?1%" +
    "OR p.nIdentidadP LIKE %?1%" +
    "OR p.sexo LIKE %?1%"
  )
  public List<Paciente> findAll(String palBuscarPaciente);
}
