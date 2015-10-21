package be.company.webservices.impl;

import be.company.domain.Person;
import be.company.repository.PersonRepo;
import be.company.webservices.LdapWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component("ldapWebService")
public class LdapWebServiceImpl implements LdapWebService {

    @Autowired
    private PersonRepo personRepo;

//    @Override
//    public List<Person> getAll() {
//        return (List<Person>) personRepo.findAll();
//    }

    @Override
    public Person getAll() {
        throw new RuntimeException("everything is ok");
//        return ((List<Person>)personRepo.findAll()).get(0);
    }

    @Override
    public Person getPerson(@PathParam("id") Long id) {
        return null;
    }

    @Override
    public void createPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void updatePerson(@PathParam("id") Long id, Person person) {

    }

    @Override
    public void deletePerson(@PathParam("id") Long id) {

    }
}
