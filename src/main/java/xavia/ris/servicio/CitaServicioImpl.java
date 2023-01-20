package xavia.ris.servicio;


import xavia.ris.modelo.Cita;
import xavia.ris.repositorio.ICitaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaServicioImpl implements ICitaServicio {

  @Autowired
  private ICitaRepo repo;

  @Override
  public Cita agregarCita(Cita Cita) {
    return repo.save(Cita);
  }

  @Override
  public List<Cita> listarCita(String palBuscarCita) {
    if (palBuscarCita != null) {
      return repo.findAll(palBuscarCita);
    }
    return repo.findAll();
  }

  @Override
  public Cita buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
}
