package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Eventos;

public interface EventosService {
    
    public List<Eventos> listarEventos();
    
    public void guardar(Eventos eventos);
    
    public void eliminar(Eventos eventos);
    
    public Eventos encontrarEventos(Eventos eventos);
}
