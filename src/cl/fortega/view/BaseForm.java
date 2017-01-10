/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author felipe
 */
public class BaseForm extends JFrame{
    public BaseForm(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
