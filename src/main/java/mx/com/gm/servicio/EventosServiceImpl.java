package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.com.gm.dao.EventosDao;

@Service
public class EventosServiceImpl implements EventosService {

    @Autowired
    private EventosDao eventosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Eventos> listarEventos() {
        return (List<Eventos>) eventosDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Eventos eventos) {
        eventosDao.save(eventos);
    }

    @Override
    @Transactional
    public void eliminar(Eventos eventos) {
        eventosDao.delete(eventos);
    }

    @Override
    @Transactional(readOnly = true)
    public Eventos encontrarEventos(Eventos eventos) {
        return eventosDao.findById(eventos.getIdEventos()).orElse(null);
    }
}
