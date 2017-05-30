package fr.imie.fcpe.service;

import fr.imie.fcpe.model.AdministrateurBO;
import fr.imie.fcpe.model.QuestionBO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authenticate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticateRest {
	
    @EJB
    AdministrateurBU adminService;

    @POST
    public Response login(AdministrateurBO admin) {
        admin = adminService.findOneByAuth(admin);
        if(admin != null) {
            return Response.ok(admin).build();
        }else{
            return Response.noContent().build();
        }
    }
}
