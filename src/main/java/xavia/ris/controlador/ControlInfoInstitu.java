package xavia.ris.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlInfoInstitu {

  @GetMapping("/infoInstitu")
  public ModelAndView formulario() {
      ModelAndView model = new ModelAndView("Principal");
      model.addObject("view", "Información_de_la_Institución");
      return model;
  }
  /* @RequestMapping("/infoInstitu")
  public String verInfoInstitu(Model model) {
    return "Información_de_la_Institución";
  } */
}
