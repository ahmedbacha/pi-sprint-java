/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author Amal
 */
public interface IRService <R> {
    public void ajouterR (R t) ; 
       public void modifierR(List<Object> list, int id);
       public void supprimerR(int id)  ; 
        public List<R> afficherR () ; 
    
    
}
