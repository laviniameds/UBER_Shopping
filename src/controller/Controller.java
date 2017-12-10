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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.*;

/**
 *
 * @author lavinia
 */
public class Controller {
    
    public static TableModel listarHistoricoCompras(String login) throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        
        String sql = "SELECT valor, local, data from compra where login_cliente = ?";
        
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
    
    public static Entregador buscarEntregador() throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        Entregador entregador = null;
        
        String sql = "SELECT * FROM entregador ORDER BY RANDOM() LIMIT 1";
        
        try{
            pst = con.prepareStatement(sql);            
            result = pst.executeQuery();
            
            if(result.next()){
                entregador = new Entregador();

                entregador.setNome(result.getString("nome"));
                entregador.setAvaliacao(Float.valueOf(result.getString("avaliacao")));
                entregador.setLogin(result.getString("login"));
                entregador.setSenha(result.getString("senha"));
                entregador.setTempo_servico(Float.valueOf(result.getString("tempo_servico")));
                
                return entregador;
            }
            else
                return null;
        }
        catch(SQLException e){
            return null;            
        }
    }
    
    public static String escolherLocalCompra(Compra compra, String local){
        compra.setLocal(local);
        return compra.getLocal() + " está a " + compra.getLocalizacao().getDistancia() + " da sua localização";
    }
    
    public static Compra remProdutoCompra(Compra compra, Integer index){
        compra.removerProduto(compra.getCesta().get(index));
        return compra;
    }
    
    public static Produto addProdutoCompra(Compra compra, String descricao, Integer quantidade, Float preco){
        Produto p = new Produto();
        p.setNome(descricao);
        p.setQuantidade(quantidade);
        p.setPreco(preco);

        return p;
    }
    
    public static Cliente validarLoginCliente(String login, String senha) throws ClassNotFoundException {
        
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        Cliente cliente = null;
        
        String sql = "SELECT * from cliente where login = ? and senha = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            
            result = pst.executeQuery();
            
            if(result.next()){
                cliente = new Cliente();

                cliente.setLogin(login);
                cliente.setAvaliacao(Float.valueOf(result.getString("avaliacao")));
                cliente.setNome(result.getString("nome"));
                cliente.setSenha(senha);
                
                return cliente;
            }
            else
                return null;
        }
        catch(SQLException e){
            return null;            
        }
        
    }
    
    public static void AtualizarEntregadorBD(Entregador entregador) throws ClassNotFoundException{
        PreparedStatement pst = null;
        ResultSet result = null;
        Connection con = ConectionBD.conectBD();
        
        String sql = "UPDATE entregador SET avaliacao = ? WHERE login = ?";
        
        try{           
            pst = con.prepareStatement(sql);
            pst.setFloat(1, Float.valueOf(String.valueOf(entregador.getAvaliacao())));
            pst.setString(2, entregador.getLogin());   

            result = pst.executeQuery();                    
        }
        catch(SQLException e){
            return;            
        }        
    }
    
    public static void InserirCompraBD(Cliente cliente, Compra compra, Entregador entregador) throws ClassNotFoundException{
            
        PreparedStatement pst = null;
        Connection con = ConectionBD.conectBD();
        
        String sql = "INSERT INTO compra(login_cliente, login_entregador, valor, local, data) values (?, ?, ?, ?, ?)";
        
        try{           
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getLogin());
            pst.setString(2, entregador.getLogin());   
            pst.setFloat(3, Float.valueOf(String.valueOf(compra.getValorTotalProdutos())));   
            pst.setString(4, compra.getLocal());   
            pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));  
            
            pst.execute();      
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);         
        }        
    }
}
