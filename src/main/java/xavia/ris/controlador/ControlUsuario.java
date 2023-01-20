package xavia.ris.controlador;

import xavia.ris.modelo.Usuario;
import xavia.ris.servicio.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlUsuario {

    @Autowired
    private IUsuarioService servicio;

    @GetMapping("/Usuario")
    public ModelAndView listar(ModelAndView view) {
        view.addObject("usuarios", servicio.findAll());
        view.setViewName("Principal");
        view.addObject("view", "Usuario_Gestionar");
        return view;
    }

    @GetMapping("/paginaUsuario_Registrar")
    public ModelAndView verUsuarioRegistrar() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("registrarUsuarioForm", new Usuario());
        model.addObject("view", "Usuario_Registrar");
        return model;
    }

    @PostMapping("/registrarUsuario")
    public ModelAndView registrarUsuario(Usuario usuario, ModelAndView view) {
        servicio.salvar(usuario);
        view.addObject("usuarios", servicio.findAll());
        view.setViewName("Principal");
        view.addObject("view", "Usuario_Gestionar");
        return view;
    }

    @GetMapping("/eliminarUsuario/{id}")
    public ModelAndView eliminar(@PathVariable(name = "id") Long id, ModelAndView view) {
        servicio.eliminar(id);
        view.addObject("usuarios", servicio.findAll());
        view.setViewName("Principal");
        view.addObject("view", "Usuario_Gestionar");
        return view;
    }

    @GetMapping("/editarUsuario/{id}")
    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("registrarUsuarioForm", servicio.findById(id));
        view.addObject("view", "Usuario_Registrar");
        return view;
    }

}
