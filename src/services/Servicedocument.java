/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import entities.document;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connexion;
import entities.commande;
import java.lang.reflect.InvocationTargetException;
/**
 *
 * @author winxspace
 */
public class Servicedocument implements IService<document>{
Connection conn;
    public Servicedocument(){
        conn=Connexion.getInstance().getCnx();
    }



    @Override
    public void createOne(document d) throws SQLException {
        // invoke method using reflection
               
        PreparedStatement st = conn.prepareStatement("INSERT INTO document (nomdocument, type, editeur, image) "
                + "VALUES (?, ?, ?, ?)");
        st.setString(1,d.getNom());
        st.setString(2,d.getEditeur());
        st.setString(3, d.getType());
        st.setString(4,d.getImage());
        st.executeUpdate();
        System.out.println("Document ajouté !");
    }

    @Override
    public void updateOne(document d) throws SQLException {
        PreparedStatement st = conn.prepareStatement("update document set nomdocument=?, type=?,"
                + " editeur=?, image=? where id =?");
        st.setString(1, d.getNom());
        st.setString(2, d.getType());
        st.setString(3, d.getEditeur());
        st.setString(4, d.getImage());
        st.setInt(5,d.getId());
        st.executeUpdate();
    }

    @Override
    public void deletOne(document d) throws SQLException {
        PreparedStatement st = conn.prepareStatement("delete from document where id =?");
        st.setInt(1,d.getId());
        st.executeUpdate();
    }

    @Override
    public List<document> selectAll() throws SQLException {
        List<document> dc=new ArrayList<>();
        String req = "SELECT * FROM document";
        PreparedStatement ps = conn.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            document d= new document();
            d.setId(rs.getInt("id"));
            d.setNom(rs.getString("nomdocument"));            
            d.setEditeur(rs.getString("editeur"));
            d.setType(rs.getString("type"));
            d.setImage(rs.getString("image"));
            d.setUrl(rs.getString("url"));
            dc.add(d);

        }
        return dc;    
    }
    

    public List<document> search(String ch) throws SQLException {
        List<document> dc=new ArrayList<>();
        String req = "SELECT * FROM document where nomdocument like '%"+ch+"%' or type like '%"+ch+"%'";
        PreparedStatement ps = conn.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            document d= new document();
            d.setId(rs.getInt("id"));
            d.setNom(rs.getString("nomdocument"));            
            d.setEditeur(rs.getString("editeur"));
            d.setType(rs.getString("type"));
            d.setImage(rs.getString("image"));
            d.setUrl(rs.getString("url"));
            dc.add(d);

        }
        return dc;    
    }

    public List<document> tri(String ch) throws SQLException {
        List<document> dc=new ArrayList<>();
        String req = "SELECT * FROM `document` ORDER BY '"+ch+"' ASC";
        PreparedStatement ps = conn.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            document d= new document();
            d.setId(rs.getInt("id"));
            d.setNom(rs.getString("nomdocument"));            
            d.setEditeur(rs.getString("editeur"));
            d.setType(rs.getString("type"));
            d.setImage(rs.getString("image"));
            d.setUrl(rs.getString("url"));
            dc.add(d);

        }
        return dc;    
    }
    
    
     public int nbreact(int id ) throws SQLException {
        List<document> dc=new ArrayList<>();
        String req = "SELECT * FROM `document` where iddoc="+id;
        PreparedStatement ps = conn.prepareStatement(req);

        ResultSet rs = ps.executeQuery();
        int  i = 0;
        while (rs.next()){
           
            i=i+1;
        }
        return i;    
    }

    
}