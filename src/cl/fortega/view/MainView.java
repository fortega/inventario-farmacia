/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fortega.view;

import cl.fortega.controller.MainController;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author felipeortegabustamante
 */
public class MainView extends JFrame{
    JButton btnItems, btnIngreso, btnSalida, btnStock, btnMovimiento;
    public MainView(){
        super();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setItems();
    }
    
    private void setItems(){
        setSize(320, 240);
        setTitle("Inventario farmacia");
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        setLayout(new FlowLayout());
        
        btnItems = new JButton("Administrador Items");
        btnItems.addActionListener(l -> MainController.btnItems_click(this, l));
        add(btnItems);
        
        btnIngreso = new JButton("Ingreso mercaderia");
        btnIngreso.addActionListener(l -> MainController.btnIngreso_click(this, l));
        add(btnIngreso);
        
        btnSalida = new JButton("Salida mercaderia");
        btnSalida.addActionListener(l -> MainController.btnSalida_click(this, l));
        add(btnSalida);
        
        btnStock = new JButton("Ver stock actual");
        btnStock.addActionListener(l -> MainController.btnStock_click(this, l));
        add(btnStock);
        
        btnMovimiento = new JButton("Ver movimientos");
        btnMovimiento.addActionListener(l -> MainController.btnMovimiento_click(this, l));
        add(btnMovimiento);
    }
}
