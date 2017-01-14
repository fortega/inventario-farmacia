/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.model;

import cl.fortega.Utils;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author felipeortegabustamante
 */
public class DB {
    private final EntityManager em;
    
    public DB(){
        this.em = Utils.getEntityManager();
    }
    
    public boolean createItem(Item i){
        try{
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            
            return true;
        }catch(EntityExistsException e){
            em.getTransaction().rollback();
            return false;
        }
    }
 
    
    public List<Item> getItemAll(){
        Query query = em.createNamedQuery("Item.findAll");
        
        return query.getResultList();
    }
    
    public List<Item> getItemActive(){
        Query query = em.createNamedQuery("Item.findActive");
        
        return query.getResultList();
    }
    
    public List<Caja> getCajaAll(){
        Query query = em.createNamedQuery("Caja.findAll");
        
        return query.getResultList();
    }
    
    public List<Movimiento> getMovimientoAll(){
        Query query = em.createNamedQuery("Movimiento.findAll");
        
        return query.getResultList();
    }
    
    public List<Movimiento> getMovimientoActive(){
        Query query = em.createNamedQuery("Movimento.findActive");
        
        return query.getResultList();
    }
}
