package entities;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class document {
    private int id;
    private String nom,type,editeur,url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    private String image;


    public document() {
    }

    public document(int id) {
        this.id = id;
    }
public document(int id, String nom, String type, String editeur, String image,String url) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.editeur = editeur;
        this.image = image;
        this.url=url;
    }
    public document(int id, String nom, String type, String editeur, String image) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.editeur = editeur;
        this.image = image;
    }
    
    public document(String nom, String type, String editeur,String image) {
        this.nom = nom;
        this.type = type;
        this.editeur = editeur;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "document{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", editeur=" + editeur + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final document other = (document) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

   
    
    
}
