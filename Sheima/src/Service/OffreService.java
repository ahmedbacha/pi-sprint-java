/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Iservice.OffreInterface;
import entities.Offre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import source.DataSource;

/**
 *
 * @author Sheima
 */
public class OffreService implements OffreInterface<Offre>{

    @Override
    public void ajouterOffre(Offre r) {
        try {
            String requete= "INSERT INTO Offre (description,proprietaire)"
                    + "VALUES (?,?)";
             
          PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(requete);
           
          pst.setString(1,r.getDescription());
            pst.setString(2, r.getProprietaire());
           
            pst.executeUpdate();   
            System.out.println("Offre inseré");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerOffre(Offre r) {
        try {
            String requete = "DELETE FROM Offre where idOffre=?";
            PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(requete);
          
            pst.setInt(1, r.getIdOffre());
            pst.executeUpdate();
            System.out.println("Offre supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public void modifierOffre(Offre r) {
        try {
            
     String requete = "UPDATE Offre SET idOffre=?, description=?, proprietaire=? Where idOffre =?";
            PreparedStatement pst = DataSource.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, r.getIdOffre());
            pst.setString(2, r.getDescription());
            pst.setString(3, r.getProprietaire());
            pst.setInt(4, r.getIdOffre());
           
            
            pst.executeUpdate();
            System.out.println("Offre modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Offre> afficherOffres() {
      List<Offre> OffresList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Offre r ";
            Statement st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete); //te5ou hajet f Offre w thotohom f rs
            while(rs.next()){
                Offre r = new Offre();
                
                r.setIdOffre(rs.getInt("idOffre"));
                r.setDescription(rs.getString("description"));
                r.setProprietaire(rs.getString("proprietaire"));
                
                
                System.out.println("les Offres sont" +r.toString());
               OffresList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return OffresList;
         
         }
    }
    

