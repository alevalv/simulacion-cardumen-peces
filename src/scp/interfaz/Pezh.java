/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Maria Cristina Bustos - 0843391
 * @author Alejandro Valdes Villada - 0838649
 *
 */


public class Pezh {
    private int x, y, direccion;
    public static int limx, limy;
    private static int pecesito=0;
    private int num;
    private Color color;
    public static Random gen= new Random();

    Pezh(int x, int y){
        this.x=x;
        this.y=y;
        direccion = (int)(Math.random()*5)+1;
        num=pecesito+1;
        pecesito++;
        color=ColorAleatorio();
    }
    public void mover(){
        if((direccion<1)||(direccion>4))
                direccion=1;
        if(direccion==1){
            x++;
            y--;
            if(x==limx-12){
                direccion=2;
            }
            if(y==0){
                direccion=4;
            }



        }
        if(direccion==2){
            x--;
            y--;
            if(x==0){
                direccion=1;
            }
            if(y==0){
                direccion=3;
            }
        }
        if(direccion==3){
            x--;
            y++;
            if(x==0){
                direccion=4;
            }
            if(y==limy-12){
                direccion=2;
            }
        }
        if(direccion==4){
            x++;
            y++;
            if(x==limx-12){
                direccion=3;
            }
            if(y==limy-12){
                direccion=1;
            }
        }
        if(x<0){
        if(direccion==2){
            direccion=1;
            x=1;
        }
        if(direccion==3){
            direccion=4;
            x=1;
        }
        }
        if(x>limx){
        if(direccion==1){
            direccion=2;
            x=limx-1;
        }
        if(direccion==4){
            direccion=3;
            x=limx-1;
        }
        }
        if(y<0){
            if(direccion==1){
                direccion=4;
                y=1;
            }
            if(direccion==2){
                direccion=3;
                y=1;
            }
        }
        if(y>limy){
            if(direccion==4){
                direccion=1;
                y=limy-1;
            }
            if(direccion==3){
                direccion=2;
                y=limy-1;
            }
        }
        
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    
    public int getDireccion(){
        return direccion;
    }
    public Color Color(){
        return color;
    }
    @Override
    public String toString(){
        return "Pez N°" + num + " x: " + x + " y: " + y;
    }

    private Color ColorAleatorio(){
        return new Color(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256));
    }

}

