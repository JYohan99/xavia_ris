package xavia.ris.servicio;

import xavia.ris.modelo.Paciente;
import xavia.ris.repositorio.IPacienteRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServicioImpl implements IPacienteServicio {

  @Autowired
  private IPacienteRepo repo;

  @Override
  public Paciente admitirPaciente(Paciente paciente) {
    return repo.save(paciente);
  }

  @Override
  public List<Paciente> listarPaciente(String palBuscarPaciente) {
    if (palBuscarPaciente != null) {
      return repo.findAll(palBuscarPaciente);
    }
    return repo.findAll();
  }

  @Override
  public Paciente buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
  /*   @Override
  public List<Paciente> listarParaCitaPaciente() {
    return repo.findAll();
  } */
}
