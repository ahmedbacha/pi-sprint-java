/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nourfx;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.commande;
import entities.document;
import helpers.DbConnect;
import java.awt.Desktop;
import java.awt.HeadlessException;
import services.Servicecommande;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import services.Servicedocument;

/**
 *
 * @author Th3_D0cTor
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Label tornoi;

    @FXML
    private Button  match;

    @FXML
    private Label team;
    @FXML
    private VBox TContainer;
    
        @FXML
    private TextField rechzone;
        
            @FXML
    private ComboBox<String> comboBox;
            
             String query = null;
    Connection connection = DbConnect.getConnect() ;
    
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet,resultSet1 = null ;
    
    
    
    Servicecommande scmd = new Servicecommande() ;
    List<commande> cmds;
    
    Servicedocument sdoc = new Servicedocument() ;
    List<document> docs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


// Add items to the ComboBox
        comboBox.getItems().addAll("nomdocument", "type");
        
        
    }
       


    
    
    @FXML
    void Commande(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        TContainer.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(); 
        VBox aj = fxmlLoader.load(getClass().getResource("CreateCommande.fxml"));
   
           //System.out.println(post);
           CreateCommandeController ajoutcontroller = fxmlLoader.getController();
           
           TContainer.getChildren().add(aj);
        /////////////////////////////////////////////////
        
        cmds = new ArrayList<>(scmd.selectAll());
        

        
        
        
        for (commande tor:cmds){
            
            FXMLLoader fxmlLoader1 = new FXMLLoader(); 
            fxmlLoader1.setLocation(getClass().getResource("commande.fxml"));
        
            AnchorPane torno = fxmlLoader1.load();
            
            CommandeController torcontroller = fxmlLoader1.getController();
            torcontroller.setData(tor);
            TContainer.getChildren().add(torno);
            
            
        }
        
        
            

    }
    
    
    @FXML
    void Document(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        TContainer.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(); 
        VBox aj = fxmlLoader.load(getClass().getResource("CreateDocument.fxml"));
   
           //System.out.println(post);
           CreateDocumentController ajoutcontroller = fxmlLoader.getController();
           
           TContainer.getChildren().add(aj);
        /////////////////////////////////////////////////
        
        docs = new ArrayList<>(sdoc.selectAll());
        

        
        
        
        for (document doc:docs){
            
            FXMLLoader fx = new FXMLLoader();
           
           
           fx.setLocation(getClass().getResource("Document.fxml"));
           HBox pub = fx.load();
           
           //System.out.println(post);
           DocumentController matchController = fx.getController();
           matchController.setData(doc);
           TContainer.getChildren().add(pub);
            
            
        }
    
}
    
    
     @FXML
    void rech(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        TContainer.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(); 
        VBox aj = fxmlLoader.load(getClass().getResource("CreateDocument.fxml"));
   
           //System.out.println(post);
           CreateDocumentController ajoutcontroller = fxmlLoader.getController();
           
           TContainer.getChildren().add(aj);
        /////////////////////////////////////////////////
        
        docs = new ArrayList<>(sdoc.search(rechzone.getText()));
        

        
        
        
        for (document doc:docs){
            
            FXMLLoader fx = new FXMLLoader();
           
           
           fx.setLocation(getClass().getResource("Document.fxml"));
           HBox pub = fx.load();
           
           //System.out.println(post);
           DocumentController matchController = fx.getController();
           matchController.setData(doc);
           TContainer.getChildren().add(pub);
            
            
        }
    
}
    
    
     @FXML
    void trii(ActionEvent event) throws IOException, FileNotFoundException, SQLException {
        TContainer.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(); 
        VBox aj = fxmlLoader.load(getClass().getResource("CreateDocument.fxml"));
   
           //System.out.println(post);
           CreateDocumentController ajoutcontroller = fxmlLoader.getController();
           
           TContainer.getChildren().add(aj);
        /////////////////////////////////////////////////
        
        docs = new ArrayList<>(sdoc.tri(rechzone.getText()));
        

        
        
        
        for (document doc:docs){
            
            FXMLLoader fx = new FXMLLoader();
           
           
           fx.setLocation(getClass().getResource("Document.fxml"));
           HBox pub = fx.load();
           
           //System.out.println(post);
           DocumentController matchController = fx.getController();
           matchController.setData(doc);
           TContainer.getChildren().add(pub);
            
            
        }
    
}
    
    @FXML
    void cnvPDF(ActionEvent event) throws SQLException, IOException {
         try {
       com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
       PdfWriter.getInstance(doc,new FileOutputStream("D:\\Document.pdf"));  
       doc.open();
       
    doc.add(new Paragraph(" "));
       
       Paragraph p = new Paragraph("liste des Document  ");
       p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       doc.add(p);
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph(" "));

       PdfPTable tabpdf = new PdfPTable(6);
       tabpdf.setWidthPercentage(100);
       
       PdfPCell cell;
       cell = new PdfPCell(new Phrase("id"));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("nom document"));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("type"));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("editeur"));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       cell = new PdfPCell(new Phrase("image "));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       cell = new PdfPCell(new Phrase("url"));
       cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdf.addCell(cell);
       
       
       
       query = "SELECT * FROM `document`";
         preparedStatement = connection.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
      
          
      while (resultSet.next()) {
           cell = new PdfPCell(new Phrase(resultSet.getString("id")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           
           cell = new PdfPCell(new Phrase(resultSet.getString("nomdocument")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           cell = new PdfPCell(new Phrase(resultSet.getString("type")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           cell = new PdfPCell(new Phrase(resultSet.getString("editeur")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           cell = new PdfPCell(new Phrase(resultSet.getString("image")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           cell = new PdfPCell(new Phrase(resultSet.getString("url")));
           cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdf.addCell(cell);
           
       }
     
   
          doc.add(tabpdf);
          JOptionPane.showMessageDialog(null, "Votre fichier a ete exporter avec succes");
          doc.close();
          Desktop.getDesktop().open(new File("D:\\Document.pdf"));
       }
 
        catch (DocumentException | HeadlessException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
          }


} 

    }

    
    
    

