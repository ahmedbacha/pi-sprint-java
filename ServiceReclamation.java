/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Util.DataSource;
import java.sql.Connection;
import Entite.Reclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author winxspace
 */
public class ServiceReclamation implements Iservice<Reclamation>{
Connection conn;
    public ServiceReclamation(){
        conn=DataSource.getInstance().getConn();
    }
    @Override
    public void ajouter(Reclamation t) {
        try{String query="INSERT INTO `reclamation`"
                        + "(`Cin`, `Username`,"
                        + " `Email`, `Type`, `Description`,"
                        + " `Date`) VALUES "
                        + "('"+t.getCin()+"',"
                        + "'"+t.getUsername()+"','"+t.getEmail()+"',"
                        + "'"+t.getType()+"','"+t.getDescription()+"',"
                        +"'"+t.getDate()+"')";
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } 
        catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    

    
   

   @Override
    public List<Reclamation> afficher() {
 List<Reclamation> lr=new ArrayList<>();
        try {
            String query="SELECT * FROM `reclamation`";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Reclamation r=new Reclamation();
               r.setId(rs.getInt("id"));
                r.setCin(rs.getString("Cin"));
                r.setUsername(rs.getString("Username"));
                r.setEmail(rs.getString("Email"));
                r.setType(rs.getString("Type"));
                r.setDescription(rs.getString("Description"));
                r.setDate(rs.getString("Date"));

                lr.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;    }

   @Override
    public void supprimer(int id) {
         String requete="delete from reclamation  where id= "+id;
            
        try {
             
            Statement st=conn.createStatement();
           
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public void modifier(List<Object> list, int id) {
       
        String requete="update reclamation set  Username=?,Email=?,Type=?,Description=? where id=" + id;
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
            pst.setString(1, (String) list.get(0));
            pst.setString(2, (String) list.get(1));
            pst.setString(3, (String) list.get(2));
            pst.setString(4, (String) list.get(3));
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}    
    
    


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     