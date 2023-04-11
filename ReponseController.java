/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Reclamation;
import Entite.Reponse;
import Service.ServiceReclamation;
import Service.ServiceReponse;
import java.awt.TextArea;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Amal
 */
public class ReponseController implements Initializable {

     @FXML
    private TextField tfrcin;
    @FXML
    private TextField tfrusername ;
    @FXML
    private TextField tfrdate_r ;
    @FXML
    private TextField tfrsatisfaction ;
    @FXML
    private TextField tfrcontenue ;
    
    @FXML
    private TableColumn<Reclamation, Integer> id;
   
    @FXML
    private TableColumn<Reclamation, String> Cin;
    @FXML
    private TableColumn<Reclamation, String> Username;
    @FXML
    private TableColumn<Reclamation, String> Date_R;
@FXML
    private TableColumn<Reclamation, String> Satisfaction;
   
    @FXML
    private TableColumn<Reclamation, String> Contenue;
 @FXML
    private TableView<Reponse> tableR;
    @FXML
   private Button btnAjouterR;
    
   
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficheR();
           }    

     @FXML
    private void btnAjouterR(ActionEvent event) {
        Reponse r1 = new Reponse(tfrcin.getText(), tfrusername.getText(),tfrdate_r.getText(),tfrsatisfaction.getText(),tfrcontenue.getText());
        ServiceReponse re = new ServiceReponse();
        re.ajouterR(r1);
         
    }

@FXML
   
 public void afficheR() {
    ServiceReponse sp = new ServiceReponse();
    List<Reponse> reponse = sp.afficherR();
    ObservableList<Reponse> observableEvents = FXCollections.observableArrayList(reponse);

    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    Cin.setCellValueFactory(new PropertyValueFactory<>("Cin"));
    Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
    Date_R.setCellValueFactory(new PropertyValueFactory<>("Date_R"));
       Satisfaction.setCellValueFactory(new PropertyValueFactory<>("Satisfaction"));
           Contenue.setCellValueFactory(new PropertyValueFactory<>("Contenue"));
   


    tableR.setItems(observableEvents);
  
}
   @FXML
    private void btnSupprimerR(ActionEvent event) {
       ServiceReponse ls=new ServiceReponse();
        Reponse selected_it =  tableR.getSelectionModel().getSelectedItem();
        ls.supprimerR(selected_it.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Suppression avec succés");
                alert.showAndWait();
      
       
    }
     @FXML
    private void btnmodifierR(ActionEvent event) {
         List<Object> list = new ArrayList<>(Arrays.asList(tfrusername.getText(),tfrsatisfaction.getText(),tfrcontenue.getText()));
        ServiceReponse ls=new ServiceReponse();
      Reponse selected_trajet =  tableR.getSelectionModel().getSelectedItem();
        ls.modifierR(list,selected_trajet.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Mise à jour avec succés");
                alert.showAndWait();
        
    }
    
}
