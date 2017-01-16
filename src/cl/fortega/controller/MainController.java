/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.view.ItemsView;
import cl.fortega.view.MovimientoIngresoView;
import cl.fortega.view.MovimientoSalidaView;
import cl.fortega.view.MovimientoView;
import cl.fortega.view.StockView;
import java.awt.Frame;
import java.awt.event.ActionEvent;

/**
 *
 * @author felipeortegabustamante
 */
public class MainController {
    public static void btnItems_click(Frame owner, ActionEvent ae){
        ItemsView iv = new ItemsView(owner);
        iv.setVisible(true);
    }
    
    public static void btnIngreso_click(Frame owner, ActionEvent ae){
        MovimientoIngresoView form = new MovimientoIngresoView(owner);
        form.setVisible(true);
    }
    
    public static void btnSalida_click(Frame owner, ActionEvent ae){
        MovimientoSalidaView form = new MovimientoSalidaView(owner);
        form.setVisible(true);
    }
    
    public static void btnStock_click(Frame owner, ActionEvent ae){
        StockView form = new StockView(owner);
        form.setVisible(true);
    }
    
    public static void btnMovimiento_click(Frame owner, ActionEvent ae){
        MovimientoView form = new MovimientoView(owner);
        form.setVisible(true);
    }
}
