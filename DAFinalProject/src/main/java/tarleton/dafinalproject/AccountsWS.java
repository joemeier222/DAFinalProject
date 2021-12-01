package tarleton.dafinalproject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import static tarleton.dafinalproject.Database.insert;
import static tarleton.dafinalproject.Database.validUser;
/**
 *
 * @author Joe Meier
 */

@Path("accounts")
public class AccountsWS {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Account acc) {
        if(validUser(acc.getUsername())){
            return Response.status(Response.Status.CONFLICT).build();
        }
        insert(acc);
        return Response.ok(acc).build();
    }
}
