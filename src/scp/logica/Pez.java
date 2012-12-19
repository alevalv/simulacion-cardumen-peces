package scp.logica;

import java.util.ArrayList;

public class Pez {
        private static Integer pecesTotal= null;
	private int ID; 
	private Vector posicion; // posicion en x y y
	private Vector velocidad; //unidades / unidad de tiempo
        private static final double velocidadMaxima=10;
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
	
	/*
	 * En esto no estoy seguro, java parece que solo permite
	 * enteros, y me parece que sería mejor usar doubles para
	 * realizar una animación más clara.
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
	 * Distancia que indica cuando un pez debe moverse5 si se encuentra
         * muy cerca al borde de la pantalla
	 */
        
        public static double distanciaMaximaVecinos;
        /*
         * Distancia maxima en la cual un pez puede ser vecino de otro pez
         */
        
	
        Pez(double x, double y){
            posicion = new Vector(x, y);
            velocidad = new Vector(10, 0);  //randomizar
            if(pecesTotal==null){
                pecesTotal=0;
            }
            ID=pecesTotal;
            pecesTotal++;
        }
        
        public void refrescarVecinos(Cardumen cardumen){
            for(int i=0;i<cardumen.size();i++){
                Pez pez = cardumen.getPez(i);
                double distancia = cardumen.obtenerDistancia(this, pez);
                if(distancia<=Pez.distanciaMaximaVecinos && distancia!=-1){
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

    public double getX() {
        return posicion.getX();
    }

    public double getY() {
        return posicion.getY();
    }

    public double getDireccion(){
        return velocidad.direccion();
    }
    
    public int getID() {
        return ID;
    }
    
    
    //REGLAS DE MOVIMIENTO
    
    private void limitarVelocidad(){
        if(velocidad.magnitud() > velocidadMaxima){
            velocidad = Vector.mult(Vector.div(velocidad, velocidad.magnitud()), velocidadMaxima);
        }
    }
    
    private Vector centroDeMasa(){
        double x=0;
        double y=0;
        for(int i=0;i<vecinos.size();i++){
            x+=vecinos.get(i).getX();
            y+=vecinos.get(i).getY();
        }
        x/=vecinos.size();
        y/=vecinos.size();
        return new Vector(x, y);
    }
    
    
    /*
     * los peces tratarán de acercarse lo mayor posible al centro de masa de sus vecinos.
     */
    private Vector regla1(){
        Vector centroDeMasa = centroDeMasa();
        centroDeMasa = Vector.div(centroDeMasa, vecinos.size());
        return Vector.div(Vector.sub(centroDeMasa, posicion), 100);
    }
}
