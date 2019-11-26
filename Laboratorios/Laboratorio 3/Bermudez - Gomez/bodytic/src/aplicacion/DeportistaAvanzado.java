package aplicacion;

import java.awt.Color;
/**
 * Write a description of class DeportistaAvanzado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistaAvanzado extends Deportista{
    /**
     * Constructor for objects of class DeportistaAvanzado
     */
    int parar=0;
    int puedenparar =5;
    public DeportistaAvanzado(Salon salon,String nombre,int posicionx, int posiciony){
        super(salon,nombre,posicionx,posiciony);
        color=Color.ORANGE;
    }
    public void inicie(){
        super.inicie();
        Paso=40;
    }
    public void pare(){
        if(puedenparar!=0){
            if(parar==1){
                super.pare();
                parar=0;
                --puedenparar;
            }else{
                ++parar;
            }
         }else{
             inicie();
         }
    }
    public void decida(){
        inicie();
    }
    
}
