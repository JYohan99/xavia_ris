package xavia.ris.controlador;

import xavia.ris.modelo.TipoEstudio;
import xavia.ris.servicio.ITipoEstudioServicio;
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
public class ControlTipoEstudio {

  @Autowired
  private ITipoEstudioServicio servicio;

  @RequestMapping("/TipoEstudio")
  public String verTipoEstudio(
    Model model,
    @Param("palBuscarTipoEstudio") String palBuscarTipoEstudio
  ) {
    List<TipoEstudio> listaTipoEstudios = servicio.listarTipoEstudio(
      palBuscarTipoEstudio
    );

    model.addAttribute("tipoEstudios", listaTipoEstudios);
    model.addAttribute("palBuscarTipoEstudio", palBuscarTipoEstudio);
    return "TipoEstudio_Gestionar";
  }

  @RequestMapping("/paginaCrear")
  public String verTipoEstudio(Model model) {
    TipoEstudio tipoEstudio = new TipoEstudio();
    model.addAttribute("agregarTipoEstudioForm", tipoEstudio);
    return "TipoEstudio_Crear";
  }

  @PostMapping("/agregarTipoEstudio")
  public String agregarTipoEstudio(
    @ModelAttribute("agregarTipoEstudioForm") TipoEstudio tipoEstudio
  ) {
    servicio.agregarTipoEstudio(tipoEstudio);
    return "redirect:/TipoEstudio";
  }

  @GetMapping("/editarTipoEstudio/{id}")
  public ModelAndView editar(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("TipoEstudio_Crear");
    view.addObject("agregarTipoEstudioForm", servicio.buscarPorId(id));

    return view;
  }

  @GetMapping("/eliminarTipoEstudio/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/TipoEstudio";
  }
}
