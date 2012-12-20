/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.interfaz;

/**
 *
 * @author Cristina
 */
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;


 public class Estilo extends DefaultMetalTheme
{
    @Override
   public String getName() { return "Estilo"; }

   private final ColorUIResource primary1 = new ColorUIResource(27, 11, 172);
   private final ColorUIResource primary2 = new ColorUIResource(255, 255, 255);
   private final ColorUIResource primary3 = new ColorUIResource(37, 80, 252);

   private final ColorUIResource secondary1 = new ColorUIResource(216, 128, 225);
   private final ColorUIResource secondary2 = new ColorUIResource(216, 128, 225);
   private final ColorUIResource secondary3 = new ColorUIResource(51, 11, 45);

   private final ColorUIResource black = new ColorUIResource(255, 255, 255);
   private final ColorUIResource white = new ColorUIResource(0, 0, 0);

   
    @Override
   protected ColorUIResource getPrimary1() { return primary1; }
    @Override
   protected ColorUIResource getPrimary2() { return primary2; }
    @Override
   protected ColorUIResource getPrimary3() { return primary3; }

    @Override
   protected ColorUIResource getSecondary1() { return secondary1; }
    @Override
   protected ColorUIResource getSecondary2() { return secondary2; }
    @Override
   protected ColorUIResource getSecondary3() { return secondary3; }

    @Override
   protected ColorUIResource getBlack() { return black; }
    @Override
   protected ColorUIResource getWhite() { return white; }
}
