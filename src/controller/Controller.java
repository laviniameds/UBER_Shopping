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
    public void finalizarCompra(Cliente cliente, Compra compra, Entregador entregador, Integer avaliacao){
        entregador.setAvaliacao(avaliacao+1);
        cliente.adicionarHistoricoDeCompra(compra);
    }
}
