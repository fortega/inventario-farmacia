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
import javax.persistence.RollbackException;

/**
 *
 * @author felipeortegabustamante
 */
public class DB {
    private final EntityManager em;
    
    public DB(){
        this.em = Utils.getEntityManager();
    }
    private void evictAll(){
        em.getEntityManagerFactory().getCache().evictAll();
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
        }finally{
            evictAll();
        }
    }
    
    public boolean saveItem(Item i){
        try{
            em.getTransaction().begin();
            em.merge(i);
            em.getTransaction().commit();
            return true;
        }catch(RollbackException e){
            return false;
        }finally{
            evictAll();
        }
    }
    
    public Item getItem(int id){
        Query query = em.createNamedQuery("Item.findById");
        query.setParameter("id", id);
        
        return (Item)query.getSingleResult();
    }
    
    public boolean deleteItem(Item i){
        try{
            em.getTransaction().begin();
            em.remove(i);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            em.getTransaction().rollback();
            return false;
        }finally{
            evictAll();
        }
    }
 
    
    public List<Item> getItemAll(){
        Query query = em.createNamedQuery("Item.findAll");
        
        return query.getResultList();
    }
    
    public boolean createCaja(Caja c){
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        }catch(EntityExistsException | RollbackException e){
            return false;
        }finally{
            evictAll();
        }
    }
    
    public boolean deleteCaja(Caja c){
        try{
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        }catch(EntityExistsException | RollbackException e){
            em.getTransaction().rollback();
            return false;
        }finally{
            evictAll();
        }
    }
    
    public Caja getCaja(int id){
        Query query = em.createNamedQuery("Caja.findById");
        query.setParameter("id", id);
        
        return (Caja)query.getSingleResult();
    }
    
    public Caja getCajaItemCantidad(int itemId, int cantidad){
        Query query = em.createNamedQuery("Caja.findByItemCantidad");
        query.setParameter("cantidad", cantidad);
        query.setParameter("item", itemId);
        
        System.out.println("ID:" + itemId + ",Cantidad: "+ cantidad);
        
        return (Caja)query.getSingleResult();
    }
    
    public List<Caja> getCajaItemId(int itemId){
        Query query = em.createNamedQuery("Caja.findByItemId");
        query.setParameter("id", itemId);
        
        return query.getResultList();
    }
    
    public List<Caja> getCajaAll(){
        Query query = em.createNamedQuery("Caja.findAll");
        
        return query.getResultList();
    }
    
    public boolean createMovimiento(Movimiento m){
        try{
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            
            return true;
        }catch(EntityExistsException | RollbackException e){
            return false;
        }finally{
            evictAll();
        }
    }
    
    public List<Movimiento> getMovimientosCaja(int cajaId){
        Query query = em.createNamedQuery("Movimiento.findByCaja");
        query.setParameter("id", cajaId);
        
        return query.getResultList();
    }
    
    public List<Movimiento> getMovimientoAll(){
        Query query = em.createNamedQuery("Movimiento.findAll");
        
        return query.getResultList();
    }
    
    
    public List<Stock> getStockAll(){
        Query query = em.createNamedQuery("Stock.findAll");
        
        return query.getResultList();
    }
    
    public List<Stock> getStockConStock(){
        Query query = em.createNamedQuery("Stock.findStock");
        
        return query.getResultList();
    }
}
