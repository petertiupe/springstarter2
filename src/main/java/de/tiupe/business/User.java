package de.tiupe.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

// Hibernate Annotation
@Entity
public class User {

    // Hibernate-Annotation, um das Objekt zu erzeugen.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nachname;
    private String vorname;
    @Size(min = 4)
    private String username;
    private String passwort;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
