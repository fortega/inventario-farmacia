/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.MovimientoSalidaController;
import cl.fortega.model.DB;
import cl.fortega.model.Stock;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author felipe
 */
public class MovimientoSalidaView extends BaseView {
    JTable tabla;
    JLabel lblCantidad;
    JTextField txtCantidad;
    JButton btnSalida;
    
    public MovimientoSalidaView(Frame owner) {
        super(owner);
        
        setTitle("Salida mercaderia");
        
        tabla = new JTable();
        JScrollPane pane = new JScrollPane(tabla);
        add(pane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel(new FlowLayout());
        lblCantidad = new JLabel("Cantidad:");
        panel.add(lblCantidad);
        txtCantidad = new JTextField(8);
        lblCantidad.setLabelFor(txtCantidad);
        panel.add(txtCantidad);
        btnSalida = new JButton("Sacar");
        btnSalida.addActionListener(ae -> {
            boolean r = MovimientoSalidaController.btnSalida_click(this,
                getSelectedItem().getCajaId(), getSelectedItem().getStock(),
                txtCantidad.getText());
            if(r)
                setVisible(false);
        });
        panel.add(btnSalida);
        
        add(panel, BorderLayout.PAGE_END);
        
        setTabla();
    }
    
    private Stock getSelectedItem(){
        int row = tabla.getSelectedRow();
        if(row == -1)
            return null;
        
        TableModelStock tms = (TableModelStock)tabla.getModel();
        return tms.get(row);
    }
    
    private void setTabla(){
        DB db = new DB();
        
        List<Stock> stock = db.getStockConStock();
        if(stock.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay items con stock. Favor crear primero", "Sin stock", JOptionPane.ERROR_MESSAGE);
            btnSalida.setEnabled(false);
            return;
        }
        
        tabla.setModel(new TableModelStock(stock));
    }
    
}
