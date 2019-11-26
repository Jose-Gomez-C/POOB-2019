package Aplicacion;

public class KalahException extends Exception{
	public static final String ES_UN_ALMACEN="Es un almacen.";
	public static final String NO_ES_SU_CASA= "No es su casa.";
	public static final String NO_HAY_SEMILLAS ="No hay semillas";
	public static final String NO_HAY_GANADOR ="No hay ganador";
	public KalahException (String message){
		super(message);
	}
}