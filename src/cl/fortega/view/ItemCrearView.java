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
    Item i;
    List<Integer> cajas;
    public ItemCrearView(Dialog owner) {
        this(owner, -1);
    }
    public ItemCrearView(Dialog owner, int id) {
        super(owner);
        
        cajas = new ArrayList<>();
        
        JPanel panel = new JPanel(new FlowLayout());
        
        lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre);
        
        txtNombre = new JTextField(24);
        lblNombre.setLabelFor(txtNombre);
        panel.add(txtNombre);
        
        JPanel panelCajasMain = new JPanel(new BorderLayout());
        tblCajas = new JTable();
        panelCajasMain.add(tblCajas, BorderLayout.CENTER);
        
        JLabel lblCajas  = new JLabel("Formato Cajas:");
        panelCajasMain.add(lblCajas, BorderLayout.PAGE_START);
        
        JPanel panelCajasBotones = new JPanel(new FlowLayout());
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(ae -> ItemCrearController.btnAgregar_click(this, ae, getItemId()));
        panelCajasBotones.add(btnAgregar);
        
        btnQuitar = new JButton("Quita");
        btnQuitar.addActionListener(ae -> ItemCrearController.btnQuitar_click(this, ae, getItemId(), getSelectedCajaCantidad()));
        panelCajasBotones.add(btnQuitar);
        
        panelCajasMain.add(panelCajasBotones, BorderLayout.PAGE_END);
        add(panelCajasMain, BorderLayout.CENTER);
        
        if(id == -1){
            setTitle("Crear Item");
            agregaCaja(1);
        }else{
            setTitle("Edita Item");
            
            DB db = new DB();
            i = db.getItem(id);
            txtNombre.setText(i.getNombre());
        }
        
        add(panel, BorderLayout.PAGE_START);
        
        btnCrear = new JButton(i != null ? "Editar" : "Crear");
        btnCrear.addActionListener(ae -> {
            if(ItemCrearController.btnCrear_click(this, ae, txtNombre.getText(), getItemId(), cajas))
                this.setVisible(false);
        });
        add(btnCrear, BorderLayout.PAGE_END);
        setCajas();
    }
    
    public void setCajas(){
        if(i != null){
            cajas = new ArrayList<>();
            DB db = new DB();
            for(Caja caja : db.getCajaItemId(i.getId()))
                cajas.add(caja.getCantidad());
        }
        
        tblCajas.setModel(new TableModelCajas(cajas));
        tblCajas.invalidate();
    }
    
    public void agregaCaja(int cantidad){
        cajas.add(cantidad);
        setCajas();
    }
    
    public void quitaCaja(int cantidad){
        for(int i = 0; i < cajas.size(); i++){
            if(cajas.get(i) == cantidad){
                cajas.remove(i);
            }
        }
    }
    
    private int getItemId(){
        if(i == null)
            return -1;
        return i.getId();
    }
    
    public int getSelectedCajaCantidad(){
        int rowIndex = tblCajas.getSelectedRow();
        if(rowIndex != -1)
            return cajas.get(rowIndex);
        else
            return -1;
    }
}
