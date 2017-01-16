/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felipe
 */
//itemId,itemNombre,cajaId,cajaCantidad, stock
@Entity
@Table(name = "STOCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s ORDER BY s.itemNombre, s.cajaCantidad")
    , @NamedQuery(name = "Stock.findStock", query = "SELECT s FROM Stock s WHERE s.stock > 0 ORDER BY s.itemNombre,s.cajaCantidad")})
public class Stock implements Serializable{
    @Basic(optional = false)
    @Column(name = "ITEMID")
    private int itemId;
    @Basic(optional = false)
    @Column(name = "ITEMNOMBRE")
    private String itemNombre;
    @Id
    @Basic(optional = false)
    @Column(name = "CAJAID")
    private int cajaId;
    @Basic(optional = false)
    @Column(name = "CAJACANTIDAD")
    private String cajaCantidad;
    @Basic(optional = true)
    @Column(name = "STOCK")
    private long stock;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemNombre
     */
    public String getItemNombre() {
        return itemNombre;
    }

    /**
     * @param itemNombre the itemNombre to set
     */
    public void setItemNombre(String itemNombre) {
        this.itemNombre = itemNombre;
    }

    /**
     * @return the cajaId
     */
    public int getCajaId() {
        return cajaId;
    }

    /**
     * @param cajaId the cajaId to set
     */
    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    /**
     * @return the cajaCantidad
     */
    public String getCajaCantidad() {
        return cajaCantidad;
    }

    /**
     * @param cajaCantidad the cajaCantidad to set
     */
    public void setCajaCantidad(String cajaCantidad) {
        this.cajaCantidad = cajaCantidad;
    }

    /**
     * @return the stock
     */
    public long getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(long stock) {
        this.stock = stock;
    }
}
