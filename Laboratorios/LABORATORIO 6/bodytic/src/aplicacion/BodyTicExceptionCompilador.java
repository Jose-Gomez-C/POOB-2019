package aplicacion;

public class BodyTicExceptionCompilador extends Exception {
	public final static String FALTAN_ELEMENTOS = "El archivo que trata de importar no tiene el numero correcto de instrucciones";
	public final static String NOMBRE_BOOLEANO = "El archivo que trata de importar tiene un booleano en lugar de el nombre de un elemento";
	public final static String NOMBRE_NUMERICO = "El archivo que trata de importar tiene un numero en lugar de el nombre de un elemento";
	public final static String FUERA_DEL_LIMITE = "El archivo que trata de importar tiene un elemento en una posicion fuera de las dimensiones de la matriz";
	public final static String ESTADO_NO_BOOLEANO = "El archivo que trata de importar tiene un elemento con un estado que no es booleano";
	public final static String INDICE_NO_NUMERICO = "El archivo que trata de importar tiene indices no numericos para un elemento";
	public final static String CLASE_NO_ENCONTRADA = "El archivo que trata de importar tiene un nombre de clase no definido";;
	public BodyTicExceptionCompilador(String message,int linea){
		super("En la linea "+linea+" "+message);
	}
}

