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
import model.Compra;
import model.Entregador;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author lavinia
 */
public class ControllerEntregador {
    
        private static Cliente cliente = null;
        private static Compra compra = null;
        private static TableModel modeloTabela = null;
        
        /**
        * @return the cliente
        */
        public static Cliente getCliente() {
            return cliente;
        }

        /**
         * @return the compra
         */
        public static Compra getCompra() {
            return compra;
        }

        /**
         * @return the modeloTabela
         */
        public static TableModel getModeloTabela() {
            return modeloTabela;
        }
    
        public static TableModel listarEntregasPendentes(String login) throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        
        String sql = "SELECT valor, local, data from compra where login_entregador = ? and pendente = 'true'";
        
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
        
        public static void generateRamdomCompra(Entregador entregador) throws ClassNotFoundException{
            PreparedStatement pst = null;
            ResultSet result = null;
            Connection con = ConectionBD.conectBD();

            String sql = "SELECT * FROM compra where login_entregador = ? and pendente = 'true' ORDER BY RANDOM() LIMIT 1";

            try{
                pst = con.prepareStatement(sql); 
                pst.setString(1, entregador.getLogin());
                result = pst.executeQuery();

                if(result.next()){
                    compra = new Compra();
                    getCompra().setData(result.getDate("data"));
                    getCompra().setLocal(result.getString("local"));
                    getCompra().setValorTotalProdutos(Double.parseDouble(String.valueOf(result.getFloat("valor"))));
                    
                    setCliente(result.getString("login_cliente"));
                    listarProdutos(result.getInt("id_compra"));
                }
                else
                    return;
            }
            catch(SQLException e){
                return;            
            }   
        }
        
        public static void listarProdutos(Integer id_compra) throws ClassNotFoundException{
            PreparedStatement pst = null;
            ResultSet result = null;
            Connection con = ConectionBD.conectBD();

            String sql = "SELECT descricao, preco, quantidade FROM produto WHERE id_compra = ?";

            try{
                pst = con.prepareStatement(sql);
                pst.setInt(1, id_compra);        
                result = pst.executeQuery();

                modeloTabela = DbUtils.resultSetToTableModel(result);
            }
            catch(SQLException e){
                return;            
            }
        } 
        
        public static void setCliente(String login) throws ClassNotFoundException{
            PreparedStatement pst = null;
            ResultSet result = null;
            Connection con = ConectionBD.conectBD();

            String sql = "SELECT * FROM cliente where login = ?";

            try{
                pst = con.prepareStatement(sql); 
                pst.setString(1, login);
                result = pst.executeQuery();

                if(result.next()){
                    cliente = new Cliente();
                    getCliente().setNome(result.getString("nome"));
                    getCliente().setAvaliacao(Double.parseDouble(String.valueOf(result.getFloat("avaliacao"))));
                    getCliente().setLogin(login);                   
                }
                else
                    return;
            }
            catch(SQLException e){
                return;            
            }   
        }
                   
}
