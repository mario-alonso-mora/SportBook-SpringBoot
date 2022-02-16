package mx.com.gm.dao;

import mx.com.gm.domain.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosDao extends JpaRepository<Eventos, Long>{
    
}
