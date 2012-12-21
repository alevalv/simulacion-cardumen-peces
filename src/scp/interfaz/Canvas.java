package scp.interfaz;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import scp.controlador.Controlador;

public class Canvas extends JPanel implements MouseListener {
    //creacion de un bufferedimage para el parpadeo

    private BufferedImage imageBufferPeces;
    private Controlador miControlador;

    Canvas(int x, int y) {
        setSize(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(imageBufferPeces, 0, 0, this);
    }

    //redefinimos el update para que envie directamente a paint sin borrar la pantalla
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void nuevoBuffer(BufferedImage imagen) {
        imageBufferPeces = imagen;
        repaint();
    }

    public void setControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {
            miControlador.crearAtractor(me.getX(), me.getY());
        } else if (SwingUtilities.isRightMouseButton(me)) {
            miControlador.crearRepulsor(me.getX(), me.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {
            miControlador.eliminarAtractor();
        } else if (SwingUtilities.isRightMouseButton(me)) {
            miControlador.eliminarRepulsor();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
