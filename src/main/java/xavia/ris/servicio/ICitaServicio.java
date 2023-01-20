package xavia.ris.servicio;


import xavia.ris.modelo.Cita;
import java.util.List;

public interface ICitaServicio {
  public Cita agregarCita(Cita cita);

  public List<Cita> listarCita(String palBuscarCita);

  public void eliminarPorId(Long id);

  public Cita buscarPorId(Long id);
}
