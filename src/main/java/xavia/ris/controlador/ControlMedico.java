package xavia.ris.controlador;

import xavia.ris.modelo.Medico;
import xavia.ris.servicio.IMedicoServicio;
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

@Controller
public class ControlMedico {

    @Autowired
    private IMedicoServicio servicio;

    @RequestMapping("/Medico")
    public ModelAndView verMedico(
        @Param("palBuscarMedico") String palBuscarMedico
    ) {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("view", "Medico_Gestionar");

        List<Medico> listaMedico = servicio.listarMedico(palBuscarMedico);

        model.addObject("medicos", listaMedico);
        model.addObject("palBuscarMedico", palBuscarMedico);
        return model;
    }

    @GetMapping("/paginaMedico_Registrar")
    public ModelAndView verMedicoRegistrar() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("registrarMedicoForm", new Medico());
        model.addObject("view", "Medico_Registrar");
        return model;
    }
    
  
    @PostMapping("/registrarMedico")
    public ModelAndView registrarMedico(Medico medico, 
        @Param("palBuscarMedico") 
        String palBuscarMedico
    ) {
        
        try {
            servicio.registrarMedico(medico);
            ModelAndView model = new ModelAndView("Principal");

            List<Medico> listaMedico = servicio.listarMedico(palBuscarMedico);

            model.addObject("medicos", listaMedico);
            model.addObject("view", "Medico_Gestionar");
            model.addObject("palBuscarEquipo", palBuscarMedico);
            model.addObject("mensaje","El médico fue registrado satisfactoriamente");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("registrarMedicoForm", new Medico());
            model.addObject("view", "Medico_Registrar");
            model.addObject("mensaje","El número de identidad existe ya");
            return model;
        }
    }

    @GetMapping("/editarMedico/{id}")
    public ModelAndView editarMedico(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("registrarMedicoForm", servicio.buscarPorId(id));
        view.addObject("view", "Medico_Registrar");
        return view;
    }

    @GetMapping("/eliminarMedico/{id}")
    public String eliminar(@PathVariable(name = "id") Long id) {
        servicio.eliminarPorId(id);
        return "redirect:/Medico";
    }
}
