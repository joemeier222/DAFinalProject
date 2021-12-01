package tarleton.dafinalproject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import static tarleton.dafinalproject.Database.login;
import static tarleton.dafinalproject.Database.update;

/**
 *
 * @author Joe Meier
 */

@Path("account/{user}")
public class AccountWS {
    
    @GET
    @Produces("application/json")
    public Response read(@PathParam("user") String user) {
        Account acc = login(user);
        if (acc == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(acc).build();                
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAcc(@PathParam("user") String user, Account acc){
        update(user, acc);        
        return Response.ok(acc).build();
    }
}
