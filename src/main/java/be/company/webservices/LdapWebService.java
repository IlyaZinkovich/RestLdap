package be.company.webservices;

import be.company.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ldap")
@Produces(MediaType.APPLICATION_JSON)
public interface LdapWebService {

//    @GET
//    List<Person> getAll();

    @GET
    Person getAll();

    @GET
    @Path("/{id}")
    Person getPerson(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void createPerson(Person person);

    @PUT
    @Path("/{id}")
    void updatePerson(@PathParam("id") Long id, Person person);

    @DELETE
    @Path("/{id}")
    void deletePerson(@PathParam("id") Long id);

}