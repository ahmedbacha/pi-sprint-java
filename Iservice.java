/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Reclamation;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author winxspace
 */
public interface Iservice<T> {
    public void ajouter (T t) ; 
       public void modifier(List<Object> list, int id);
       public void supprimer(int id)  ; 
        public List<T> afficher () ; 
}
