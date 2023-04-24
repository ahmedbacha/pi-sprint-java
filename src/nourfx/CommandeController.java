/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nourfx;

import entities.commande;
import services.Servicecommande;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Th3_D0cTor
 */
public class CommandeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label nomdomaine;

    @FXML
    private Label type;
    
    @FXML
    private Label editeur;
    
    
    
    
    
    
    commande cmd;
    Servicecommande scmd = new Servicecommande();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


     public void setData(commande cmd) { 
        this.cmd = cmd;
        
        nomdomaine.setText(cmd.getNom());
        type.setText(cmd.getType());
        editeur.setText(cmd.getEditeur());
     }
     
      @FXML
    void delete(ActionEvent event) throws SQLException {
        scmd.deletOne(cmd);
        
        

    }

    @FXML
    void update(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateCommande.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                CreateCommandeController uptexpController = fxmlLoader.getController();
                uptexpController.setDatas(cmd);
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ex) {
            System.out.println("Cant load Exp Upadate page");
            
        }

    }
        
    
}
     
