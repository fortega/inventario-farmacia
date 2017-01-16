/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.model.Caja;
import cl.fortega.model.DB;
import cl.fortega.model.Item;
import cl.fortega.view.ItemCrearView;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemCrearController {
    public static boolean btnCrear_click(Dialog owner,ActionEvent ae, String nombre, int itemId, List<Integer> cantidades){
        nombre = nombre.trim();
        
        if(nombre.length() > 64){
            JOptionPane.showMessageDialog(owner, "El nombre no puede tener mas de 64 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        boolean resultado = false;
        
        DB db = new DB();
        Item item;
        if(itemId == -1){
            item = new Item();
            item.setNombre(nombre);
            resultado = db.createItem(item);
            if(resultado){
                for(int cantidad : cantidades){
                    Caja caja = new Caja();
                    caja.setCantidad(cantidad);
                    caja.setItem(item);

                    db.createCaja(caja);
                }
            }
        }else{
            item = db.getItem(itemId);
            item.setNombre(nombre);
            
            resultado = db.saveItem(item);
        }
        
        if(!resultado)
            JOptionPane.showConfirmDialog(null,
                    "Revise que nombre no este duplicado",
                    "No se pudo crear item",
                    JOptionPane.OK_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        return resultado;
    }
    
    public static boolean btnAgregar_click(Dialog owner, ActionEvent ae, int itemId){
        String resultado = JOptionPane.showInputDialog("Cantidad:", "1");
        if(resultado == null)
            return false;
        if(resultado.matches("^[0-9]{1,9}$")){
            int cantidad = Integer.parseInt(resultado);
            if(itemId != -1){
                DB db = new DB();
                Item item = db.getItem(itemId);
                
                Caja c = new Caja();
                c.setCantidad(cantidad);
                c.setItem(item);
                if(db.createCaja(c)){
                    ItemCrearView icv = (ItemCrearView)owner;
                    icv.agregaCaja(cantidad);
                }else{
                    JOptionPane.showConfirmDialog(owner, "No se puede crear 2 cajas con la misma cantidad", "Cantidad Invalida", itemId);
                    return false;
                }
            }else{
                ItemCrearView icv = (ItemCrearView)owner;
                icv.agregaCaja(cantidad);
            }
                
            return true;
        }
        JOptionPane.showConfirmDialog(owner,
                "No es una cantidad valida: " + resultado, "Cantidad Invalida",
                JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public static void btnQuitar_click(Dialog owner, ActionEvent ae, int itemId, int cantidad){
        int resultado = JOptionPane.showConfirmDialog(owner, "Seguro?", "Confirma eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resultado == JOptionPane.YES_OPTION){
            if(cantidad < 0)
                return;
            ItemCrearView icv = (ItemCrearView)owner;
            if(itemId != -1){
                DB db = new DB();
                Caja caja = db.getCajaItemCantidad(itemId, cantidad);
                if(!db.deleteCaja(caja)){
                    JOptionPane.showConfirmDialog(owner, 
                            "Verifique que no tenga movimientos asociados", "No se pudo crear caja",
                            JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            icv.quitaCaja(cantidad);
            icv.setCajas();
        }
    }
}
