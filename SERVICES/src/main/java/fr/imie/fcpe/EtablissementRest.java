package fr.imie.fcpe;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/etablissement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtablissementRest {

    @EJB
    ICRUD<EtablissementBO> etablissementService;
    //EtablissementBU etablissementService;

    @GET
    public List<EtablissementWO> findAll(){
        List<EtablissementBO> etablissementsBO = etablissementService.findAll();
        List<EtablissementWO> etablissementsWO = new ArrayList<>();
        for(EtablissementBO etablissementBO : etablissementsBO) {
            etablissementsWO.add(EtablissementMap.mapEtablissementBOToEtablissementWO(etablissementBO));
        }
        return etablissementsWO;
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
