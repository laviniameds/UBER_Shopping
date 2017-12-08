/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author lavinia
 */
public class Controller {
    
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
    
    public static boolean validarLogin(Usuario usuario, String login, String senha) {
        if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) 
                return true;    
        return false;
    }
    
    public void finalizarCompra(Cliente cliente, Compra compra, Entregador entregador, Integer avaliacao){
        entregador.setAvaliacao(avaliacao+1);
        cliente.adicionarHistoricoDeCompra(compra);
    }
}
