/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lavinia
 */
public class ConectionBD {
    
    public static Connection conectBD() throws ClassNotFoundException{
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
            return con;     
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null; 
         }
        
    }
    
}
