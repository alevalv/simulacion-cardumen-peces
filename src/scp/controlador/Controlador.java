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
import scp.logica.Cardumen;

/**
 *
 * @author alevalv
 */
public class Controlador implements ActionListener {
    
    private Timer time;
    private Cardumen cardumen;
    private CardumenGrafico cardumenGrafico;
    
    Controlador(int peces, int width, int height) throws IOException {
        cardumen = new Cardumen(peces, width, height);
        cardumenGrafico = new CardumenGrafico();
        time = new Timer(5, this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void empezarTimer(){
        time.start();
    }
    
}
