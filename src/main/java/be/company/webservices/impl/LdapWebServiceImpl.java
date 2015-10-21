package be.company.webservices.impl;

import be.company.domain.Person;
import be.company.repository.PersonRepo;
import be.company.webservices.LdapWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Component("ldapWebService")
public class LdapWebServiceImpl implements LdapWebService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepo.findAll();
    }

    @Override
    public Person getPerson(@PathParam("uid") String uid) {
        return personRepo.findOne(query().where("objectclass").is("person").and("uid").is(uid));
    }

    @Override
    public void createPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void updatePerson(@PathParam("uid") String uid, Person person) {
        person.setUid(uid);
        personRepo.save(person);
    }

    @Override
    public void deletePerson(@PathParam("uid") String uid) {

    }
}
