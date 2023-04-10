/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheima;

import Iservice.CandidatInterface;
import Iservice.OffreInterface;
import Service.CandidatService;
import Service.OffreService;
import entities.Candidat;
import entities.Offre;
import source.DataSource;

/**
 *
 * @author Sheima
 */
public class Sheima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DataSource ds = DataSource.getInstance();
        System.out.println(ds.hashCode());
        
        
        Offre o = new Offre(2,"n","vv");
        OffreInterface os = new OffreService();
        
        os.ajouterOffre(o);
      
    // os.modifierOffre(o);
    //os.supprimerOffre(o);
    //os.afficherOffres();
        
     
    
    
    
    
    
    
    
    Candidat c = new Candidat(3, 3, "tan", "kal", "hh", "ii");
        CandidatInterface cs  = new CandidatService();
        
       // cs.ajouterCandidat(c);
      // cs.supprimerCandidat(c);
    // cs.afficherCandidats();
   // cs.modifierCandidat(c);
    
    
    
    
    
    
    }
    
}
