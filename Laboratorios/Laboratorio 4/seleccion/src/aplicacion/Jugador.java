package aplicacion; 
 
/**
 * @version ECI 2019-1
 */

public class Jugador{
    private String nombres;
    private String apellidos;
    private int estatura;    
    private String posicion;
    private String premios;  

 
    public Jugador(String nombres, String apellidos,  String  estatura, String posicion,  String premios){
        this.nombres = nombres.trim();
        this.apellidos = apellidos.trim();
		this.estatura = Integer.parseInt(estatura.trim());
		this.posicion = posicion.trim();
        this.premios = premios.trim();  
    }
    
    /**
     * @return 
     */
    public String getNombres(){
        return nombres;
    }

    /**
     * @return 
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * @return 
     */
    public int getEstatura(){
        return estatura;
    }    

    /**
     * @return 
     */
    public String getPosicion(){
        return posicion;
    }
    
    /**
     * @return 
     */
    public String getPremios(){
        return premios;
    }
    
    /**
     * @return 
     */
    public String toString(){
        return nombres +" "+apellidos+ " (" + posicion + ")" + "\n" + estatura + "\n" + premios  ;
    }

}
