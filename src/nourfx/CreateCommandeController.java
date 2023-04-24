/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nourfx;

import entities.JavaMailUtil;
import entities.commande;
import helpers.DbConnect;
import services.Servicecommande;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Th3_D0cTor
 */
public class CreateCommandeController  {

    /**
     * Initializes the controller class.
     */
    
    
     @FXML
    private TextField name;

   
     @FXML
    private TextField type;
     
     @FXML
    private TextField editeur;


    
     @FXML
    private Button btAU;
    
    String query = null;
    Connection connection = DbConnect.getConnect() ;
    
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet,resultSet1 = null ;
    
    commande cmd;
    Servicecommande scmd = new Servicecommande();
    
    void setDatas(commande cmd){
            this.cmd = cmd;
            name.setText(cmd.getNom());
            type.setText(cmd.getType());
            editeur.setText(String.valueOf(cmd.getEditeur()));
            
            btAU.setText("update");
           
    }

    @FXML
    void Ajouter(ActionEvent event) throws SQLException {
        String n = name.getText();
        String t = type.getText();
        String e = editeur.getText();
        
        
        if (!n.equals("")&& !t.equals("") && !e.equals("") ){
            try{
            if (btAU.getText().equals("Ajouter") ){
            query = "INSERT INTO commande (nomdocument,type,editeur) VALUES (?,?,?)";
             JavaMailUtil ml = new JavaMailUtil();
             ml.message("abdeljawed.nour@esprit.tn", "hello");
            }else
            {
                query = "UPDATE commande set nomdocument=?,type=? ,editeur=? WHERE id="+cmd.getId();
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,n);
            preparedStatement.setString(2,t);
            preparedStatement.setString(3,t);
        
            preparedStatement.executeUpdate();
            name.setText("");
            type.setText("");
            editeur.setText("");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        }
        
            
        }
    }
    
    

   

    
   