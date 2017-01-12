/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega;

import cl.fortega.view.MainView;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author felipeortegabustamante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utils.createTables();
        
        MainView main = new MainView();
        main.setVisible(true);
    }
    
}
