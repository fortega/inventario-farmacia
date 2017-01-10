/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller.config;

import cl.fortega.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
public class OK implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        Utils.Properties.setProperty("jdbcURL", "jdbc:derby:db");
        Utils.Properties.st
        String sql = readFile("crear.sql");
        EntityManager em = Utils.getEntityManager();
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
        
    }
    
    private String readFile(String filename){
        StringBuilder sb = new StringBuilder();
        try{
            FileInputStream input = new FileInputStream(filename);
            
            for(int i = input.read(); i != -1; i = input.read())
                sb.append((char)i);
        }catch(IOException e){ }
        return sb.toString();
    }
    
}
