/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;


import java.awt.Button;
import java.awt.Container;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JFrame;


public class InterfazTotal extends JFrame{

    Container contenedor=new Container();
    Button BPunto2;
    Label Punto2;
    Panel Puntos, GrillaTotal;


    public InterfazTotal(){
        
        Acuario Ventana2 = new Acuario();
        Ventana2.setVisible(true);
        Ventana2.setResizable(false);
        Ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


   

}

