package xavia.ris.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlInfoInstitu {

  @RequestMapping("/infoInstitu")
  public String verInfoInstitu(Model model) {
    return "Información_de_la_Institución";
  }
}
