package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import mx.com.gm.servicio.EventosService;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private EventosService eventosService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var eventos = eventosService.listarEventos();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Eventos eventos){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Eventos eventos, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        eventosService.guardar(eventos);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idEventos}")
    public String editar(Eventos eventos, Model model){
        eventos = eventosService.encontrarEventos(eventos);
        model.addAttribute("eventos", eventos);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Eventos eventos){
        eventosService.eliminar(eventos);
        return "redirect:/";
    }
}
