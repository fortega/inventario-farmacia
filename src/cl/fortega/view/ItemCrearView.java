/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.ItemCrearController;
import cl.fortega.model.Caja;
import cl.fortega.model.DB;
import cl.fortega.model.Item;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemCrearView extends BaseView {
    JLabel lblNombre;
    JTextField txtNombre;
    JButton btnCrear, btnAgregar, btnQuitar;
    JTable tblCajas;
    
    public ItemCrearView(Dialog owner, Item i) {
        super(owner);
        
        setTitle("Crear Item");
        
        JPanel panelCajasMain = new JPanel(new BorderLayout());
        
        JLabel lblCajas  = new JLabel("Cajas:");
        panelCajasMain.add(lblCajas, BorderLayout.PAGE_START);
        
        tblCajas = new JTable();
        panelCajasMain.add(tblCajas, BorderLayout.CENTER);
        
        JPanel panelCajasBotones = new JPanel(new FlowLayout());
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(ae -> ItemCrearController.btnAgregar_click(this, ae));
        panelCajasBotones.add(btnAgregar);
        
        btnQuitar = new JButton("Quita");
        btnQuitar.addActionListener(ae -> ItemCrearController.btnQuitar_click(this, ae));
        panelCajasBotones.add(btnQuitar);
        
        panelCajasMain.add(panelCajasBotones, BorderLayout.PAGE_END);
        add(panelCajasMain, BorderLayout.CENTER);
        
        setCajas(i);
        
        JPanel panel = new JPanel(new FlowLayout());
        
        lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre);
        
        txtNombre = new JTextField(24);
        lblNombre.setLabelFor(txtNombre);
        panel.add(txtNombre);
        
        add(panel, BorderLayout.PAGE_START);
        
        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(ae -> ItemCrearController.btnCrear_click(this, ae, txtNombre.getText()));
        add(btnCrear, BorderLayout.PAGE_END);
    }
    
    private void setCajas(Item i){
        
        
        List<Caja> cajas = new ArrayList<>();
        if(i != null)
            for(Caja caja : i.getCajaCollection())
                cajas.add(caja);
        
        tblCajas.setModel(new TableModelCajas(cajas));
    }
    
}
