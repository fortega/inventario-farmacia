/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.model.Movimiento;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author felipe
 */
public class TableModelMovimiento implements TableModel {
    
    List<Movimiento> data;
    SimpleDateFormat sdf;
    
    public TableModelMovimiento(List<Movimiento> data){
        this.data = data;
        sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Hora";
            case 1:
                return "Item";
            case 2:
                return "Caja";
            case 3:
                return "Cantidad";
            case 4:
                return "Total";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
            case 0:
            case 1:
                return String.class;
            case 2:
            case 3:
                return int.class;
            case 4:
                return long.class;
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return sdf.format(data.get(row).getHora());
            case 1:
                return data.get(row).getCaja().getItem().getNombre();
            case 2:
                return data.get(row).getCaja().getCantidad();
            case 3:
                return data.get(row).getCantidad();
            case 4:
                return data.get(row).getCaja().getCantidad()*data.get(row).getCantidad();
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
