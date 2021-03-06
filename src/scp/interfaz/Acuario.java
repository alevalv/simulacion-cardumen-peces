package scp.interfaz;

import java.awt.Container;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import scp.controlador.Controlador;

public class Acuario extends JFrame {

    Container contenedor;
    Canvas Canvas;
    Rectangle r;

    public Acuario() {
        super("Cardumen de peces");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        r = getBounds();
        contenedor = getContentPane();
        Canvas = new Canvas(r.width, r.height);

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