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
public class MovimientoCrearController {
    public static boolean btnCrear_click(Dialog owner, int cajaId, String txtCantidad){
        if(txtCantidad.matches("^[0-9]{1,9}$")){
            int cantidad = Integer.parseInt(txtCantidad);
            
            DB db = new DB();
            Caja caja = db.getCaja(cajaId);
            Movimiento movimiento = new Movimiento();
            movimiento.setCaja(caja);
            movimiento.setCantidad(cantidad);
            movimiento.setHora(new Date());
            
            db.createMovimiento(movimiento);
            
            return true;
        }
        JOptionPane.showMessageDialog(owner, "Nombre una cantidad valida: " + txtCantidad, "Error",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
