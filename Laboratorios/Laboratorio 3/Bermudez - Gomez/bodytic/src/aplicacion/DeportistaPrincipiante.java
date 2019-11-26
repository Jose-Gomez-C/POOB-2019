package aplicacion;
import java.awt.Color;

/**
 * Write a description of class DeportistaPrincipiante here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeportistaPrincipiante extends Deportista{

    // instance variables - replace the example below with your own
    private int cont;
    private int cansado;
    private int listo;
    /**
     * Constructor for objects of class DeportistaPrincipiante
     */
    public DeportistaPrincipiante(Salon salon,String nombre,int posicionx, int posiciony){
        super(salon, nombre, posicionx, posiciony);
        color= Color.GREEN;
        cont=0;
        cansado=0;
        listo=0;
    }
    public void inicie(){
        if(cansado>3){
            palabras="No mas estoy muy cansado";
            ++cansado;
        }else{
            ++cansado;
            palabras="";
        }
        if (cont==0){
            muevaBrazo('D','S');
            muevaBrazo('I','S');
            ++cont;
        }else if(cont==1){
            muevaBrazo('D','S');
            muevaBrazo('I','S');
            ++cont;
        }else if(cont==2){
            muevaBrazo('D','B');
            muevaBrazo('I','B');
            ++cont;
        }else{
            muevaBrazo('D','B');
            muevaBrazo('I','B');
            cont=0;
        }
    }
    public void pare(){
        super.pare();
    }
    public void decida(){
        pare();
    }
}
