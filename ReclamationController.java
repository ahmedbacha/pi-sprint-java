/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Reclamation;
import Service.ServiceReclamation;
import Util.DataSource;
import java.awt.TextArea;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class ReclamationController implements Initializable {

     @FXML
    private TextField tfcin;
    @FXML
    private TextField tfusername ;
    @FXML
    private TextField tfemail ;
    @FXML
    private TextField tftype ;
    @FXML
    private TextField tfdescription ;
    @FXML
    private TextField tfdate ;
    @FXML
    private TableColumn<Reclamation, Integer> id;
   
    @FXML
    private TableColumn<Reclamation, String> Cin;
    @FXML
    private TableColumn<Reclamation, String> Username;
    @FXML
    private TableColumn<Reclamation, String> Email;
@FXML
    private TableColumn<Reclamation, Integer> Type;
   
    @FXML
    private TableColumn<Reclamation, String> Description;
    @FXML
    private TableColumn<Reclamation, String> Date;
    
  
    @FXML
    private TableView<Reclamation> table;
    
    
    Connection mc;
    PreparedStatement ste;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
           }    

     @FXML
    private void btnAjouter(ActionEvent event) {
        
        Reclamation r1 = new Reclamation(tfcin.getText(), tfusername.getText(),tfemail.getText(),tftype.getText(),tfdescription.getText(),tfdate.getText());
        ServiceReclamation re = new ServiceReclamation();
        re.ajouter(r1);
         refresh();
    }

@FXML
   
 public void affiche() {
    ServiceReclamation sp = new ServiceReclamation();
    List<Reclamation> reclamation = sp.afficher();
    ObservableList<Reclamation> observableEvents = FXCollections.observableArrayList(reclamation);

    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    Cin.setCellValueFactory(new PropertyValueFactory<>("Cin"));
    Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
    Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
       Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
           Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
    Date.setCellValueFactory(new PropertyValueFactory<>("Date"));


    table.setItems(observableEvents);
  
}
   
    
 @FXML
    private void btnSupprimer(ActionEvent event) {
       ServiceReclamation ls=new ServiceReclamation();
        Reclamation selected_it =  table.getSelectionModel().getSelectedItem();
        ls.supprimer(selected_it.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Suppression avec succés");
                alert.showAndWait();
      
       
    }
    @FXML
    private void btnmodifier(ActionEvent event) {
         List<Object> list = new ArrayList<>(Arrays.asList(tfusername.getText(),tfemail.getText(),tftype.getText(), tfdescription.getText()));
        ServiceReclamation ls=new ServiceReclamation();
      Reclamation selected_trajet =  table.getSelectionModel().getSelectedItem();
        ls.modifier(list,selected_trajet.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Mise à jour avec succés");
                alert.showAndWait();
        
    }
}   