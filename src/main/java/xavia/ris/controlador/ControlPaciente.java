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
    public ModelAndView verPaciente(
      @Param("palBuscarPaciente") String palBuscarPaciente
    ) {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("view", "Paciente_Gestionar");

        List<Paciente> listaPaciente = servicio.listarPaciente(palBuscarPaciente);

        model.addObject("pacientes", listaPaciente);
        model.addObject("palBuscarPaciente", palBuscarPaciente);
        return model;
    }

    @GetMapping("/paginaPaciente_Admitir")
    public ModelAndView verPaciente() {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("admitirPacienteForm", new Paciente());
        model.addObject("view", "Paciente_Admitir");
        return model;
    }
  
    @PostMapping("/admitirPaciente")
    public ModelAndView admitirPaciente(Paciente paciente, 
        @Param("palBuscarPaciente") 
        String palBuscarPaciente
    ) {
        
        try {
            servicio.admitirPaciente(paciente);
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("view", "Paciente_Gestionar");
            List<Paciente> listaPaciente = servicio.listarPaciente(palBuscarPaciente);
            model.addObject("pacientes", listaPaciente);
            model.addObject("palBuscarPaciente", palBuscarPaciente);
            model.addObject("mensaje","El paciente ha sido admitido satisfactoriamente");
            return model;
        } catch (Exception e) {
            ModelAndView model = new ModelAndView("Principal");
            model.addObject("admitirPacienteForm", new Paciente());
            model.addObject("view", "Paciente_Admitir");
            model.addObject("mensaje","El número de identidad del paciente ya existe");
            return model;
        }
    }

    @GetMapping("/editarPaciente/{id}")
    public ModelAndView editarPaciente(@PathVariable(name = "id") Long id, ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("admitirPacienteForm", servicio.buscarPorId(id));
        view.addObject("view", "Paciente_Admitir");
        return view;
    }

    @GetMapping("/Ficha")
    public ModelAndView verFicha(ModelAndView view) {
        view.setViewName("Principal");
        view.addObject("view", "Ficha Clínica");
        return view;
    }
}
