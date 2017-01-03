/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import cl.fortega.model.Item;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felipeortegabustamante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("InventarioFarmaciaPU").createEntityManager();
//        entityManager.getTransaction().begin();
//        Item item = new Item();
//        item.setNombre("Atenolol 50mg");
//        item.setNulo((short)0);
//        entityManager.persist(item);
//        entityManager.getTransaction().commit();
        
        Query query = entityManager.createNamedQuery("Item.findAll");
        List<Item> list = query.getResultList();
        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i).getNombre());
        }
        System.out.println(list.size());
        
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        Connection c = DriverManager.getConnection("jdbc:derby:/derby/inventario");
//        Statement stmt = c.createStatement();
//        ResultSet rs = stmt.executeQuery("select count(*) from item");
    }
    
}
