package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
@Entity
@Table(name = "eventos")
public class Eventos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEventos;
    
    @NotEmpty
    private String local;
    
    @NotEmpty
    private String visitante;
 
    @NotEmpty
    private String resultado;
    
  
}
