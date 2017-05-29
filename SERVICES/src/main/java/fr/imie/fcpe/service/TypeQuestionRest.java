package fr.imie.fcpe.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.imie.fcpe.model.TypeQuestionBO;
import fr.imie.fcpe.service.TypeQuestionBU;

@Path("/typequestion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TypeQuestionRest {
	
    @EJB
    TypeQuestionBU typeQuestionService;

    @GET
    public List<TypeQuestionBO> findAll(){
        return typeQuestionService.findAll();
    }

    @GET
    @Path("/{id}")
    public TypeQuestionBO findOne(@PathParam("id") Integer idTypeQuestion){
        return typeQuestionService.findOne(idTypeQuestion);
    }

}
