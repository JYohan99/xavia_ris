package xavia.ris.servicio;

import xavia.ris.modelo.TipoEstudio;
import java.util.List;

public interface ITipoEstudioServicio {
  public TipoEstudio agregarTipoEstudio(TipoEstudio tipoEstudio);

  public List<TipoEstudio> listarTipoEstudio(String palBuscarTipoEstudio);

  public List<TipoEstudio> listarParaCitaTipoEstudio();

  public void eliminarPorId(Long id);

  public TipoEstudio buscarPorId(Long id);
}
