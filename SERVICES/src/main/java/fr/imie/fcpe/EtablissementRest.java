package fr.imie.fcpe;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/etablissement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtablissementRest {

    @EJB
    IEtablissement etablissementService;

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
        etablissement = etablissementService.createEtablissement(etablissement);
        return Response.ok(etablissement).build();
    }

    @PUT
    public Response updateEtablissement(EtablissementBO etablissement){
        etablissement = etablissementService.updateEtablissement(etablissement);
        return Response.ok(etablissement).build();
    }

    @DELETE
    public Response deleteEtablissement(EtablissementBO etablissement){
        etablissement = etablissementService.deleteEtablissement(etablissement);
        return Response.ok(etablissement).build();
    }
}
