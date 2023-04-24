/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import entities.commande;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import utils.Connexion;
import javax.activation.DataSource;
/**
 *
 * @author winxspace
 */
public class Servicecommande implements IService<commande>{
    private Connection conn;
    public Servicecommande(){
        conn = Connexion.getInstance().getCnx();
    }


    @Override
     public void createOne(commande c) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO commande (nomdocument,type,editeur) VALUES (?,?,?)")) {
            st.setString(1, c.getNom());
            st.setString(2, c.getType());
            st.setString(3, c.getEditeur());
            st.executeUpdate();
            Logger.getLogger(Servicecommande.class.getName()).log(Level.INFO, "Commande ajoutée !");
        }
    }

    @Override
    public void updateOne(commande c) throws SQLException {
        PreparedStatement st = conn.prepareStatement("UPDATE `commande` SET `nomdocument` = ? , `type` = ?, `editeur` = ? WHERE `commande`.`id` = ?");
        st.setString(1, c.getNom());
        st.setString(2, c.getType());
        st.setString(3, c.getEditeur());
        st.setInt(4,c.getId());
        st.executeUpdate();
    }

    @Override
    public void deletOne(commande c) throws SQLException {
        PreparedStatement st = conn.prepareStatement("delete from commande where id =?");
        st.setInt(1,c.getId());
        st.executeUpdate();
    }

    @Override
    public List<commande> selectAll() throws SQLException {
        List<commande> lr=new ArrayList<>();
        String req = "SELECT * FROM commande";
        PreparedStatement ps = conn.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            commande c= new commande();
            c.setId(rs.getInt("id"));
            c.setNom(rs.getString("nomdocument"));            
            c.setEditeur(rs.getString("editeur"));
            c.setType(rs.getString("type"));


            lr.add(c);

        }
        return lr;    
    }

    
}