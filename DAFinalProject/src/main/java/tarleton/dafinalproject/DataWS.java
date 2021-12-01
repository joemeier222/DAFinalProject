package tarleton.dafinalproject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import static tarleton.dafinalproject.Database.readData;

/**
 *
 * @author Joe Meier
 */
@Path("data/{user}")
public class DataWS {
    @GET
    @Produces("application/json")
    public Response read(@PathParam("user") String user) {
        Data[] dataSet = readData(user);
        if (dataSet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }        
        return Response.ok(dataSet).build();                
    }
}
