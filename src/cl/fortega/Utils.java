/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author felipe
 */
public class Utils {
    private static final String persistenceUnitName = "InventarioFarmaciaPU";

    public static EntityManager getEntityManager(){
        return Persistence
                .createEntityManagerFactory(persistenceUnitName).createEntityManager();
    }
    
    public static Connection getConnection() throws SQLException{
        Map<String, Object> p = getEntityManager().getProperties();
        return DriverManager.getConnection(
                (String)p.get("javax.persistence.jdbc.url"),
                (String)p.get("javax.persistence.jdbc.user"),
                (String)p.get("javax.persistence.jdbc.password"));
    }
    
    public static boolean createTables(){
            boolean r = true;
            String[] sqls = readFile("create.sql").split(";");
            try{
                Connection c = getConnection();
                Statement stmt = c.createStatement();
            
                for(String sql : sqls){
                    try{
                        stmt.execute(sql);
                    }catch(SQLException ex){
                        r = false;
                    }
                }
            }catch(SQLException ex){
                r = false;
            }
            
        
        return r;
    }
    
    public static String readFile(String filename){
        StringBuilder sb = new StringBuilder();
        try{
            FileInputStream fis = new FileInputStream(filename);
            for(int i = fis.read(); i != -1; i = fis.read())
                sb.append((char)i);
        }catch(IOException e){}
        
        return sb.toString();
    }
}
