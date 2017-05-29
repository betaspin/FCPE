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

import fr.imie.fcpe.model.EtablissementBO;

@Path("/etablissement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtablissementRest {

    @EJB
    //ICRUD<EtablissementBO> etablissementService;
    EtablissementBU etablissementService;

    @GET
    public List<EtablissementBO> findAll(){
        return etablissementService.findAll();
    }

    @GET
    @Path("/{id}")
    public EtablissementBO findOne(@PathParam("id") Integer idEtablissement){
        return etablissementService.findOne(idEtablissement);
    }

    @POST
    public Response insertEtablissement(EtablissementBO etablissement){
        etablissement = etablissementService.create(etablissement);
        return Response.ok(etablissement).build();
    }

    @PUT
    public Response updateEtablissement(EtablissementBO etablissement){
        etablissement = etablissementService.update(etablissement);
        return Response.ok(etablissement).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEtablissement(@PathParam("id") Integer idEtablissement){
        EtablissementBO etablissement = etablissementService.delete(idEtablissement);
        return Response.ok(etablissement).build();
    }
}