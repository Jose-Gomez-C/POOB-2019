package aplicacion;
import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

public interface EnSalon{
    public static String[] FORMAS = new String[]{"Persona", "Circulo", "Cuadrado"};
    
    Random r = new Random(1);
    
    int getPosicionX();
    int getPosicionY();
    Color getColor();
   
    void inicie();
    void pare();
    
    

    default String forma(){
       return FORMAS[1];
    }
    
    
    /**
     * Da un mensaje vacio
     */
    default String mensaje(){
       return "";
    }
    default String getClase() {
    	return "";
    }
    default String getNombre() {
    	return "";
    }
    /**
     * Decide aleatoriamente la acción a tomar
     */
    default void decida(){
        if (r.nextBoolean()){
            inicie();
        }else{
            pare();
        }
    }
}
