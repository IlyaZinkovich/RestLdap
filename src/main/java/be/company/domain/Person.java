package be.company.domain;

import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entry(objectClasses = { "inetOrgPerson", "organizationalPerson", "person", "top" }, base = "ou=people")
public class Person implements Serializable {

    public Person() {
    }

    @Id
    private transient Name dn;

    @Attribute(name = "cn")
    @DnAttribute(value = "cn", index = 0)
    private String fullName;

    @Attribute(name = "uid")
    private String uniqueUserId;

    private String mail;

    @Attribute(name = "surname")
    private String surname;

    //    private String organizationalUnitName;
//    private String organizationName;
//    private String description;
//    private String jpegPhoto;
    //    private Boolean accountActive;
//    private String seeAlso;
//    private String telephoneNumber;
//    private String userPassword;

    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniqueUserId() {
        return uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", uniqueUserId='" + uniqueUserId + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
