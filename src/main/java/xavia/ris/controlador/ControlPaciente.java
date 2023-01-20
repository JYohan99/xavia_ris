package xavia.ris.controlador;

import xavia.ris.modelo.Paciente;
import xavia.ris.servicio.IPacienteServicio;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlPaciente {

  @Autowired
  private IPacienteServicio servicio;

  @RequestMapping("/Paciente")
  public String verPaciente(
    Model model,
    @Param("palBuscarPaciente") String palBuscarPaciente
  ) {
    List<Paciente> listarPaciente = servicio.listarPaciente(palBuscarPaciente);

    model.addAttribute("pacientes", listarPaciente);
    model.addAttribute("palBuscarPaciente", palBuscarPaciente);
    return "Paciente_Gestionar";
  }

  @RequestMapping("/paginaPaciente_Admitir")
  public String verPaciente(Model model) {
    Paciente paciente = new Paciente();
    model.addAttribute("admitirPacienteForm", paciente);
    return "Paciente_Admitir";
  }

  @PostMapping("/admitirPaciente")
  public String admitirPaciente(
    @ModelAttribute("admitirPacienteForm") Paciente paciente
  ) {
    servicio.admitirPaciente(paciente);
    return "redirect:/Paciente";
  }

  @GetMapping("/editarPaciente/{id}")
  public ModelAndView editarPaciente(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("Paciente_Admitir");
    view.addObject("admitirPacienteForm", servicio.buscarPorId(id));

    return view;
  }
}
