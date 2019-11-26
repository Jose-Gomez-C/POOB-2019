package aplicacion;
import java.util.*;


/**
 * @author ECI 2014
 * Salon de la aplicación egiptologos
 */
/**
 * @author ECI
 *
 */
public class Salon{
    public static final int MAXIMO = 500;
    private static Salon salon = null;
    
    public static Salon demeSalon() {
        if (salon==null){
            salon=new Salon();
        }
        return salon;
    }
    
    public static void nuevoSalon() {
        salon=new Salon();
    }   
    
    public static void cambieSalon(Salon d) {
        salon=d;
    }       


    private ArrayList<EnSalon> elementos;
    
    private Salon() {
        elementos= new ArrayList<EnSalon>();
    }
    
    
    
    public EnSalon deme(int n){
        EnSalon h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    
    public void adicione(EnSalon e){
        elementos.add(e);
    }
    
    public int numeroEnSalon(){
        return elementos.size();
    }
    

    public void entrada(){
        Deportista edward = new Deportista(salon,"edward",250,0);
        Deportista bella = new Deportista(salon,"bella",200,0);
        DeportistaAvanzado neo = new DeportistaAvanzado(salon,"neo",250,300);
        DeportistaAvanzado trinity = new DeportistaAvanzado(salon,"trinity",200,300);
        DeportistaHablador han = new DeportistaHablador(salon,"han",350,300);
        DeportistaHablador leila = new DeportistaHablador(salon,"leila",400,300);
        Bola noroeste = new Bola(salon,"noroeste",530,480);
        Bola sureste = new Bola(salon,"sureste",0,0);
        DeportistaPrincipiante jose= new DeportistaPrincipiante(salon,"jose",300,150);
        DeportistaPrincipiante niko= new DeportistaPrincipiante(salon,"niko",400,150);
        CajadeSalto caja1 = new CajadeSalto(salon,"caja1",0,480);
        CajadeSalto caja2 = new CajadeSalto(salon,"caja2",530,0);
    }  
    
   public void salida(){
       int i=0;
       while(i<elementos.size()){
           if(elementos.get(i) instanceof Deportista){
                elementos.remove(i);
            }else if(elementos.get(i) instanceof Bola){
                elementos.remove(i);
            }else if (elementos.get(i) instanceof CajadeSalto){
                elementos.remove(i);
            }
            else{
                i++;
            }
        }
    }

    
   public void inicio(){
       for( EnSalon i:elementos){
           i.inicie();
        }
   }    

   public void parada(){
       for (EnSalon i:elementos){
           i.pare();
        }
   }    

   public void decision(){
        for (EnSalon i:elementos){
           i.decida();
        }
   }       
    
}
