/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nourfx;

import entities.document;
import helpers.DbConnect;
import services.Servicedocument;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author Th3_D0cTor
 */
public class CreateDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label path;
     @FXML
    private TextField type;

    @FXML
    private TextField editeur;
    
    @FXML
    private TextField url;
    
     @FXML
    private TextField nom_doc;
    
    
    @FXML
    private Button btAU;
    
     String query = null;
    Connection connection = DbConnect.getConnect() ;
    
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet,resultSet1 = null ;
    document doc;
    Servicedocument sdoc = new Servicedocument();
    
    
    
    
    
    public static boolean estUnNombre(String chaine) {
    String pattern = "^[0-9]+$";
    return chaine.matches(pattern);
}
    
    @FXML
    void ajouter(ActionEvent event) {
        String n = nom_doc.getText();
        String t = type.getText();
        String p = path.getText();
        String e = editeur.getText();
        String u = url.getText();
        
        
                
        
        
        
        if (!n.equals("")&& !t.equals("") && !p.equals("")&& !e.equals("") && !u.equals("")  ){
            try{
            if (btAU.getText().equals("Ajouter") ){
            query = "INSERT INTO document (nomdocument,type,editeur,image,url) VALUES (?,?,?,?,?)";
            }else
            {
                query = "UPDATE document set nomdocument=?,type=?,editeur=? , image=? ,url=? WHERE id="+doc.getId();
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,n);
            preparedStatement.setString(2,t);
            preparedStatement.setString(3,e);
            preparedStatement.setString(4,p);
            preparedStatement.setString(5,u);
            preparedStatement.executeUpdate();
            nom_doc.setText("");
            type.setText("");
            path.setText("");
            editeur.setText("");
            url.setText("");
            
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        }else {
            System.out.println("error de saisir");
        }

    }
    
    public String randomname ()
    {
	String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String randomString = "";
	int length = 5;

	Random rand = new Random();

	char[] text = new char[length];
	for(int i=0;i<length; i++){
		text[i] = characters.charAt(rand.nextInt(characters.length()));

	}

	for(int i=0;i<length; i++){
		randomString += text[i];
	}


	return randomString;
    }
    
    @FXML
    void imgLoad(ActionEvent event) throws IOException {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File f=fc.getSelectedFile();
        String filename = f.getAbsolutePath();
        filename.replaceAll("\\\\", "/");
        path.setText(filename);
        String newPath = "/img";
        File directory = new File(newPath);
        if(!directory.exists()){
            directory.mkdirs();
        }
        File sourceFile = null;
        File destinationFile = null;
        String extension = filename.substring(filename.lastIndexOf('.')+1);
        sourceFile = new File(filename);
        String nameimg=randomname();
        destinationFile = new File("C:/Users/noura/OneDrive/Bureau/NourFx/src"+newPath+"/"+nameimg+"."+extension);
        System.out.println(destinationFile.toPath());
        Files.copy(sourceFile.toPath(),destinationFile.toPath());
        System.out.println(sourceFile.toPath());
        System.out.println(destinationFile.toPath());
        path.setText(newPath+"/"+nameimg+"."+extension);
        

        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("hey Team C");
        // TODO
    } 
    
    void setDatas(document team){
            this.doc = team;
            nom_doc.setText(team.getNom());
            type.setText(team.getType());
            path.setText(team.getImage());
            url.setText(team.getUrl());
            btAU.setText("update");
           
    }
    
}
