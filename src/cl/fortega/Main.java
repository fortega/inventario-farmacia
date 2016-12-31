/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import java.sql.*;

/**
 *
 * @author felipeortegabustamante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection c = DriverManager.getConnection("jdbc:derby:/derby/inventario");
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) from item");
    }
    
}
