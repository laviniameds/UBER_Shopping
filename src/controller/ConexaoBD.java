package controller;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public static Connection conecxaoBD() throws ClassNotFoundException{
    
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432", "postgres", "password");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao BD");
            return con;
            
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro);
            
            return null;
        }
    
    }
    
}
