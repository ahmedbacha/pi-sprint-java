/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
        private final String url = "jdbc:mysql://127.0.0.1:3306/edu4u";
    private final String login = "root";
    private final String pwd = "";

    private Connection cnx;

    private static Connexion instance;
     private Connexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion !");
            System.out.println(e.getMessage());
        }
    }

    public static Connexion getInstance(){
        if (instance == null) instance = new Connexion();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
