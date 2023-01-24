package xavia.ris.controlador;

import xavia.ris.modelo.Equipo;
import xavia.ris.servicio.IEquipoServicio;

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
import xavia.ris.modelo.Usuario;

@Controller
public class ControlEquipo {

    @Autowired
    private IEquipoServicio servicio;

    @RequestMapping("/Equipo")
    public ModelAndView verEquipo(
         @Param("palBuscarEquipo") String palBuscarEquipo
    ) {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("view", "Equipo_Gestionar");

        List<Equipo> listaEquipo = servicio.listarEquipo(palBuscarEquipo);

        model.addObject("equipos", listaEquipo);
        model.addObject("palBuscarEquipo", palBuscarEquipo);
        return model;
    }

    @GetMapping("/paginaEquipo_Agregar")
    public ModelAndView verEquipo() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("agregarEquipoForm", new Equipo());
        model.addObject("view", "Equipo_Agregar");
        return model;
    }
  
    @PostMapping("/agregarEquipo")
    public ModelAndView agregarEquipo(Equipo equipo, 
        @Param("palBuscarEquipo") 
        String palBuscarEquipo
    ) {
        
        try {
            servicio.agregarEquipo(equipo);
            ModelAndView model = new ModelAndView("Principal");

            List<Equipo> listaEquipo = servicio.listarEquipo(palBuscarEquipo);

            model.addObject("equipos", listaEquipo);
            model.addObject("view", "Equipo_Gestionar");
            model.addObject("palBuscarEquipo", palBuscarEquipo);
            model.addObject("mensaje","El equipo ha sido registrado satisfactoriamente");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("admitirEquipoForm", new Equipo());
            model.addObject("view", "Equipo_Agregar");
            model.addObject("mensaje","No se a registrado el equipo");
            return model;
        }
    }

    @GetMapping("/editarEquipo/{id}")
    public ModelAndView editar(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("agregarEquipoForm", servicio.buscarPorId(id));
        view.addObject("view", "Equipo_Agregar");
        return view;
    }

    @GetMapping("/eliminarEquipo/{id}")
    public String eliminar(@PathVariable(name = "id") Long id) {
        servicio.eliminarPorId(id);
        return "redirect:/Equipo";
    }
}
