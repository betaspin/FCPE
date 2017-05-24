package fr.imie.fcpe.service;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.fcpe.model.EtablissementBO;
import fr.imie.fcpe.service.EtablissementBU;

import java.util.List;

@Path("/etablissement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtablissementRest {

    @EJB
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
