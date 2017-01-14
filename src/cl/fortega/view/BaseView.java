/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author felipe
 */
public class BaseView extends JDialog{
    private final int hgap = 3, vgap = 3, width = 500, height = 400;
    public BaseView(Frame owner){
        super(owner);
        
        setDefaults();
    }
    
    public BaseView(Dialog owner){
        super(owner);
        
        setDefaults();
    }
    
    private void setDefaults(){
        setLayout(new BorderLayout(hgap, vgap));
        setSize(width, height);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
