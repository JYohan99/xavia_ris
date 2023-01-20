package xavia.ris.servicio;

import xavia.ris.modelo.Medico;
import xavia.ris.repositorio.IMedicoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServicioImpl implements IMedicoServicio {

  @Autowired
  private IMedicoRepo repo;

  @Override
  public Medico registrarMedico(Medico medico) {
    return repo.save(medico);
  }

  @Override
  public List<Medico> listarMedico(String palBuscarMedico) {
    if (palBuscarMedico != null) {
      return repo.findAll(palBuscarMedico);
    }
    return repo.findAll();
  }

  @Override
  public List<Medico> listarParaCitaMedico() {
    return repo.findAll();
  }

  @Override
  public Medico buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
}
