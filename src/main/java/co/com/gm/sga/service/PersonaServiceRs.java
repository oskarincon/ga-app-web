/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.service;

import co.com.gm.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author digital
 */

@Path("/personas")
@Stateless
public class PersonaServiceRs {
    
    @Inject
    private PersonaService personaService;
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas(){
        return personaService.listarPersonas();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Persona listarPersonaId(@PathParam("id") int id){
         Persona persona = personaService.encontrarPersonaId(new Persona(id));
         return personaService.encontrarPersonaId(persona);
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarPersona(Persona persona){
        try{
            personaService.insertarPersona(persona);
            return Response.ok().entity(persona).build();
        }catch(Exception e){
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersonas(@PathParam("id") int id, Persona personaModificada){
        Persona persona = personaService.encontrarPersonaId(new Persona(id));
        if(persona != null){
            try{
               personaService.modificarPersona(personaModificada);
               return Response.ok().entity(personaModificada).build();
            } catch(Exception e){
                e.printStackTrace(System.out);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response borrarPersona(@PathParam("id") int id){
        try{
          personaService.borrarPersona(new Persona(id));
          return Response.ok().entity(new Persona(id)).build();
        } catch(Exception e){
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
