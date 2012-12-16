/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Vector;
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
    private BufferedImage imagen;
    //un bufer para graficos
    private Graphics bufer;
    //un boleano que nos indicara si ya se empezo el evento
    private boolean empezar=false;
    //se crea un timer que manejara todas la bolitas
    private Dimension d;
    Timer time;
    micanvas(int x, int y){
        setBackground(Color.white);
        setSize(x,y);
        time = new Timer(5, this);
        d=this.getSize();
        Pezh.limx=d.width;
        Pezh.limy=d.height;
        this.addMouseListener(this);
        imagen = new BufferedImage(d.width,d.height, BufferedImage.TYPE_INT_RGB);
        bufer=imagen.getGraphics();
        for(int a=0; a<1;a++){
            peces.add(new Pezh(Pezh.gen.nextInt(d.width),Pezh.gen.nextInt(d.height)));
        }
        

    }
    @Override
    public void paint(Graphics g){
        int tailx=0, taily=0;
        //Usando un bufferedimage evitamos el parpadeo de la pantalla
        bufer.clearRect(0, 0, d.width, d.height);
        bufer.setColor(Color.black);
        bufer.fillRect(0, 0, d.width, d.height);
        //se dibujan las bolitas en imagen
        for(int i=0; i<peces.size(); i++){
            bufer.setColor(peces.elementAt(i).Color());
            bufer.fillOval(peces.elementAt(i).x(), peces.elementAt(i).y(), 14, 14);
            tailx=TailX(peces.elementAt(i).getDireccion());
            taily=TailY(peces.elementAt(i).getDireccion());
            bufer.fillOval(peces.elementAt(i).x()+tailx, peces.elementAt(i).y()+taily, 7, 7);
        }
        //dibujamos la buffered image en pantalla
        g.drawImage(imagen, 0, 0, this);
        

    }
    
    int TailX(int direccion){
        if(direccion==2 || direccion==3) return 10;
        else return -7;
    }
     int TailY(int direccion){
        if(direccion==1 || direccion==2) return 10;
        else return -7;
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

    private int random(int num){
        return (int) (Math.random()*num)+1;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(empezar==false){
            time.start();
            empezar=true;
        }
        else if(empezar==true)
            peces.add(new Pezh(e.getX(),e.getY()));
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
