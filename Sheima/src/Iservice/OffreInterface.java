/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.util.List;

/**
 *
 * @author Sheima
 */
public interface OffreInterface<Offre> {
      public void ajouterOffre(Offre r);
    public void supprimerOffre(Offre r);
    public void modifierOffre(Offre r);
    public List<Offre> afficherOffres();
    
}
