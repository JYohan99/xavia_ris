package xavia.ris.controlador;

import xavia.ris.modelo.Cita;
import xavia.ris.modelo.Equipo;
import xavia.ris.modelo.Medico;
import xavia.ris.modelo.TipoEstudio;
import xavia.ris.servicio.ICitaServicio;
import xavia.ris.servicio.IEquipoServicio;
import xavia.ris.servicio.IPacienteServicio;
import xavia.ris.servicio.ITipoEstudioServicio;
import xavia.ris.servicio.IMedicoServicio;
import java.util.List;
import javax.servlet.http.HttpSession;
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
public class ControlCita {

    @Autowired
    public ICitaServicio servicio;

    @Autowired
    public IEquipoServicio equipo;

    @Autowired
    public ITipoEstudioServicio tipoEstudio;

    @Autowired
    public IMedicoServicio medico;

    @Autowired
    public IPacienteServicio paciente;

    @RequestMapping("/Cita")
    public ModelAndView verCita(
        @Param("palBuscarCita") String palBuscarCita
    ) {
        ModelAndView model = new ModelAndView("Principal");
        model.addObject("view", "Cita_Gestionar");
        List<Cita> listaCita = servicio.listarCita(palBuscarCita);
        
        model.addObject("citas", listaCita);
        model.addObject("palBuscarCita", palBuscarCita);
        return model;
    }

    @GetMapping("/paginaCita_Agregar/{id}")
    public ModelAndView reyenarCita(@PathVariable(name = "id") Long id, ModelAndView view, HttpSession session){
        ModelAndView model = new ModelAndView("Principal");
        session.setAttribute("idPaciente", id);
        
        List<Equipo> listarParaCitaEquipo = equipo.listarParaCitaEquipo();
        List<TipoEstudio> listarParaCitaTipoEstudio = tipoEstudio.listarParaCitaTipoEstudio();
        List<Medico> listarParaCitaMedico = medico.listarParaCitaMedico();
        
        model.addObject("listaEquipo", listarParaCitaEquipo);
        model.addObject("listaTipoEstudio", listarParaCitaTipoEstudio);
        model.addObject("listaMedico", listarParaCitaMedico);
        model.addObject("agregarCitaForm", new Cita());
        model.addObject("view", "Cita_Agregar");
        return model;
    }

    @PostMapping("/agregarCita")
    public String agregarCita(
        @ModelAttribute("agregarCitaForm") Cita cita, HttpSession session
    ) {
        Long id = (Long) session.getAttribute("idPaciente");

        cita.setPaciente(paciente.buscarPorId(id));
        servicio.agregarCita(cita);
        return "redirect:/Cita";
    }

    @GetMapping("/editarCita/{id}")
    public ModelAndView editarCita(@PathVariable(name = "id") Long id, ModelAndView view) {

        List<Equipo> listarParaCitaEquipo = equipo.listarParaCitaEquipo();
        List<TipoEstudio> listarParaCitaTipoEstudio = tipoEstudio.listarParaCitaTipoEstudio();
        List<Medico> listarParaCitaMedico = medico.listarParaCitaMedico();

        view.addObject("listaEquipo", listarParaCitaEquipo);
        view.addObject("listaTipoEstudio", listarParaCitaTipoEstudio);
        view.addObject("listaMedico", listarParaCitaMedico);
        view.setViewName("Principal");
        view.addObject("agregarCitaForm", servicio.buscarPorId(id));
        view.addObject("view", "Cita_Agregar");
        return view;
    }

    @GetMapping("/eliminarCita/{id}")
    public String eliminar(@PathVariable(name = "id") Long id) {
        servicio.eliminarPorId(id);
        return "redirect:/Cita";
    }
}
