/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.ItemCrearController;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemCrearView extends BaseView {
    JLabel lblNombre;
    JTextField txtNombre;
    JButton btnCrear;
    
    public ItemCrearView(Dialog owner) {
        super(owner);
        
        setTitle("Crear Item");
        
        JPanel panel = new JPanel(new FlowLayout());
        
        lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre);
        
        txtNombre = new JTextField(24);
        lblNombre.setLabelFor(txtNombre);
        panel.add(txtNombre);
        
        add(panel, BorderLayout.PAGE_START);
        
        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(l -> ItemCrearController.btnCrear_click(this, l, txtNombre.getText()));
        add(btnCrear, BorderLayout.PAGE_END);
    }
    
}
