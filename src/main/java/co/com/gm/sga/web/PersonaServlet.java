/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.sga.web;

import co.com.gm.sga.domain.Persona;
import co.com.gm.sga.service.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/persona")
public class PersonaServlet extends HttpServlet {
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Persona> persona = personaService.listarPersonas();
        System.out.println("persona: " + persona);
        request.setAttribute("personas", persona);
        request.getRequestDispatcher("/listadoPersona.jsp").forward(request, response);
    }
}
