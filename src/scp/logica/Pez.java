package scp.logica;

import java.util.ArrayList;
import java.util.HashMap;

public class Pez {
        private static Integer pecesTotal= null;
	private int ID; 
	private double direccion; //radianes
	private double velocidad; //unidades / unidad de tiempo
	/*
	 * Deberia tener un limite, y un minimo, los peces
	 * no se quedan quietos creo.
	 * 
	 */
	private ArrayList<Pez> vecinos;
	/*
	 * Deberia llenarse dinamicamente en cada momento de
	 * tiempo
	 * 
	 */
	
	private ArrayList<Object> depredadoresVecinos;
	/*
	 * Debería llenarse dinamicamente cada vez que se
	 * detecte un depredador cercano al pez. Se le debe
	 * dar importancia a mantener esta lista vacia!!
	 */
	
	private int posicionX; 
	private int posicionY;
	//private int posicionZ;
	/*
	 * En esto no estoy seguro, java parece que solo permite
	 * enteros, y me parece que sería mejor usar doubles para
	 * realizar una animación más clara.
	 */
	private static double anguloDeVision; //radianes
	/*
	 * Si queremos agregar comida y depredadores los peces
	 * deberían tener un rango de visión.
	 */
	private static double distanciaMaximaDeVision; //unidades
	/*
	 * que tan lejos puede ver el pez.
	 */
	
	
	/*
	 * Cada pez tratará de seguir la posición de sus vecinos
	 * a menos que encuentre comida o un depredador
	 */
	
	private static double distanciaFinal;
	/*
	 * Distancia que indica cuando un pez debe moverse si se encuentra
         * muy cerca al borde de la pantalla
	 */
        
        public static double distanciaMaximaVecinos;
        /*
         * Distancia maxima en la cual un pez puede ser vecino de otro pez
         */
	
        Pez(int posicionX, int posicionY){
            this.posicionX=posicionX;
            this.posicionY=posicionY;
            if(pecesTotal==null)
                pecesTotal=0;
            ID=pecesTotal;
            pecesTotal++;
        }
        
        public void refrescarVecinos(Cardumen cardumen){
            for(int i=0;i<cardumen.size();i++){
                Pez pez = cardumen.getPez(i);
                double distancia = cardumen.obtenerDistancia(this, pez);
                if(distancia<=Pez.distanciaMaximaVecinos){
                    vecinos.add(pez);
                }
            }
        }
        
        
	private boolean alinearDireccion(){
		//TODO
		return false;
	}
	
	/*
	 * Todos los peces buscaran comida siempre, estará limitada
	 * por el rango de visión y la distancia de visión
	 */
	private boolean buscarComida(){
		//TODO
		return false;
	}
	
	/*
	 * Los peces estarán atentos ante un depredador.
	 */
	private boolean buscarDepredadores(){
		//TODO
		return false;
	}
	
	/*
	 * Cada pez tratará de alejarse del depredador, si este se encuentra
	 * en su vecindad.
	 */
	private boolean huirDepredadores(){
		//TODO
		return false;
	}
	
	/*
	 * Si un pez detecta comida, tratará de dirigirse hacía ella
	 */
	private boolean irComida(){
		//TODO
		return false;
	}

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getID() {
        return ID;
    }
}
