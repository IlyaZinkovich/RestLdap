package be.company.repository;

import be.company.domain.Person;
import org.springframework.ldap.repository.LdapRepository;

import java.util.List;

public interface PersonRepo extends LdapRepository<Person> {

}
