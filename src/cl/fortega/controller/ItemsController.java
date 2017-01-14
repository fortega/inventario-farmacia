/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.model.DB;
import cl.fortega.model.Item;
import cl.fortega.view.ItemCrearView;
import cl.fortega.view.ItemsView;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemsController {
    public static void btnCrear_click(Dialog owner, ActionEvent ae){
        ItemCrearView form = new ItemCrearView(owner);
        form.setVisible(true);
    }
    
    public static void btnDesactivar_click(Dialog sender, ActionEvent ae, int id){
        DB db = new DB();
        Item i = db.getItem(id);
        
        ItemsView iv = (ItemsView)sender;
        
        int result = 
        JOptionPane.showConfirmDialog(sender, "Seguro",
                "confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            i.setNulo(i.getNulo() == (short)0 ? (short)1 : (short)0);
            db.saveItem(i);
            
            iv.setTabla();
        }
        
    }
    
}
