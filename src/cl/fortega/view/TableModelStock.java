/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.model.Stock;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author felipe
 */
public class TableModelStock implements TableModel {
    
    List<Stock> stock;
    public TableModelStock(List<Stock> stock){
        this.stock = stock;
    }

    @Override
    public int getRowCount() {
        return stock.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Item";
            case 1:
                return "Caja";
            case 2:
                return "Stock";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
            case 0:
                return String.class;
            case 1:
                return int.class;
            case 2:
                return long.class;
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
    public Stock get(int n){
        return stock.get(n);
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return stock.get(row).getItemNombre();
            case 1:
                return stock.get(row).getCajaCantidad();
            case 2:
                return stock.get(row).getStock();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {}

    @Override
    public void addTableModelListener(TableModelListener tl) {}

    @Override
    public void removeTableModelListener(TableModelListener tl) {}
    
}
