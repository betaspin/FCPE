package fr.imie.fcpe.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.fcpe.model.QuestionBO;

@Path("/question")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionRest {
	
    @EJB
    QuestionBU questionService;

    @GET
    public List<QuestionBO> findAll() {
    	return questionService.findAll();
    }

    @GET
    @Path("/{id}")
    public QuestionBO findOne(@PathParam("id") Integer idQuestion){
    	return questionService.findOne(idQuestion);
    }

    @POST
    public Response insertQuestion(QuestionBO question) {
        question = questionService.create(question);
        return Response.ok(question).build();
    }

    @PUT
    public Response updateQuestion(QuestionBO question){
        question = questionService.update(question);
        return Response.ok(question).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteQuestion(@PathParam("id") Integer idQuestion){
        QuestionBO question = questionService.delete(idQuestion);
        return Response.ok(question).build();
    }
}
