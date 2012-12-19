/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scp.logica;

import java.util.ArrayList;
import java.util.HashMap;

public class Cardumen {
    private ArrayList<Pez> peces;
    /*
     * corrimiento indica el tamaño en bits que ocupa el identificador de un pez.
     * Por ejemplo, si tenemos 256 peces, se necesitan 8 bits.
     * Esta variable es usada para calcular las llaves de los peces.
     */
    private int corrimiento;
    private HashMap<Integer, Double> distanciasPeces;
    
    /*
     * Refresca los valores de distancia entre todos los peces,
     * con el fin de obtener los vecinos de cada pez
     */
    
    Cardumen(int size, int width, int height){
        corrimiento = Integer.toBinaryString(size-1).length();
        peces = new ArrayList<>(size);
        distanciasPeces = new HashMap<>();
        for(int i=0;i<size;i++){
            double x= Math.random()*width;
            double y= Math.random()*height;
            Pez pez = new Pez(x, y);
            peces.add(pez);
        }
        refrescarDistancias();
        refrescarVecinos();
    }
    
    public Pez getPez(int id){
        return peces.get(id);
    }
    
    public int size(){
        return peces.size();
    }
    /*
     * Calcula una llave (única) para un par de peces para usarla
     * en la tabla hash. Funciona de la siguiente manera:
     * Se tienen las dos ID de los peces. Estas identificaciones son
     * dos enteros que son guardados en minimo n bits (variable corrimiento). 
     * La llave generada es un entero que es la suma del id del pez 1 con un
     * corrimiento de n bits, más el entero del pez 2.
     *
     */
    private Integer obtenerLlave(Pez pez1, Pez pez2){
        Integer llave = (pez1.getID()<<corrimiento)+pez2.getID();
        return llave;
    }
    
    public void refrescarDistancias(){
        distanciasPeces.clear();
        for(int i=0;i<peces.size();i++){
            for(int j=i+1;j<peces.size();j++){
                Pez pez1= peces.get(i);
                Pez pez2= peces.get(j);
                Integer llave = obtenerLlave(pez1, pez2);
                double diferenciaX = pez1.getX() - pez2.getX();
                double diferenciaY = pez1.getY() - pez2.getY();
                Double distancia = Math.sqrt(diferenciaX*diferenciaX + diferenciaY*diferenciaY);
                distanciasPeces.put(llave, distancia);
           }
        }
    }
    
    /*
     * obtiene la distancia entre un par de peces
     */
    public double obtenerDistancia(Pez pez1, Pez pez2){
        Integer llave = obtenerLlave(pez1, pez2);
        Double salida = distanciasPeces.get(llave);
        if(salida== null){
            llave = obtenerLlave(pez2, pez1);
            salida = distanciasPeces.get(llave);
            if(salida == null){
                return -1;
            }
            else{
                return salida;
            }
        }
        else{
            return salida;
        }
    }
    
    private void refrescarVecinos(){
        for(int i=0;i<peces.size();i++){
            peces.get(i).refrescarVecinos(this);
        }
    }
}
