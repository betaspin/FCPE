package fr.imie.fcpe.service;

import fr.imie.fcpe.mapping.QuestionMap;
import fr.imie.fcpe.model.QuestionBO;
import fr.imie.fcpe.model.QuestionJson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/question")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionRest {
	
    @EJB
    QuestionBU questionService;

    @GET
    public List<QuestionJson> findAll() {
        List<QuestionBO> questionsBO = questionService.findAll();

        List<QuestionJson> questionsJson = new ArrayList<>();
        for ( QuestionBO questionB : questionsBO ) {
            QuestionJson questionJ = QuestionMap.mapQuestionBOToJson(questionB);
            questionsJson.add(questionJ);
        }

    	return questionsJson;
    }

    @GET
    @Path("/{id}")
    public QuestionJson findOne(@PathParam("id") Integer idQuestion){
        QuestionJson questionJ = QuestionMap.mapQuestionBOToJson(questionService.findOne(idQuestion));
        return questionJ;
    }

    @POST
    public Response insertQuestion(QuestionJson questionJson) {
        QuestionBO questionBO = QuestionMap.mapQuestionJsonToBO(questionJson);
        questionBO = questionService.create(questionBO);
        return Response.ok(questionBO).build();
    }

    @PUT
    public Response updateQuestion(QuestionJson questionJson) {
        QuestionBO questionBO = QuestionMap.mapQuestionJsonToBO(questionJson);
        questionBO = questionService.update(questionBO);
        return Response.ok(questionBO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteQuestion(@PathParam("id") Integer idQuestion){
        QuestionBO question = questionService.delete(idQuestion);
        return Response.ok(question).build();
    }
}
