/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import EDU4Uentities.Matiere;
import interfaces.InterfaceService;
import DBCnx.MyConnection;
/**
 *
 * @author MIRA10
 */
public class MatiereService  implements InterfaceService<Matriere>{{

    Connection cnx;

    public MatiereService() {
        cnx = MyConnection.getInstance().getCnx();
    }
    //------------------------------------------------------------------------------
    @Override
    public void ajouter(Matiere m) {
        try {
            String sql = "insert into evenement(libelle,image) values (?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
             ste.setString(1, m.getLibelle());
            ste.setString(2, m.getImage());
            ste.executeUpdate();
            System.out.println("Matiere ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
//------------------------------------------------------------------------------
    public void modifier(String title, String img, Matiere m) {
        String sql = "update matiere set libelle=?,image=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, lib);
            ste.setString(6, img);
            ste.executeUpdate();
            System.out.println("Matiere modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//------------------------------------------------------------------------------
    @Override
    public void supprimer(Matiere m) {
        String sql = "delete from matiere where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//------------------------------------------------------------------------------
    @Override
    public List<Matiere> getAll() {
        EventCategService c = new EventCategService();
        List<Matiere> matieres = new ArrayList<>();
        try {
            String sql = "select * from matiere";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {
                //EventCateg e=c.findById(s.getInt(3));
                Event e = new Event(s.getInt("prix"), s.getString("titre"));
                events.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return events;
    }
//------------------------------------------------------------------------------
    public Event findEventById(int id) {
        EventCategService ps = new EventCategService();
        Event Event = new Event();
        try {
            String sql = "select * from Event where id_ev=" + id + "";
            Statement ste = cnx.createStatement();
            ResultSet res = ste.executeQuery(sql);
            while (res.next()) {
               
                EventCateg ev = ps.findById(res.getInt(7));
                Event = new Event(id, res.getInt(2), res.getFloat(3), res.getString("titre"), res.getString("description_ev"), res.getString("image"), res.getString("video"), res.getDate("date_debut"), res.getDate("date_fin"), ev);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Event;
    }

}


