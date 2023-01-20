package xavia.ris.controlador;

import xavia.ris.modelo.Equipo;
import xavia.ris.servicio.IEquipoServicio;
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
public class ControlEquipo {

  @Autowired
  private IEquipoServicio servicio;

  @RequestMapping("/Equipo")
  public ModelAndView verEquipo(
    ModelAndView view,
    @Param("palBuscarEquipo") String palBuscarEquipo
  ) {
    view.addObject("equipos", servicio.listarEquipo(palBuscarEquipo));

    view.setViewName("Principal");
        view.addObject("view", "Equipo_Gestionar");
        return view;
  }

  @GetMapping("/paginaEquipo_Agregar")
  public ModelAndView verEquipo() {
      ModelAndView model = new ModelAndView("Principal");
      model.addObject("agregarEquipoForm", new Equipo());
      model.addObject("view", "Equipo_Agregar");
      return model;
  }

/*   @RequestMapping("/paginaEquipo_Agregar")
  public String verEquipo(Model model) {
    Equipo equipo = new Equipo();
    model.addAttribute("agregarEquipoForm", equipo);
    return "Equipo_Agregar";
  } */

  @PostMapping("/agregarEquipo")
  public ModelAndView agregarEquipo(Equipo equipo) {
    servicio.agregarEquipo(equipo);
      ModelAndView model = new ModelAndView("Principal");
      model.addObject("view", "Equipo_Gestionar");
      return model;
  }

//  @PostMapping("/agregarEquipo")
//  public String agregarEquipo(
//    @ModelAttribute("agregarEquipoForm") Equipo equipo
//  ) {
//    servicio.agregarEquipo(equipo);
//    return "redirect:/Equipo";
//  }

@GetMapping("/editarEquipo/{id}")
public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {
    view.setViewName("Principal");
    view.addObject("agregarEquipoForm", servicio.buscarPorId(id));
    view.addObject("view", "Equipo_Agregar");
    return view;
}

/*   @GetMapping("/editarEquipo/{id}")
  public ModelAndView editar(
    @PathVariable(name = "id") Long id,
    ModelAndView view
  ) {
    view.setViewName("Equipo_Agregar");
    view.addObject("agregarEquipoForm", servicio.buscarPorId(id));

    return view;
  } */


/*   @GetMapping("/eliminarEquipo/{id}")
  public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
      service.eliminarPorId(id);
      view.setViewName("Principal");
      view.addObject("equipos", servicio.listarEquipo());
      view.addObject("view", "Equipo_Gestionar");
      return view;
  } */

  @GetMapping("/eliminarEquipo/{id}")
  public String eliminar(@PathVariable(name = "id") Long id) {
    servicio.eliminarPorId(id);
    return "redirect:/Equipo";
  }
}
