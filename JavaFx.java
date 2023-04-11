/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFx;

import Entite.Reclamation;
import Entite.Reponse;
import Service.ServiceReclamation;
import Service.ServiceReponse;
import java.util.Date;
import Util.DataSource;
import static java.util.Collections.list;

/**
 *
 * @author winxspace
 */
public class JavaFx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Reclamation r=new Reclamation("12345678", "amal", "amal@esprit.tn", "probleme", "probleme de conx","2/02/2000");
        ServiceReclamation sr=new ServiceReclamation();
        Reponse rep=new Reponse("14789652","aama","12/02/2000","bien","probleme resolu");
        ServiceReponse srep=new ServiceReponse();
        sr.ajouter(r);
        srep.ajouterR(rep);
       /* sr.modifier(r, 1);
        sr.supprimer(1);*/
       sr.afficher();
       
    }
    
}
