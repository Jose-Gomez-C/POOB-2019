package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Pesas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.Serializable;
 
public class CajadeSalto implements EnSalon, Serializable {
    private int posicionx,posiciony;
    private String nombre;
    private Color color;
    private Salon salon; 
    public CajadeSalto(Salon salon,String nombre,int posicionx, int posiciony){
        this.salon=salon;
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;
        color=Color.BLACK;
        salon.adicione(this);
    } 
    public void pare(){
        color = Color.RED;
    }
    
    public void inicie(){
        color= Color.GREEN;
    }
    
    public Color getColor(){
        return color;
    }
    public int getPosicionY(){
        return posiciony;
    }
    public int getPosicionX(){
        return posicionx;
    }
    
    public String forma(){
        return EnSalon.FORMAS[2];
    }
    public String getClase() {
    	return "Cajadesalto";
    }
}

