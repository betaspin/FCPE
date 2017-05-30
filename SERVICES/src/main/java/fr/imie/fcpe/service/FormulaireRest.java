package fr.imie.fcpe.service;

import fr.imie.fcpe.model.FormulaireBO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/formulaire")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FormulaireRest {

    @EJB
    //ICRUD<FormulaireBO> formulaireService;
            FormulaireBU formulaireService;

    @GET
    public List<FormulaireBO> findAll(){
        return formulaireService.findAll();
    }

    @GET
    @Path("/{id}")
    public FormulaireBO findOne(@PathParam("id") Integer idFormulaire){
        return formulaireService.findOne(idFormulaire);
    }

    @POST
    public Response insertFormulaire(FormulaireBO formulaire){
        formulaire = formulaireService.create(formulaire);
        return Response.ok(formulaire).build();
    }

    @PUT
    public Response updateFormulaire(FormulaireBO formulaire){
        formulaire = formulaireService.update(formulaire);
        return Response.ok(formulaire).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFormulaire(@PathParam("id") Integer idFormulaire){
        FormulaireBO formulaire = formulaireService.delete(idFormulaire);
        return Response.ok(formulaire).build();
    }
}