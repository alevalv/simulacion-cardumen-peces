package scp.interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import scp.logica.Cardumen;
import scp.logica.Pez;

public class CardumenGrafico {

    private ArrayList<BufferedImage> imagenesPeces;

    public CardumenGrafico() throws IOException {
        imagenesPeces = new ArrayList<>(360);
        imagenesPeces.add(ImageIO.read(getClass().getResource("/resources/boid.png")));
        inicializarPeces();
    }

    private void inicializarPeces() {
        for (int i = 1; i < 360; i++) {
            AffineTransform tx = new AffineTransform();
            tx.translate(imagenesPeces.get(0).getHeight() / 2, imagenesPeces.get(0).getWidth() / 2);
            tx.rotate(Math.toRadians(i));
            tx.translate(-imagenesPeces.get(0).getWidth() / 2, -imagenesPeces.get(0).getHeight() / 2);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage nuevoPez = new BufferedImage(imagenesPeces.get(0).getHeight(), imagenesPeces.get(0).getWidth(), imagenesPeces.get(0).getType());
            op.filter(imagenesPeces.get(0), nuevoPez);
            imagenesPeces.add(nuevoPez);
        }
    }

    public BufferedImage pintarCardumen(Cardumen cardumen, int width, int height) {
        BufferedImage salida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = salida.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, width, height);
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, width, height);
        for (int i = 0; i < cardumen.size(); i++) {
            Pez pez = cardumen.getPez(i);
            if (pez.getX() - 5 < Pez.minX || pez.getY() - 5 < Pez.minY
                    || pez.getX() + 5 >= Pez.maxX || pez.getY() + 5 > Pez.maxY) {
                continue;
            } else {
                int direccion = (int) Math.toDegrees(pez.getDireccion());
                //if(direccion==360){
                //  direccion=0;
                //}
                BufferedImage imagenPez = imagenesPeces.get(direccion);
                g2d.drawImage(imagenPez, null, (int) Math.rint(pez.getX() + 5), (int) Math.rint(pez.getY() + 5));
            }
        }
        return salida;
    }
}
