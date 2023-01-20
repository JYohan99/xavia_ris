package xavia.ris.servicio;

import xavia.ris.modelo.Equipo;
import xavia.ris.repositorio.IEquipoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoServicioImpl implements IEquipoServicio {

  @Autowired
  private IEquipoRepo repo;

  @Override
  public Equipo agregarEquipo(Equipo equipo) {
    return repo.save(equipo);
  }

  @Override
  public List<Equipo> listarEquipo(String palBuscarEquipo) {
    if (palBuscarEquipo != null) {
      return repo.findAll(palBuscarEquipo);
    }
    return repo.findAll();
  }

  @Override
  public List<Equipo> listarParaCitaEquipo() {
    return repo.findAll();
  }

  @Override
  public Equipo buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
}
