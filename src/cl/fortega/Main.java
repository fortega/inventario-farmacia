/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import cl.fortega.view.ConfigFrame;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author felipeortegabustamante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("config.xml");
            Utils.Properties.loadFromXML(fis);
        } catch (IOException ex) {
            ConfigFrame config = new ConfigFrame();
            config.setVisible(true);
        }
        
               
        
//        Query query = em.createNamedQuery("Item.findAll");
//        List<Item> list = query.getResultList();
//        for(int i = 0 ; i < list.size(); i++){
//            System.out.println(list.get(i).getNombre());
//        }
//        System.out.println(list.size());
    }
    
}
