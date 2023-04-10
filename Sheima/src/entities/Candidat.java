/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sheima
 */
public class Candidat {
    private int idCandidat,idOffre;
    private String firstname,lastname,email,description;    

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Candidat(int idCandidat, int idOffre, String firstname, String lastname, String email, String description) {
        this.idCandidat = idCandidat;
        this.idOffre = idOffre;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.description = description;
    }

    public Candidat() {
    }

    @Override
    public String toString() {
        return "Candidat{" + "idCandidat=" + idCandidat + ", idOffre=" + idOffre + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", description=" + description + '}';
    }

   
    
}
