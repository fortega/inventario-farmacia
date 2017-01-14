/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.view.ItemCrearView;
import java.awt.Dialog;
import java.awt.event.ActionEvent;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemsController {
    public static void btnCrear_click(Dialog owner, ActionEvent ae){
        ItemCrearView form = new ItemCrearView(owner);
        form.setVisible(true);
    }
}
