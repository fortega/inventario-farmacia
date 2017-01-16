/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.controller;

import cl.fortega.model.Caja;
import cl.fortega.model.DB;
import cl.fortega.model.Movimiento;
import java.awt.Dialog;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class MovimientoSalidaController {
    public static boolean btnSalida_click(Dialog owner, int cajaId, long stock, String txtCantidad){
        if(!txtCantidad.matches("[0-9]{0,9}")){
            JOptionPane.showMessageDialog(owner, "No es un cantidad valida: " + txtCantidad, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        int cantidad = Integer.parseInt(txtCantidad);
        
        if(cantidad > stock){
            JOptionPane.showMessageDialog(owner, "No se puede retirar mas de " + stock, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        DB db = new DB();
        Caja c = db.getCaja(cajaId);
        Movimiento m = new Movimiento();
        m.setCaja(c);
        m.setCantidad(-1*cantidad);
        m.setHora(new Date());
        return db.createMovimiento(m);
    }
}
