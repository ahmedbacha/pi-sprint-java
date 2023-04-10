/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Iservice.CandidatInterface;
import entities.Candidat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import source.DataSource;

/**
 *
 * @author Sheima
 */
public class CandidatService implements CandidatInterface<Candidat>{

    @Override
    public void ajouterCandidat(Candidat r) {
     
        try {
            String requete= "INSERT INTO Candidat (idOffre,firstname,lastname,email,description)"
                    + "VALUES (?,?,?,?,?)";
             
          PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(requete);
           
          pst.setInt(1,r.getIdOffre());
            pst.setString(2, r.getFirstname());
            pst.setString(3, r.getLastname());
            pst.setString(4,r.getEmail());
             pst.setString(5,r.getDescription());
           
            pst.executeUpdate();   
            System.out.println("Candidat inserée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerCandidat(Candidat r) {
     try {
            String requete = "DELETE FROM Candidat where idCandidat=?";
            PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, r.getIdCandidat());
            pst.executeUpdate();
            System.out.println("Candidat supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
 
    
    }

    @Override
    public void modifierCandidat(Candidat r) {
        
        try {
             String requete = "UPDATE Candidat SET idCandidat=?, idOffre=?, firstname=?, lastname=?,email=? ,description=? Where idCandidat =?";
            PreparedStatement pst;
            pst = DataSource.getInstance().getCnx().prepareStatement(requete);
       
          
            pst.setInt(1, r.getIdCandidat());
             pst.setInt(2, r.getIdOffre());
            pst.setString(3, r.getFirstname());
            pst.setString(4, r.getLastname());
            pst.setString(5, r.getEmail());
             pst.setString(6, r.getDescription());
            pst.setInt(7, r.getIdCandidat()); 
          
            
            pst.executeUpdate();
            System.out.println("Candidat modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public List<Candidat> afficherCandidats() {
         List<Candidat> CandidatList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Candidat r ";
            Statement st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete); 
            while(rs.next()){
                Candidat r = new Candidat();
                r.setIdCandidat(rs.getInt("idCandidat"));
                r.setIdOffre(rs.getInt("idOffre"));
                r.setFirstname(rs.getString("firstname"));
                r.setLastname(rs.getString("lastname"));
                  r.setEmail(rs.getString("email"));
                r.setDescription(rs.getString("description"));
                 System.out.println("les Candidats sont" +r.toString());
                CandidatList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CandidatList;
         
         }
    }
    

