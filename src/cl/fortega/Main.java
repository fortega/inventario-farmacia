/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import cl.fortega.view.MainView;

/**
 *
 * @author felipeortegabustamante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Utils.createTables();
        
//        Connection c = Utils.getConnection();
//        Statement stmt = c.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from stock");
//        
//        while(rs.next()){
//            System.out.print(rs.getInt("itemId"));
//            System.out.print("\t");
//            System.out.print(rs.getString("itemNombre"));
//            System.out.print("\t");
//            System.out.print(rs.getInt("cajaId"));
//            System.out.print("\t");
//            System.out.print(rs.getInt("cajaCantidad"));
//            System.out.print("\t");
//            System.out.print(rs.getLong("stock"));
//            System.out.println();
//        }

        MainView main = new MainView();
        main.setVisible(true);

    }
    
}
