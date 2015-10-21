package be.company.webservices;

import be.company.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ldap")
@Produces(MediaType.APPLICATION_JSON)
public interface LdapWebService {

    @GET
    List<Person> getAll();

    @GET
    @Path("/{uid}")
    Person getPerson(@PathParam("uid") String uid);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void createPerson(Person person);

    @PUT
    @Path("/{uid}")
    void updatePerson(@PathParam("uid") String id, Person person);

    @DELETE
    @Path("/{uid}")
    void deletePerson(@PathParam("uid") String uid);

}