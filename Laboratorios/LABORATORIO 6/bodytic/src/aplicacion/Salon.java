package aplicacion;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

import javax.swing.JOptionPane;


/**
 * @author ECI 2014
 * Salon de la aplicación egiptologos
 */
/**
 * @author ECI
 *
 */
public class Salon implements Serializable{
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
            }else{
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
    public void guardar01(String nombreArchivo)throws BodyTicException{
    	try {
    	ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
    	salida.writeObject(this);
    	salida.close();
    	}catch (Exception e) {
			throw new BodyTicException(BodyTicException.ERROR_AL_GUARDAR);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
    }

    public void guardar(String nombreArchivo)throws IOException{
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            salida.writeObject(this);
            salida.close();
    }

    public void abrir01(String nombreArchivo) throws BodyTicException{
        try {
            ObjectInputStream documento = new ObjectInputStream(new FileInputStream(nombreArchivo));
            salon = (Salon)documento.readObject();
        }catch (Exception e) {
            throw new BodyTicException(BodyTicException.ERROR_AL_ABRIR);
        }
    }

    public void abrir(String nombreArchivo) throws IOException, ClassNotFoundException {
            ObjectInputStream documento = new ObjectInputStream(new FileInputStream(nombreArchivo));
            salon = (Salon)documento.readObject();
    }

    public void extraer(String nombreArchivo) throws BodyTicException{
    	try {
    		PrintWriter archivo = new PrintWriter(new FileOutputStream(nombreArchivo)) ;
    		for(EnSalon i: elementos) {
    			archivo.println(i.getClase()+" "+i.getPosicionX()+" "+i.getPosicionY()+" "+i.getNombre());
    		}
    		archivo.close();
    	}catch (Exception e) {
    		throw new BodyTicException(BodyTicException.ERROR_AL_EXTRAER);
    		}
    }
    public void importar(String nombreArchivo) throws BodyTicException{
    	try {
	    	BufferedReader archivo= new BufferedReader(new FileReader(nombreArchivo));
	    	String linea=archivo.readLine();
	    	String[] lista;
	    	salon=new Salon();
	    	while(linea != null) {
	    		linea=linea.trim();
	    		lista=linea.split(" ");
	    		if (lista[0].equals("Hablador")) elementos.add(new DeportistaHablador(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Avanzado")) elementos.add(new DeportistaAvanzado(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Principiante")) elementos.add(new DeportistaPrincipiante(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Deportista")) elementos.add(new Deportista(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Bola")) elementos.add(new Bola(salon, "Auto", Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Cajadesalto")) elementos.add(new CajadeSalto(salon, "Auto", Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		linea=archivo.readLine();
	    	}
    	}catch (IOException e) {
    		throw new BodyTicException(BodyTicException.ERROR_AL_IMPORTAR);
    	}
    }
    public void importar02(String nombreArchivo) throws BodyTicExceptionCompilador,BodyTicException{
    	try {
	    	BufferedReader archivo= new BufferedReader(new FileReader(nombreArchivo));
	    	String linea=archivo.readLine();
	    	String[] lista;
	    	salon=new Salon();
	    	int numeroLinea=0;
	    	while(linea != null) {
	    		linea=linea.trim();
	    		lista=linea.split(" ");
	    		compilador(lista, numeroLinea);
	    		if (lista[0].equals("Hablador")) elementos.add(new DeportistaHablador(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Avanzado")) elementos.add(new DeportistaAvanzado(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Principiante")) elementos.add(new DeportistaPrincipiante(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Deportista")) elementos.add(new Deportista(salon, lista[3], Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Bola")) elementos.add(new Bola(salon, "Auto", Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else if (lista[0].equals("Cajadesalto")) elementos.add(new CajadeSalto(salon, "Auto", Integer.parseInt(lista[1]), Integer.parseInt(lista[2])));
	    		else throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.CLASE_NO_ENCONTRADA, numeroLinea);
	    		linea=archivo.readLine();
	    		++numeroLinea;
	    	}
    	}catch (IOException  e) {
    		throw new BodyTicException(BodyTicException.ERROR_AL_IMPORTAR);
    	}
    }
    public void compilador(String[] linea,int numeroDeLinea) throws BodyTicExceptionCompilador{
    	if (linea.length!=3 && linea.length!=4)throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.FALTAN_ELEMENTOS,numeroDeLinea);
    	if (linea[0].equals("true") || linea[0].equals("false"))throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.NOMBRE_BOOLEANO,numeroDeLinea);
    	if (verificarNumerico(linea[0]))throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.NOMBRE_NUMERICO,numeroDeLinea);
    	if (!verificarNumerico(linea[1]) || !verificarNumerico(linea[2]))throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.INDICE_NO_NUMERICO,numeroDeLinea);
    	if (Integer.parseInt(linea[1])<0 || Integer.parseInt(linea[2])<0)throw new BodyTicExceptionCompilador(BodyTicExceptionCompilador.FUERA_DEL_LIMITE,numeroDeLinea);
    }
    	/**
    	*Verifica si un string consta de un valor numerico

    	*@param str string a verificar

    	@return valor booleano, es true si el string es un numero y false de lo contrario

    	*/
    	public boolean verificarNumerico(String str){
    		boolean validacion=true;
	    	try{
	    		int n=Integer.parseInt(str);
	    	}catch(NumberFormatException e){
	    		validacion=false;
	    	}
	    	return validacion;
	    	}
}
