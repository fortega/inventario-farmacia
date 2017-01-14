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
    JButton btnCrear, btnDesactivar, btnEditar;
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
        
        btnDesactivar = new JButton("Desactivar");
        btnDesactivar.addActionListener(l ->
                ItemsController.btnDesactivar_click(this, l, getSelectedItem().getId()));
        btnDesactivar.setEnabled(false);
        panelBotones.add(btnDesactivar);
        
        btnEditar = new JButton("Editar");
        panelBotones.add(btnEditar);
        
        add(panelBotones, BorderLayout.PAGE_END);
        
        
        tabla = new JTable();
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getSelectionModel().addListSelectionListener(lse -> cambioSeleccion(lse));
        JScrollPane scrollTabla = new JScrollPane(tabla);
        add(scrollTabla, BorderLayout.PAGE_START);
        
        setTabla();
    }
    
    public void setTabla(){
        DB db = new DB();
        TableModelItems tableModel = new TableModelItems(db.getItemAll());
        
        tabla.setModel(tableModel);
        if(tableModel.getRowCount() > 0)
            tabla.setRowSelectionInterval(0, 0);
        tabla.invalidate();
    }
    
    private Item getSelectedItem(){
        if(tabla.getSelectedRow() >= 0 && tabla.getRowCount() > 0){
            TableModelItems model = (TableModelItems)tabla.getModel();
            return model.get(tabla.getSelectedRow());
        }
        return null;
    }
    
    private void cambioSeleccion(ListSelectionEvent lse){
        Item i = getSelectedItem();
        if(i != null){
            
            if(i.getNulo() != null){
                if(i.getNulo() == 1)
                    btnDesactivar.setText("Activar");
                btnDesactivar.setText("Desactivar");
                btnDesactivar.setEnabled(true);
                btnDesactivar.invalidate();
                return;
            }
        }
        btnDesactivar.setText("-");
        btnDesactivar.setEnabled(false);
        btnDesactivar.invalidate();
    }
    
}
