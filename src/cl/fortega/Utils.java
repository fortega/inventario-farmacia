/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author felipe
 */
public class Utils {
    private static final String persistenceUnitName = "InventarioFarmaciaPU";
    
    public static Properties Properties = new Properties();
    public static EntityManager getEntityManager(){
        return Persistence
                .createEntityManagerFactory(persistenceUnitName).createEntityManager();
    }
}
