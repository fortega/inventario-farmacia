/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.MovimientoCrearController;
import cl.fortega.model.Caja;
import cl.fortega.model.DB;
import cl.fortega.model.Item;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author felipe
 */
public class MovimientoIngresoView extends BaseView {
    JComboBox cbItems, cbCajas;
    JButton btnCrear;
    JTextField txtCantidad;
    JLabel lblCantidad, lblItem, lblCaja;
    
    
    public MovimientoIngresoView(Frame owner) {
        super(owner);
        
        setTitle("Ingreso mercaderia");
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JPanel panel;
        
        panel = new JPanel(new FlowLayout());
        lblItem = new JLabel("Item:");
        panel.add(lblItem);
        cbItems = new JComboBox();
        cbItems.addActionListener(ae -> setCajas());
        lblItem.setLabelFor(cbItems);
        panel.add(cbItems);
        add(panel);
        
        panel = new JPanel(new FlowLayout());
        lblCaja = new JLabel("Caja:");
        panel.add(lblCaja);
        cbCajas = new JComboBox();
        lblCaja.setLabelFor(cbCajas);
        panel.add(cbCajas);
        add(panel);
        
        panel = new JPanel(new FlowLayout());
        lblCantidad = new JLabel("Cantidad:");
        panel.add(lblCantidad);
        txtCantidad = new JTextField(8);
        lblCantidad.setLabelFor(txtCantidad);
        panel.add(txtCantidad);
        add(panel);
        
        btnCrear = new JButton("Ingreso");
        btnCrear.addActionListener(ae -> {
            if(MovimientoCrearController.btnCrear_click(this,
                    getSelectedCaja().getId() , txtCantidad.getText()))
                setVisible(false);
        });
        add(btnCrear);
        
        setItems();
        setCajas();
    }
    
    private Item getSelectedItem(){
        return (Item)cbItems.getModel().getSelectedItem();
    }
    
    private Caja getSelectedCaja(){
        return (Caja)cbCajas.getModel().getSelectedItem();
    }
    
    private void setItems(){
        DB db = new DB();
        List<Item> items = db.getItemAll();
        if(items.isEmpty()){
            JOptionPane.showMessageDialog(this, "Con hay items creados. Favor crear primero", "No items", JOptionPane.ERROR_MESSAGE);
            btnCrear.setEnabled(false);
            return;
        }
        cbItems.setModel(new ComboBoxModelBase<Item>(items));
    }
    
    private void setCajas(){
        Item item = getSelectedItem();
        if(item != null){
            DB db = new DB();
            List<Caja> cajas = db.getCajaItemId(item.getId());
            cbCajas.setModel(new ComboBoxModelBase<Caja>(cajas));
        }
    }
    
}
