/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.model.DB;
import cl.fortega.view.MovimientoView;
import java.awt.Dialog;
import java.awt.event.ActionEvent;

/**
 *
 * @author felipe
 */
public class StockController {
    public static void btnDetalle_click(Dialog owner, ActionEvent ae, int itemId){
        DB db = new DB();
        
        MovimientoView form = new MovimientoView(owner, db.getMovimientos(itemId));
        form.setVisible(true);
    }
}
