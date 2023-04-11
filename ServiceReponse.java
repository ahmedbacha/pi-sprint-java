/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Reclamation;
import Entite.Reponse;
import Util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author winxspace
 */
public class ServiceReponse implements IRService<Reponse>{
Connection conn;
    public ServiceReponse(){
        conn=DataSource.getInstance().getConn();
    }
    @Override
    public void ajouterR(Reponse t) {
        try{String query="INSERT INTO `reponse`"
                         + "(`Cin`, `Username`,"
                        + " `Date_R`, `Satisfaction`,"
                        + " `Contenue`) VALUES "
                        + "('"+t.getCin()+"',"
                        + "'"+t.getUsername()+"','"+t.getDate_R()+"',"
                        + "'"+t.getSatisfaction()+"','"+t.getContenue()+"')";
            Statement st=conn.createStatement();
            st.executeUpdate(query);
        } 
        catch (SQLException ex) {
            Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    
    

    @Override
    public List<Reponse> afficherR() {
     List<Reponse> lre=new ArrayList<>();
        try {
            String query="SELECT * FROM `reponse`";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Reponse re=new Reponse();
                 re.setId(rs.getInt("id"));
                re.setCin(rs.getString("Cin"));
                re.setUsername(rs.getString("Username"));
                re.setDate_R(rs.getString("Date_R"));
                re.setSatisfaction(rs.getString("Satisfaction"));
                re.setContenue(rs.getString("Contenue"));
                lre.add(re);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lre; 
    
}
    @Override
    public void supprimerR(int id) {
         String requete="delete from reponse  where id= "+id;
            
        try {
             
            Statement st=conn.createStatement();
           
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void modifierR(List<Object> list, int id) {
       
        String requete="update reponse set  Username=?,Satisfaction=?,Contenue=?where id=" + id;
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
            pst.setString(1, (String) list.get(0));
            pst.setString(2, (String) list.get(1));
            pst.setString(3, (String) list.get(2));
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
