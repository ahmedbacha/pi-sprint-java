/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nourfx;

import entities.document;
import helpers.DbConnect;
import services.Servicedocument;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Th3_D0cTor
 */
public class DocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label name;

    @FXML
    private Label type;
    
    @FXML
    private Label editeur;
    
    @FXML
    private Label url;
    
     
    @FXML
    private ImageView img;
    
      @FXML
    private HBox reactcontainer;

    @FXML
    private ImageView a;

    @FXML
    private ImageView b;

    @FXML
    private ImageView c;

    @FXML
    private ImageView d;
    
    @FXML
    private Label nbr_react;
    
    
    int idSession =0 ;
     String query = null;
    Connection connection = DbConnect.getConnect() ;
    
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet,resultSet1 = null ;
    
    Servicedocument ser = new Servicedocument();

    
    
    
    
    
    
    document doc;
    Servicedocument scmd = new Servicedocument();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }


     public void setData(document doc) throws SQLException { 
        this.doc = doc;
        
        name.setText(doc.getNom());
        type.setText(doc.getType());
        editeur.setText(doc.getEditeur());
        url.setText(doc.getUrl());
        Image im;
        im = new Image(getClass().getResourceAsStream(doc.getImage()));
        img.setImage(im);
        nbr_react.setText(Integer.toString(doc.getId()));
        
        
        
     }
     
      @FXML
    void delete(ActionEvent event) throws SQLException {
        scmd.deletOne(doc);
        
        

    }

    @FXML
    void update(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                CreateDocumentController uptexpController = fxmlLoader.getController();
                uptexpController.setDatas(doc);
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ex) {
            System.out.println("Cant load Exp Upadate page");
            
        }

    }
    
    @FXML
    void react(ActionEvent event) {
        reactcontainer.setVisible(true);

    }
    
     @FXML
    public void onReactionImgPressed(MouseEvent me) throws SQLException{
        
        switch (((ImageView) me.getSource()).getId()){
            case "a":
                query = "INSERT INTO `rating`( `iduser`, `iddoc`, `rating`) VALUES ("+idSession+","+doc.getId()+",'1')";
                break;
            case "b":
                
                query = "INSERT INTO `rating`( `iduser`, `iddoc`, `rating`) VALUES ("+idSession+","+doc.getId()+",'2')";
                
                break;
            case "c":
                
                query = "INSERT INTO `rating`( `iduser`, `iddoc`, `rating`) VALUES ("+idSession+","+doc.getId()+",'3')";
                break;
                
            case "d":
                
                query = "INSERT INTO `rating`( `iduser`, `iddoc`, `rating`) VALUES ("+idSession+","+doc.getId()+",'4')";
                break;
           
        }
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        
        reactcontainer.setVisible(false);
    
    }
    
    
   
        
    
}
     
