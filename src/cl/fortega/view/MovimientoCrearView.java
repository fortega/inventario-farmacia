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
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author felipe
 */
public class MovimientoCrearView extends BaseView {
    boolean ingreso;
    JComboBox cbItems, cbCajas;
    JButton btnCrear;
    JTextField txtCantidad;
    JLabel lblCantidad, lblItem, lblCaja;
    
    
    public MovimientoCrearView(Frame owner, boolean ingreso) {
        super(owner);
        
        setTitle((ingreso ? "Ingreso" : "salida") + " mercaderia");
        
        this.ingreso = ingreso;
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
        
        btnCrear = new JButton(ingreso ? "Ingreso" : "Salida");
        btnCrear.addActionListener(ae -> {
            if(MovimientoCrearController.btnCrear_click(this, ingreso,
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
        cbItems.setModel(new ComboBoxModelBase<Item>(items));
    }
    
    private void setCajas(){
        Item item = getSelectedItem();
        DB db = new DB();
        List<Caja> cajas = db.getCajaItemId(item.getId());
        cbCajas.setModel(new ComboBoxModelBase<Caja>(cajas));
    }
    
}
