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
        form.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
        form.setVisible(true);
        updateTabla(owner);
    }
    
    private static void updateTabla(Dialog owner){
        ItemsView iv = (ItemsView)owner;
        iv.setTabla();
    }
    
    public static void btnEliminar_click(Dialog owner, ActionEvent ae, int id){
        DB db = new DB();
        Item i = db.getItem(id);
        
        int result = 
        JOptionPane.showConfirmDialog(owner, "Seguro desea borrar \"" + i.getNombre() + "\"?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            boolean resultado = db.deleteItem(i);
            
            if(!resultado){
                JOptionPane.showMessageDialog(owner,
                        "Confirme que no tenga movimientos asociados", "No se pudo eliminar Item", JOptionPane.ERROR_MESSAGE);
            }
            updateTabla(owner);   
        }
    }
    
    public static void btnEditar_click(Dialog owner, ActionEvent ae, int id){
        ItemCrearView form = new ItemCrearView(owner, id);
        form.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
        form.setVisible(true);
        updateTabla(owner);
    }
    
}
