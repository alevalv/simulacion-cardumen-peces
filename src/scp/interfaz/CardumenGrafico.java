/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import scp.logica.Cardumen;

/**
 *
 * @author alevalv
 */
public class CardumenGrafico {
    private ArrayList<BufferedImage> imagenesPeces;
    void CardumenGrafico() throws IOException {
        imagenesPeces = new ArrayList<>(360);
        imagenesPeces.add(ImageIO.read(getClass().getResource("fish.png")));
    }
    
    private void inicializarPeces(){
        for(int i=1;i<360;i++){
            AffineTransform tx = new AffineTransform();
            // last, width = height and height = width :)
            tx.translate(imagenesPeces.get(0).getHeight() / 2,imagenesPeces.get(0).getWidth() / 2);
            tx.rotate(Math.toRadians(i));
            // first - center image at the origin so rotate works OK
            tx.translate(-imagenesPeces.get(0).getWidth() / 2,-imagenesPeces.get(0).getHeight() / 2);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            // new destination image where height = width and width = height.
            BufferedImage nuevoPez =new BufferedImage(imagenesPeces.get(0).getHeight(), imagenesPeces.get(0).getWidth(), imagenesPeces.get(0).getType());
            op.filter(imagenesPeces.get(0), nuevoPez);
            imagenesPeces.add(nuevoPez);
        }
    }
    
    public Graphics pintarCardumen(Cardumen cardumen){
        return null;
    }
}
