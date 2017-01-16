/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.ItemsController;
import cl.fortega.model.DB;
import cl.fortega.model.Item;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author felipeortegabustamante
 */
public class ItemsView extends BaseView {
    JButton btnCrear, btnEliminar, btnEditar;
    JTable tabla;
    JPanel panelBotones;
    public ItemsView(Frame owner) {
        super(owner);
        
        setTitle("Administrador de Items");
        setSize(500,500);
        
        panelBotones = new JPanel(new GridLayout(1, 3));
        
        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(l -> ItemsController.btnCrear_click(this, l));
        panelBotones.add(btnCrear);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(l -> ItemsController.btnEliminar_click(this, l, getSelectedItem().getId()));
        panelBotones.add(btnEliminar);
        
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(ae -> ItemsController.btnEditar_click(this, ae, getSelectedItem().getId()));
        panelBotones.add(btnEditar);
        
        add(panelBotones, BorderLayout.PAGE_END);
        
        
        tabla = new JTable();
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tabla.getSelectionModel().addListSelectionListener(lse -> cambioSeleccion(lse));
        JScrollPane scrollTabla = new JScrollPane(tabla);
        add(scrollTabla, BorderLayout.PAGE_START);
        
        setTabla();
    }
    
    public void setTabla(){
        DB db = new DB();
        
        List<Item> items = db.getItemAll();
        tabla.setModel(new TableModelItems(items));
        
        boolean hayItems = !items.isEmpty();
        
        if(hayItems)
            tabla.setRowSelectionInterval(0, 0);
        
        btnEditar.setEnabled(hayItems);
        btnEliminar.setEnabled(hayItems);
        
    }
    
    private Item getSelectedItem(){
        if(tabla.getSelectedRow() >= 0 && tabla.getRowCount() > 0){
            TableModelItems model = (TableModelItems)tabla.getModel();
            return model.get(tabla.getSelectedRow());
        }
        return null;
    }
//    
//    private void cambioSeleccion(ListSelectionEvent lse){
//        Item i = getSelectedItem();
//        btnEliminar.setEnabled(i != null);
//        btnEditar.setEnabled(i != null);
//    }
    
}
