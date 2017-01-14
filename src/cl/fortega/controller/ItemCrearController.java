/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.model.DB;
import cl.fortega.model.Item;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemCrearController {
    public static void btnCrear_click(Dialog owner,ActionEvent ae, String nombre){
        //TODO: Check
        
        Item i = new Item();
        i.setNombre(nombre);
        
        DB db = new DB();
        boolean resultado = db.createItem(i);
        
        if(!resultado)
            JOptionPane.showConfirmDialog(null,
                    "Revise que nombre no este duplicado",
                    "No se pudo crear item",
                    JOptionPane.OK_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        else
            owner.setVisible(false);
    }
}
