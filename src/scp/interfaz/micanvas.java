/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.Timer;


/**
 *
 * @author Maria Cristina Bustos - 0843391
 * @author Alejandro Valdes Villada - 0838649
 *
 */

public class micanvas extends Canvas implements ActionListener, MouseListener{
    //creamos un vector de mibolita para todas las bolas que queramos
    private Vector<Pezh> peces= new Vector<Pezh>(5,1);
    //creacion de un bufferedimage para el parpadeo
    private BufferedImage imageBufferPeces;
    //se crea un timer que manejara todas la bolitas
    private Dimension d;
    Timer time;
    ImageIcon imagenpez;
    
    micanvas(int x, int y){
        setBackground(Color.white);
        setSize(x,y);
        time = new Timer(5, this);
        /*
        d=this.getSize();
        imagenpez=  new ImageIcon(getClass().getResource("fish.png"));
        Pezh.limx=d.width;
        Pezh.limy=d.height;
        this.addMouseListener(this);
        imagen = new BufferedImage(d.width,d.height, BufferedImage.TYPE_INT_RGB);
        bufer=imagen.getGraphics();
        for(int a=0; a<10;a++){
            peces.add(new Pezh(Pezh.gen.nextInt(d.width),Pezh.gen.nextInt(d.height)));
        }
        */
        

    }
    @Override
    public void paint(Graphics g){
        /*
        //Usando un bufferedimage evitamos el parpadeo de la pantalla
        Graphics2D g2d=(Graphics2D)bufer;
        g2d.clearRect(0, 0, d.width, d.height);
        
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, d.width, d.height);
        //se dibujan las bolitas en imagen
        for(int i=0; i<peces.size(); i++){
            //g2d.rotate(i);
            g2d.drawImage(imagenpez.getImage(), peces.elementAt(i).x(), peces.elementAt(i).y(), this);
            //g2d.rotate(-i);
            //bufer.setColor(peces.elementAt(i).Color());
            //bufer.fillOval(peces.elementAt(i).x(), peces.elementAt(i).y(), 14, 14);
            //tailx=TailX(peces.elementAt(i).getDireccion());
            //taily=TailY(peces.elementAt(i).getDireccion());
            //bufer.fillOval(peces.elementAt(i).x()+tailx, peces.elementAt(i).y()+taily, 7, 7);
           
        }
        //dibujamos la buffered image en pantalla
        */ 
        g.drawImage(imageBufferPeces, 0, 0, this);
        

    }
    
    //redefinimos el update para que envie directamente a paint sin borrar la pantalla
    @Override
    public void update(Graphics g){
        paint(g);
    }


    //nuestro actionperformed se activara con el timer y movera todas las bolas
    @Override
    public void actionPerformed(ActionEvent arg0) {
        d=this.getSize();
        Pezh.limx=d.width;
        Pezh.limy=d.height;
        this.setSize(d);
        for(int k=0; k<peces.size(); k++){
            peces.elementAt(k).mover();
            //System.out.println(bolas.elementAt(k));
        }
        repaint();
    }
    
    public void nuevoBuffer(BufferedImage imagen){
        imageBufferPeces = imagen;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        time.start();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}


}
