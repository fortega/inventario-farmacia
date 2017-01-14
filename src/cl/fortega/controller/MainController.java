/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.view.ItemsView;
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
        
    }
    
    public static void btnSalida_click(Frame owner, ActionEvent ae){
        
    }
    
    public static void btnStock_click(Frame owner, ActionEvent ae){
        
    }
    
    public static void btnMovimiento_click(Frame owner, ActionEvent ae){
        
    }
}
