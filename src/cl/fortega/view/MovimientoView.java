/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.model.DB;
import cl.fortega.model.Movimiento;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author felipe
 */
public class MovimientoView extends BaseView {
    List<Movimiento> data;
    JTable tabla;
    public MovimientoView(Frame owner) {
        super(owner);
        
        setAll();
    }
    
    public MovimientoView(Dialog owner, List<Movimiento> data){
        super(owner);
        this.data = data;
        setAll();
    }
    
    private void setAll(){
        setTitle("Movimientos");
        
        setSize(600, 400);
        
        if(data == null){
            DB db = new DB();
            data = db.getMovimientoAll();
        }
        tabla = new JTable(new TableModelMovimiento(data));
        JScrollPane pane = new JScrollPane(tabla);
        
        add(pane, BorderLayout.CENTER);
    }
    
}
