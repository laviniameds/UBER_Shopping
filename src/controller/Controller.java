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
        
        String sql = "SELECT * from compra where login_cliente = ?";
        
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
    
    public void buscarEntregador(Entregador entregador, Compra compra){
        entregador = new Entregador();
        compra.setTempo(entregador);
    }
    
    public void CompraCheckout(Compra compra){
        compra.setComissaoEntregador();
        compra.setValorTotalCompra();  
    }
    
    public String escolherLocalCompra(Compra compra, String local){
        compra.setLocal(local);
        return compra.getLocal() + " está a " + compra.getLocalizacao().getDistancia() + " da sua localização";
    }
    
    public void remProdutoCompra(Compra compra, Integer index){
        compra.removerProduto(compra.getCesta().get(index));
    }
    
    public Produto addProdutoCompra(Compra compra, String descricao, Integer quantidade, Float preco){
        Produto p = new Produto();
        p.setNome(descricao);
        p.setQuantidade(quantidade);
        p.setPreco(preco);

        compra.adicionarProduto(p);

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
    
    public void finalizarCompra(Cliente cliente, Compra compra, Entregador entregador, Integer avaliacao){
        entregador.setAvaliacao(avaliacao+1);
        cliente.adicionarHistoricoDeCompra(compra);
    }
}
