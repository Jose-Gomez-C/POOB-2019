package aplicacion; 


public class SeleccionException extends Exception{
	
	public static final String  SIN_APELLIDO = "El campo apellido esta vacio";
    public static final String  ALTURA_INVALIDA="La altura no es de tipo String";
    public static final String  JUGADOR_REPETIDO="El jugador ya esta en la seleccion.";
    public static final String  NO_EXISTE_POSICION="La posicion no existe.";
	public static final String  SIN_NOMBRE="El campo nombre esta vacio.";
    public SeleccionException(String message){
        super(message);
    }

}