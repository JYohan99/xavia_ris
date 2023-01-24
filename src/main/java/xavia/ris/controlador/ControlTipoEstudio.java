package xavia.ris.controlador;

import xavia.ris.modelo.TipoEstudio;
import xavia.ris.servicio.ITipoEstudioServicio;
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
import xavia.ris.modelo.Equipo;

@Controller
public class ControlTipoEstudio {

    @Autowired
    private ITipoEstudioServicio servicio;

    @RequestMapping("/TipoEstudio")
    public ModelAndView verTipoEstudio(
        @Param("palBuscarTipoEstudio") String palBuscarTipoEstudio
    ) {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("view", "TipoEstudio_Gestionar");
        List<TipoEstudio> listaTipoEstudio = servicio.listarTipoEstudio(palBuscarTipoEstudio);

        model.addObject("tipoEstudios", listaTipoEstudio);
        model.addObject("palBuscarTipoEstudio", palBuscarTipoEstudio);
        return model;
    }

    @GetMapping("/paginaCrear")
    public ModelAndView agregarTipoEstudio() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("agregarTipoEstudioForm", new TipoEstudio());
        model.addObject("view", "TipoEstudio_Crear");
        return model;
    }

    @PostMapping("/agregarTipoEstudio")
    public ModelAndView agregarTipoEstudio(TipoEstudio tipoEstudio, 
        @Param("palBuscarTipoEstudio") 
        String palBuscarTipoEstudio
    ) {
        
        try {
            servicio.agregarTipoEstudio(tipoEstudio);
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("view", "TipoEstudio_Gestionar");
            List<TipoEstudio> listaTipoEstudio = servicio.listarTipoEstudio(palBuscarTipoEstudio);
            model.addObject("tipoEstudios", listaTipoEstudio);
            model.addObject("palBuscarTipoEstudio", palBuscarTipoEstudio);
            model.addObject("mensaje","El tipo de estudio ha sido registrado satisfactoriamente");
            return model;
        } catch (Exception e) {
            
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("agregarTipoEstudioForm", new TipoEstudio());
            model.addObject("view", "TipoEstudio_Crear");
            model.addObject("mensaje","No se a registrado el Tipo de estudio");
            return model;
        }
    }

    @GetMapping("/editarTipoEstudio/{id}")
    public ModelAndView editarTipoEstudio(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("agregarTipoEstudioForm", servicio.buscarPorId(id));
        view.addObject("view", "TipoEstudio_Crear");
        return view;
    }

    @GetMapping("/eliminarTipoEstudio/{id}")
    public String eliminar(@PathVariable(name = "id") Long id) {
        servicio.eliminarPorId(id);
        return "redirect:/TipoEstudio";
    }
}
