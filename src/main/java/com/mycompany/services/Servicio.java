/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entidad.Persona;
import static java.lang.Double.sum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */
@Path("service")
public class Servicio {
    private static final Map<Integer, Persona> personas = new HashMap<>();
    static{
        for (int i = 0; i < 10; i++) {
            Persona persona= new Persona();
            int id = i+1;
            persona.setId(id);
            persona.setNombre("Maravillosa persona " + id);
            persona.setEdad((int) (Math.random() * 60 + 1));
            persona.setSalario(persona.getEdad()*100/3);
            personas.put(id, persona);
        }
    }
    
    @GET
    @Path("/getAllPersonsXml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getAllPersonsXml(){
        return new ArrayList<>(personas.values());
    }
    
    @GET
    @Path("/getAllPersonsJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getAllPersonsJson(){
        return new ArrayList<>(personas.values());
    }
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersonByIdXML(@PathParam("id") int id){
        return personas.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonByIdJson(@PathParam("id") int id){
        return personas.get(id);
    }
    
    @GET
    @Path("/getPersonSalaryByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getPersonSalaryByIdJson(@PathParam("id") int id){
        return personas.get(id).getSalario();
    }
    
    @GET
    @Path("/getSumOfAllSalariesJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumOfAllSalariesJSON(){
        double sum=0;
        for(Persona p:personas.values()){
            sum+=p.getSalario();
        }
        return sum+"";
    }
    
    @POST
    @Path("/addPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persona addPerson(Persona persona){
        System.out.println(persona);
        personas.put(persona.getId(), persona);
        return persona;
    
    }
    
    
    
    
}
