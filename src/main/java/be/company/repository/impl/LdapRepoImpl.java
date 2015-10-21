package be.company.repository.impl;

import be.company.domain.Person;
import be.company.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;


public class LdapRepoImpl {

    @Autowired
    private LdapTemplate ldapTemplate;

    public Person create(Person person) {
        ldapTemplate.create(person);
        return person;
    }

    public Person findByUid(String uid) {
        return ldapTemplate.findOne(query().where("uid").is(uid), Person.class);
    }

    public void update(Person person) {
        ldapTemplate.update(person);
    }

    public void delete(Person person) {
        ldapTemplate.delete(person);
    }

    public List<Person> findAll() {
        return ldapTemplate.findAll(Person.class);
    }

    public List<Person> findByLastName(String lastName) {
        return ldapTemplate.find(query().where("sn").is(lastName), Person.class);
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        PersonRepo personRepo = (PersonRepo) applicationContext.getBean("personRepo");
//        Person person = new Person();
////        person.setAccountActive(true);
//        person.setFullName("Bob Person");
//        person.setSurname("Person");
//        System.out.println(personRepo.findOne(LdapNameBuilder.newInstance().add("dc", "company").add("dc", "be").add("cn", "Bob Person").build()));
//
////        for (Person p : personRepo.findAll()) {
////            System.out.println(p);
////        }
//
//
////        System.out.println(personRepo.findAll());
//
////        LdapName ldapName = LdapUtils.newLdapName("ou=people,dc=company,dc=be");
////        LdapName bobPerson = LdapNameBuilder.newInstance(ldapName).add("uid", "unique_user_id").build();
////
////        String uid = LdapUtils.getStringValue(bobPerson, "uid");
////        System.out.println(uid);
//    }

}
