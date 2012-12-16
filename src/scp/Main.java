
package scp;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import scp.interfaz.Estilo;
import scp.interfaz.InterfazTotal;

public class Main {

        public static void main(String a[]){
         MetalLookAndFeel.setCurrentTheme(new Estilo());
      try{
         UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      }catch (Exception ex){
         System.out.println("Falló la carga del tema");
         System.out.println(ex);
      }
      JFrame.setDefaultLookAndFeelDecorated(true);
      JDialog.setDefaultLookAndFeelDecorated(true);
      try{
         UIManager.setLookAndFeel(new MetalLookAndFeel());
      }catch ( UnsupportedLookAndFeelException e ){
         System.out.println ("Metal Look & Feel no es soportada en esta plataforma");
         System.exit(0);
      }
        InterfazTotal Inter=new InterfazTotal();
    }

}