package Aplicacion;

public class ArkanoidException extends Exception {
	public final static String NO_GUARDO="No se pudo guardar.";
	public final static String NO_ABRIO= "No se pudo abrir.";
	public ArkanoidException(String message) {
		super(message);
	}
}
