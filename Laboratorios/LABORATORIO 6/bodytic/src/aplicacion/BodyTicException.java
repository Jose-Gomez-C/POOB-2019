package aplicacion;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class BodyTicException extends Exception {
	public static final String ERROR_AL_GUARDAR="Error al guardar.";
	public static final String ERROR_AL_ABRIR= "Error al abrir";
	public static final String ERROR_AL_EXTRAER= "Error al extraer";
	public static final String ERROR_AL_IMPORTAR= "Error al importar";
	//public static final String ERROR_DE_CLASE=""
	public BodyTicException(String message){
		super(message);
	}
}
