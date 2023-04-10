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
public interface CandidatInterface<Candidat> {
       public void ajouterCandidat(Candidat r);
    public void supprimerCandidat(Candidat r);
    public void modifierCandidat(Candidat r);
    public List<Candidat> afficherCandidats();
    
}
