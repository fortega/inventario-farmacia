/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;


import cl.fortega.controller.config.Cancelar;
import cl.fortega.controller.config.OK;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 *
 * @author felipe
 */
public class ConfigFrame extends BaseForm {
    private JButton ok, cancelar;
    
    public ConfigFrame(){
        super();
        this.setTitle("Configuracion no encontrada");
        this.setSize(320, 240);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.ok = new JButton("Crear configuracion");
        this.ok.addActionListener(new OK());
        this.add(this.ok);
        
        this.cancelar = new JButton("Cancelar");
        this.cancelar.addActionListener(new Cancelar());
        this.add(cancelar);
    }
    
}
