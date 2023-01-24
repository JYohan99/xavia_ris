package xavia.ris.servicio;

import xavia.ris.modelo.TipoEstudio;
import xavia.ris.repositorio.ITipoEstudioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEstudioServicioImpl implements ITipoEstudioServicio {

  @Autowired
  private ITipoEstudioRepo repo;

  @Override
  public TipoEstudio agregarTipoEstudio(TipoEstudio tipoEstudio) {
    return repo.save(tipoEstudio);
  }

  @Override
  public List<TipoEstudio> listarTipoEstudio(String palBuscarTipoEstudio) {
    if (palBuscarTipoEstudio != null) {
      return repo.findAll(palBuscarTipoEstudio);
    }
    return repo.findAll();
  }

  @Override
  public List<TipoEstudio> listarParaCitaTipoEstudio() {
    return repo.findAll();
  }

  @Override
  public TipoEstudio buscarPorId(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void eliminarPorId(Long id) {
    repo.deleteById(id);
  }
}
