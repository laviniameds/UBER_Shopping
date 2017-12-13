/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Entregador;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author lavinia
 */
public class ControllerEntregador {
    
        public static TableModel listarHistoricoEntregas(String login) throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        
        String sql = "SELECT valor, local, data from compra where login_entregador = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, login);        
            result = pst.executeQuery();
            
            return DbUtils.resultSetToTableModel(result);
        }
        catch(SQLException e){
            return null;            
        }
    }
        
        public static Entregador validarLoginEntregador(String login, String senha) throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        Entregador entregador = null;
        
        String sql = "SELECT * from entregador where login = ? and senha = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            
            result = pst.executeQuery();
            
            if(result.next()){
                entregador = new Entregador();

                entregador.setLogin(login);
                entregador.setContadorAvaliacao(result.getInt("contador_avaliacao"));
                entregador.setAvaliacao(Float.valueOf(result.getString("avaliacao")));
                entregador.setNome(result.getString("nome"));
                entregador.setSenha(senha);
                
                return entregador;
            }
            else
                return null;
        }
        catch(SQLException e){
            return null;            
        }
    }
        
        public static Cliente buscarClienteRandomico() throws ClassNotFoundException{
            PreparedStatement pst = null;
            ResultSet result = null;
            Connection con = ConectionBD.conectBD();
            Cliente cliente = null;

            String sql = "SELECT * FROM cliente ORDER BY RANDOM() LIMIT 1";

            try{
                pst = con.prepareStatement(sql);            
                result = pst.executeQuery();

                if(result.next()){
                    cliente = new Cliente();

                    cliente.setNome(result.getString("nome"));
                    cliente.setAvaliacao(Float.valueOf(result.getString("avaliacao")));
                    cliente.setLogin(result.getString("login"));
                    cliente.setSenha(result.getString("senha"));

                    return cliente;
                }
                else
                    return null;
            }
            catch(SQLException e){
                return null;            
            }   
        }
    
}
