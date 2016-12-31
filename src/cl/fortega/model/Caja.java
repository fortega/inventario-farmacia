/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felipeortegabustamante
 */
@Entity
@Table(name = "CAJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c")
    , @NamedQuery(name = "Caja.findById", query = "SELECT c FROM Caja c WHERE c.id = :id")
    , @NamedQuery(name = "Caja.findByCantidad", query = "SELECT c FROM Caja c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Caja.findByNulo", query = "SELECT c FROM Caja c WHERE c.nulo = :nulo")})
public class Caja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "NULO")
    private Short nulo;
    @JoinColumn(name = "ITEM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item item;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
    private Collection<Movimiento> movimientoCollection;

    public Caja() {
    }

    public Caja(Integer id) {
        this.id = id;
    }

    public Caja(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Short getNulo() {
        return nulo;
    }

    public void setNulo(Short nulo) {
        this.nulo = nulo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
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
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.fortega.model.Caja[ id=" + id + " ]";
    }
    
}
