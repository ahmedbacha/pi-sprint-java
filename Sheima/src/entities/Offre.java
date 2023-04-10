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
public class Offre {
    private int idOffre;
private String description,proprietaire;
    

public Offre() {
    }

    public Offre(int idOffre, String description, String proprietaire) {
        this.idOffre = idOffre;
        this.description = description;
        this.proprietaire = proprietaire;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return "Offre{" + "idOffre=" + idOffre + ", description=" + description + ", proprietaire=" + proprietaire + '}';
    }
    
    
}
