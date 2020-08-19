/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.datos;

import co.com.gm.sga.domain.Persona;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author digital
 */
public class PersonaDaoImp implements PersonaDao {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPerson() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonId(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonEmail(Persona persona) {
        return (Persona) em.createNamedQuery("Persona.findEmail").getSingleResult();
    }

    @Override
    public void insertPerson(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePerson(Persona persona) {
        em.merge(persona);
     }

    @Override
    public void deletePerson(Persona persona) {
        em.remove(em.merge(persona));
    }

}
