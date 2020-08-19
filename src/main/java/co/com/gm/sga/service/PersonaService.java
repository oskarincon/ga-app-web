/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.service;

import co.com.gm.sga.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author digital
 */
@Local
public interface PersonaService {
    public List<Persona> listarPersonas();
    
    public Persona encontrarPersonaId(Persona persona);
    
    public Persona encontrarPersonaEmail(Persona persona);
    
    public void insertarPersona(Persona persona);
    
    public void modificarPersona(Persona persona);
    
    public void borrarPersona(Persona persona);
}
