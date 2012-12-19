/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;


import java.awt.Container;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import scp.controlador.Controlador;

public class Acuario extends JFrame{
    Container contenedor;
    micanvas Canvas;
    Rectangle r;
    public Acuario(){
        super("Cardumen de peces");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        r=getBounds();
        contenedor = getContentPane();
        Canvas = new micanvas(r.width,r.height);
        
        contenedor.add(Canvas);
        Controlador controlador;
        try {
            controlador = new Controlador(100, 1000, 600, Canvas);
            controlador.empezarTimer();
        } catch (IOException ex) {
            Logger.getLogger(Acuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}