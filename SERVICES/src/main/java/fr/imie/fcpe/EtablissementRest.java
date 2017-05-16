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
    IEtabllissement etablissementService;

    @GET
    public List<EtablissementBO> findAll(){
        return etablissementService.findAll();
    }

    @POST
    public Response insertEtablissement(EtablissementBO etablissementBO){
        etablissementBO = etablissementService.createEtablissement(etablissementBO);
        return Response.ok(etablissementBO).build();
    }
}
