package xavia.ris.controlador;

import xavia.ris.modelo.Cita;
import xavia.ris.modelo.Equipo;
import xavia.ris.modelo.Medico;
import xavia.ris.modelo.TipoEstudio;
import xavia.ris.servicio.ICitaServicio;
import xavia.ris.servicio.IEquipoServicio;
import xavia.ris.servicio.IPacienteServicio;
import xavia.ris.servicio.ITipoEstudioServicio;
import xavia.ris.servicio.IMedicoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlCita {

  @Autowired
  public ICitaServicio servicio;

  @Autowired
  public IEquipoServicio equipo;

  @Autowired
  public ITipoEstudioServicio tipoEstudio;

  @Autowired
  public IMedicoServicio medico;

  @Autowired
  public IPacienteServicio paciente;

  @RequestMapping("/Cita")
  public String verCita(
    Model model,
    @Param("palBuscarCita") String palBuscarCita
  ) {
    List<Cita> listaCita = servicio.listarCita(palBuscarCita);

    model.addAttribute("citas", listaCita);
    model.addAttribute("palBuscarCita", palBuscarCita);
    return "Cita_Gestionar";
  }

  /*     @RequestMapping("/paginaCita_Agregar/{id}")
  public String reyenarCita(@PathVariable("id") Long idPaciente, Model model) {
    Cita cita = new Cita();
    List<Paciente> listarParaCitaPaciente = paciente.listarParaCitaPaciente(
      idPaciente
    );
    List<Equipo> listarParaCitaEquipo = equipo.listarParaCitaEquipo();
    List<TipoEstudio> listarParaCitaTipoEstudio = tipoEstudio.listarParaCitaTipoEstudio();
    List<Medico> listarParaCitaMedico = medico.listarParaCitaMedico();

    model.addAttribute("agregarCitaForm", cita);
    model.addAttribute("listaPaciente", listarParaCitaPaciente);
    model.addAttribute("listaEquipo", listarParaCitaEquipo);
    model.addAttribute("listaTipoEstudio", listarParaCitaTipoEstudio);
    model.addAttribute("listaMedico", listarParaCitaMedico);
    return "Cita_Agregar";
  } */

  @RequestMapping("/paginaCita_Agregar/{id}")
  public String reyenarCita(@PathVariable("id") Long idPaciente, Model model) {
    paciente.buscarPorId(idPaciente);
    Cita cita = new Cita();

    List<Equipo> listarParaCitaEquipo = equipo.listarParaCitaEquipo();
    List<TipoEstudio> listarParaCitaTipoEstudio = tipoEstudio.listarParaCitaTipoEstudio();
    List<Medico> listarParaCitaMedico = medico.listarParaCitaMedico();

    model.addAttribute("idPaciente", paciente);
    model.addAttribute("agregarCitaForm", cita);
    model.addAttribute("listaEquipo", listarParaCitaEquipo);
    model.addAttribute("listaTipoEstudio", listarParaCitaTipoEstudio);
    model.addAttribute("listaMedico", listarParaCitaMedico);
    return "Cita_Agregar";
  }

  @PostMapping("/agregarCita")
  public String agregarCita(@ModelAttribute Cita cita) {
    servicio.agregarCita(cita);
    return "redirect:/paginaCita_Agregar";
  }

  @RequestMapping("/editarCita/{id}")
  public String editarCita(@PathVariable("id") Long idCliente, Model model) {
    Cita cita = servicio.buscarPorId(idCliente);
    List<Equipo> listarParaCitaEquipo = equipo.listarParaCitaEquipo();
    List<TipoEstudio> listarParaCitaTipoEstudio = tipoEstudio.listarParaCitaTipoEstudio();
    List<Medico> listarParaCitaMedico = medico.listarParaCitaMedico();

    model.addAttribute("agregarCitaForm", cita);
    model.addAttribute("listaEquipo", listarParaCitaEquipo);
    model.addAttribute("listaTipoEstudio", listarParaCitaTipoEstudio);
    model.addAttribute("listaMedico", listarParaCitaMedico);
    return "Cita_Agregar";
  }

  @GetMapping("/eliminarCita/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/Cita";
  }
}
