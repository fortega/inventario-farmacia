/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.ItemsController;
import cl.fortega.model.DB;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemsView extends BaseView {
    JButton btnCrear, btnDesactivar, btnEditar;
    JTable tabla;
    JPanel panelBotones;
    public ItemsView(Frame owner) {
        super(owner);
        
        setTitle("Adminitrador de Items");
        setSize(500,500);
        
        tabla = new JTable();
        JScrollPane scrollTabla = new JScrollPane(tabla);
        add(scrollTabla, BorderLayout.PAGE_START);
        
        setTabla();
        
        panelBotones = new JPanel(new GridLayout(1, 3));
        
        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(l -> ItemsController.btnCrear_click(this, l));
        panelBotones.add(btnCrear);
        
        btnDesactivar = new JButton("Desactivar");
        panelBotones.add(btnDesactivar);
        
        btnEditar = new JButton("Editar");
        panelBotones.add(btnEditar);
        
        add(panelBotones, BorderLayout.PAGE_END);
        
        
    }
    
    private void setTabla(){
        DB db = new DB();
        TableModelItems tableModel = new TableModelItems(db.getItemAll());
        tabla.setModel(tableModel);
        tabla.invalidate();
    }
    
    
    
}
