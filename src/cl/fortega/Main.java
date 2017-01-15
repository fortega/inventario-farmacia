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
//        Connection c = Utils.getConnection();
//        Statement stmt = c.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM item");
//        while(rs.next()){
//            System.out.print(rs.getInt("ID"));
//            System.out.print(rs.getString("Nombre"));
//            System.out.println(rs.getShort("Nulo"));
//        }
//
//        DB db = new DB();
//        List<Item> items = db.getItemAll();
//        for(Item item : items){
//            item.setNulo((short)1);
//            db.saveItem(item);
//            System.out.println(item.getNulo());
//        }
        Utils.createTables();
        
        MainView main = new MainView();
        main.setVisible(true);

    }
    
}
