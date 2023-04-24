/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahmed;

import entities.Utilisateur;
import services.ServiceUtilisateurIMP;
import utils.MyDB;

/**
 *
 * @author chaker
 */
public class Main {

    public static void main(String[] args) {
        //test du connection

        // MyDB conn = new MyDB();
        // test des services 
        ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();

        /* ajout d un utilisateur
                 
                
                 Utilisateur user = new Utilisateur("chaxker.ayachi@esprit.tn", "[\"ROLE_USER\"]", "chaker", "chaker", "ayachi", "photo", 10017460, "tunis ", "tunis", "ee","active",true);
                 su.ajoutUtilisateur(user);
                 
         */
 /*  //test de modification 
                 
                 Utilisateur user_modified = new Utilisateur("updated.udates@esprit.tn", "[\"ROLE_USER\"]", "updated", "updated", "updated", "update", 65656565, "updated ", "updated", "updated","desactiver",true);

                 
                 su.modifierUtilisateur(user_modified, 21);
                 
         */
        // test du suppression
        // su.supprimerUtilisateur(3);
        // test d affichage de tous les utilisateurs 
        /*
        
        su.afficherUtilisateurs().forEach(System.out::println);
         */
        
        // System.out.println(su.FindByEmail("chaker.ayachi@esprit.tn"));;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
