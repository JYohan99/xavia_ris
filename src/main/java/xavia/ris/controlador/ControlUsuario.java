package xavia.ris.controlador;

import xavia.ris.modelo.Usuario;
import xavia.ris.servicio.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xavia.ris.modelo.Paciente;

@Controller
public class ControlUsuario {

    @Autowired
    private IUsuarioService servicio;

    @RequestMapping("/Usuario")
    public ModelAndView verUsuario(
      @Param("palBuscarUsuario") String palBuscarUsuario
    ) {
      ModelAndView model = new ModelAndView("Principal");
      model.addObject("view", "Usuario_Gestionar");
  
      List<Usuario> listaUsuario = servicio.listarUsuario(palBuscarUsuario);
  
      model.addObject("usuarios", listaUsuario);
      model.addObject("palBuscarUsuario", palBuscarUsuario);
      return model;
    }

    @GetMapping("/paginaUsuario_Registrar")
    public ModelAndView verUsuarioRegistrar() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("registrarUsuarioForm", new Usuario());
        model.addObject("view", "Usuario_Registrar");
        return model;
    }

    @PostMapping("/registrarUsuario")
    public ModelAndView registrarUsuario(Usuario userName, 
        @Param("palBuscarUsuario") 
        String palBuscarUsuario
    ) {
        
        try {
            servicio.registrarUsuario(userName);
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("view", "Usuario_Gestionar");
            List<Usuario> listaUsuario = servicio.listarUsuario(palBuscarUsuario);
            model.addObject("usuarios", listaUsuario);
            model.addObject("palBuscarUsuario", palBuscarUsuario);
            model.addObject("mensaje","Usuario creado satisfactoriamente");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("mensaje","El correo existe ya");            
            model.addObject("registrarUsuarioForm", new Usuario());
            model.addObject("view", "Usuario_Registrar");
            return model;
        }
    }

    @GetMapping("/editarUsuario/{id}")
    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("registrarUsuarioForm", servicio.findById(id));
        view.addObject("view", "Usuario_Registrar");
        return view;
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(@PathVariable(name = "id") Long id) {
      servicio.eliminar(id);
      return "redirect:/Usuario";
    }
}
