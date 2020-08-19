/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.service;

import co.com.gm.sga.datos.PersonaDao;
import co.com.gm.sga.domain.Persona;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 *
 * @author digital
 */
@Stateless
@WebService(endpointInterface = "co.com.gm.sga.service.PersonaServiceWs")
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWs{
    
    @Inject
    private PersonaDao personaDao; 

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPerson();
    }

    @Override
    public Persona encontrarPersonaId(Persona persona) {
        System.out.println("encontrarPersonaId");
        return personaDao.findPersonId(persona);
    }

    @Override
    public Persona encontrarPersonaEmail(Persona persona) {
        System.out.println("encontrarPersonaEmail");
        return personaDao.findPersonEmail(persona);
    }

    @Override
    public void insertarPersona(Persona persona) {
        System.out.println("insertarPersona");
        personaDao.insertPerson(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        System.out.println("modificarPersona");
        personaDao.updatePerson(persona);
    }

    @Override
    public void borrarPersona(Persona persona) {
        System.out.println("borrarPersona");
        personaDao.deletePerson(persona);
    }
    
}
