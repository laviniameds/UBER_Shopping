/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lavinia
 */
@Entity
@Table(name = "historico_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoCompras.findAll", query = "SELECT h FROM HistoricoCompras h"),
    @NamedQuery(name = "HistoricoCompras.findById", query = "SELECT h FROM HistoricoCompras h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoCompras.findByDataCompra", query = "SELECT h FROM HistoricoCompras h WHERE h.dataCompra = :dataCompra"),
    @NamedQuery(name = "HistoricoCompras.findByValorCompra", query = "SELECT h FROM HistoricoCompras h WHERE h.valorCompra = :valorCompra")})
public class HistoricoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Basic(optional = false)
    @Column(name = "valor_compra")
    private float valorCompra;

    public HistoricoCompras() {
    }

    public HistoricoCompras(Integer id) {
        this.id = id;
    }

    public HistoricoCompras(Integer id, Date dataCompra, float valorCompra) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoCompras)) {
            return false;
        }
        HistoricoCompras other = (HistoricoCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.HistoricoCompras[ id=" + id + " ]";
    }
    
}
