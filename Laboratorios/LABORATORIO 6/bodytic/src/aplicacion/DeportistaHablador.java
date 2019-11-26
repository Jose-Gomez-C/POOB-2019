package aplicacion;
import java.awt.Color;
import java.io.Serializable;

/**
 * Write a description of class DeportistaAblador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistaHablador extends Deportista implements Serializable{
    /**
     * Constructor for objects of class DeportistaAblador
     */
    int cont;
    int posy;
    public DeportistaHablador (Salon salon,String nombre,int posicionx, int posiciony){
        super( salon, nombre, posicionx, posiciony);
        posy=posiciony;
        color=Color.ORANGE;
        cont=0;
    }
    public void inicie(){
        if (cont==0){
            if (super.puedeMover('E')&&super.puedeMover('S')){
                muevase('S');
                muevase('E');
                muevaBrazo('D','S');
                muevaBrazo('D','S');
                muevaBrazo('I','S');
                muevaBrazo('I','S');
                muevaPierna('D','S');
                muevaPierna('I','S');
                muevaPierna('I','S');
                ++cont;
                palabras="Hola";
            }else{
                pare();
            }
        }else if(cont==1){
            if (super.puedeMover('E')&&super.puedeMover('N')){
                muevase('N');
                muevase('E');
                muevaBrazo('D','B');
                muevaBrazo('D','B');
                muevaBrazo('I','B');
                muevaBrazo('I','B');
                muevaPierna('D','B');
                muevaPierna('I','B');
                ++cont;
                palabras="";
            }else{
                pare();
            }
        }else{
            if (super.puedeMover('O')){
                muevase('O');
                muevaPierna('I','S');
                muevase('O');
                muevaPierna('I','S');
                cont=0;
                palabras="";
            }else{
                pare();
            }
        }
    }
    public void pare(){
        if (posy!=getPosicionY()){
            muevase('N');
            super.pare();
            palabras="Estoy muyyyyy cansado.";
            cont=0;
        }else if(super.puedeMover('E')&&super.puedeMover('S')&&super.puedeMover('E')&&super.puedeMover('N')&&super.puedeMover('O')){
            super.pare();
            palabras="No hay salon para saltar";
            cont=0;
        }else{
            super.pare();
            palabras="Estoy muyyyyy cansado.";
            cont=0;
        }
    }
    public void decida(){
        inicie();
    }
    public String getClase() {
    	return "Hablador";
    }
}
