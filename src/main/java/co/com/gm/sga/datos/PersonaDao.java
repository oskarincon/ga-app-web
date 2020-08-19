/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.datos;

import co.com.gm.sga.domain.Persona;
import java.util.List;

/**
 *
 * @author digital
 */
public interface PersonaDao {
    
    public List<Persona> findAllPerson();
    
    public Persona findPersonId(Persona Persona);
    
    public Persona findPersonEmail(Persona Persona);
    
    public void insertPerson(Persona Persona);
    
    public void updatePerson(Persona Persona);
    
    public void deletePerson(Persona Persona);
}
