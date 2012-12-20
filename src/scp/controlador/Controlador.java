/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import scp.interfaz.CardumenGrafico;
import scp.interfaz.Canvas;
import scp.logica.Cardumen;

/**
 *
 * @author alevalv
 */
public class Controlador implements ActionListener {
    
    private Timer time;
    private Cardumen cardumen;
    private CardumenGrafico cardumenGrafico;
    private Canvas Canvas;
    int width;
    int height;
    int i;
    
    public Controlador(int peces, int width, int height, Canvas Canvas) throws IOException {
        cardumen = new Cardumen(peces, width, height);
        cardumenGrafico = new CardumenGrafico();
        this.Canvas=Canvas;
        this.width=width;
        this.height=height;
        i=0;
        time = new Timer(100, this);
    }

    public void crearRepulsor(int x, int y){
        cardumen.setRepulsor(x, y);
    }
    
    public void crearAtractor(int x, int y){
        cardumen.setAtractor(x, y);
    }
    
    public void eliminarRepulsor(){
        cardumen.rmRepulsor();
    }
    
    public void eliminarAtractor(){
        cardumen.rmAtractor();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        cardumen.mover();
        //i= (i+1)%100;
        Canvas.nuevoBuffer(cardumenGrafico.pintarCardumen(cardumen, width, height));
        //time.stop();
    }
    
    public void empezarTimer(){
        time.start();
    }
    
}
