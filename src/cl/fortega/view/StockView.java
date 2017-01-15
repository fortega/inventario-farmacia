/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.StockController;
import cl.fortega.model.DB;
import cl.fortega.model.Stock;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author felipe
 */
public class StockView extends BaseView {
    JTable table;
    JButton btnDetalle;
    
    public StockView(Frame owner) {
        super(owner);
        
        setTitle("Stock items");
        
        
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane panel = new JScrollPane(table);
        add(panel, BorderLayout.CENTER);
        
        btnDetalle = new JButton("Detalle movimientos");
        btnDetalle.addActionListener(ae -> StockController.btnDetalle_click(this, ae, getSelectedItem().getId()));
        add(btnDetalle, BorderLayout.PAGE_END);
        
        setStock();
    }
    
    private void setStock(){
        DB db = new DB();
        List<Stock> stocks = db.getStockAll();
        if(stocks.size() > 0)
            table.setModel(new TableModelStock(stocks));
        else{
            JOptionPane.showMessageDialog(this, "No hay items. Favor crear primero", "Error", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
        }
    }
    
    private Stock getSelectedItem(){
        int seleccionado = table.getSelectedRow();
        if(seleccionado == -1)
            return null;
        TableModelStock tms = (TableModelStock)table.getModel();
        return tms.get(seleccionado);
    }
}
