/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


/**
 *
 * @author Maria Cristina Bustos - 0843391
 * @author Alejandro Valdes Villada - 0838649
 *
 */

public class Canvas extends JPanel{
    //creacion de un bufferedimage para el parpadeo
    private BufferedImage imageBufferPeces;
    
    Canvas(int x, int y){
        setSize(x,y);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(imageBufferPeces, 0, 0, this);
    }
    
    //redefinimos el update para que envie directamente a paint sin borrar la pantalla
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    public void nuevoBuffer(BufferedImage imagen){
        imageBufferPeces = imagen;
        repaint();
    }

}
