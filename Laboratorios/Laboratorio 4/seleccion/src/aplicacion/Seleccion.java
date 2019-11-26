package aplicacion; 

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @version ECI 2019-1
 */

public class Seleccion{
    private LinkedList <Jugador> jugadores;
	private  String[] posiciones= {"delantero","Defensa","Delantero","arquero","defensa","medio campo","lateral","extremo izquierdo","extremo derecho","defensa central","mediocampista"};
	
    public Seleccion(){
        jugadores = new LinkedList<Jugador>();
    }
    
    /**
     * Adiciona algunos jugadores
     */
    public void adicione(){
        Jugador ejemplos[] = {
	        new Jugador("James David","Rodríguez Rubio", "181","Mediocampista",
	        "Recibió en 2009, 2012 y 2014 el premio de jugador revelación de la Primera División de Argentina y en la Primeira Liga de Portugal"),        
	        new Jugador("Radamel Falcao","García Zárate", "177","Delantero",
	        "(11º) mejor jugador del mundo, según la votación del FIFA Balón de Oro 2013"),                            
            new Jugador("David","Ospina Ramírez", "183","Arquero",
	        "Jugador del partido contra Estados Unidos en la Copa América Centenario 2016"),   

        };
        for(Jugador informacion : ejemplos) {
            adicione(informacion);
        }
    }
    
   
    
    /**
     * Consulta la información de un jugador
     */
    public Jugador getInformacion(String nombres,String apellidos){
    	Jugador c=null;
    	for(int i=0;i<jugadores.size() && c == null;i++){
    	    if (jugadores.get(i).getNombres().compareToIgnoreCase(nombres)==0 &&
                   (jugadores.get(i).getApellidos().compareToIgnoreCase(apellidos)==0)){
                   c=jugadores.get(i);
                }
    	}
    	return c;
    }


    /**
     * Adiciona un nuevo jugador
     */
    public void adicione(String nombres, String apellidos, String  estatura, String posicion,  String premios) throws SeleccionException{
		boolean existeLaPosicion = true;
		if(nombres.equals("")) throw new SeleccionException(SeleccionException.SIN_NOMBRE);
		for (Jugador i: jugadores){
			if(i.getNombres().equals(nombres) && i.getApellidos().equals(apellidos)) throw new SeleccionException(SeleccionException.JUGADOR_REPETIDO);
		}
		if(apellidos.equals("")) throw new SeleccionException(SeleccionException.SIN_APELLIDO);
		for(int i=0;existeLaPosicion && i<posiciones.length;++i){
			if(posiciones[i].equals(posicion.toLowerCase())) existeLaPosicion= false;
		}
		if(existeLaPosicion) throw new SeleccionException(SeleccionException.NO_EXISTE_POSICION);
		
		try {
			Integer.parseInt(estatura.trim()); 
		} catch (Exception e){
			throw new SeleccionException(SeleccionException.ALTURA_INVALIDA);
		}
		adicione(new Jugador(nombres, apellidos, estatura, posicion, premios));
    }

    /**
     * Adiciona un nuevo jugadores
     */
    public void adicione(Jugador informacion){
		
    	int i=0;
    	while ((i<jugadores.size()) && (jugadores.get(i).getApellidos().compareToIgnoreCase(informacion.getApellidos())<0)){
    	    i++;
    	}
    	jugadores.add(i,informacion);
    }
    

    
    /**
     * Consulta las jugadores que inican con un prefijo
     * @param prefijo El prefijo a buscar
     * @return 
     */
    public ArrayList<Jugador> busque(String prefijo){
        ArrayList<Jugador> resultados=null;
    	prefijo=prefijo.toUpperCase();
    	for(int i=0;i<jugadores.size();i++){
    	    if(jugadores.get(i).getNombres().toUpperCase().startsWith(prefijo)){
    	       resultados.add(jugadores.get(i));
    	    }	
    	}
        return resultados;
    }

    /**
     * Consulta el numero de jugadores
     * @return 
     */
    public int numeroJugadores(){
        return jugadores.size();
    }


    /**
     * Consulta todos los jugadores
     * @return 
     */
    public String toString(){
	StringBuffer allEntries=new StringBuffer();
        for(Jugador informacion : jugadores) {
            allEntries.append(informacion.toString().length()<=150? informacion: informacion.toString().substring(0,140)+"...");
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}
