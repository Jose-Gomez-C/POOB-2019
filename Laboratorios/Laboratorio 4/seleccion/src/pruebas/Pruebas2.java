package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Pruebas2.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Pruebas2
{
    
    public Pruebas2()
    {
    }
    
    @Test
    public void Prueba01(){
        Seleccion s = new Seleccion();
        String a = s.toString();
		s.adicione("Edwin Yesid", "Rodriguez Maldonado", "172", "Delantero", "Mejor goleador del 2015");
		String b = s.toString();
		s.adicione("Johann", "Paez", "170", "Delantero", "Mejor jugador del mundo ");
		String c = s.toString();
		s.adicione("Nikolai","Bermudes","150","Defensa","Mejor jugador del 2000");
		
    }
	
    @Test
    public void Prueba02(){
        Seleccion s = new Seleccion();
        String a = s.toString();
		s.adicione("brayan" , "rojas", "172", "Delantero", "Mejor jugador 2015");
		String b = s.toString();
		s.adicione("Johann", "Paez", "170", "Delantero", "Mejor jugador del mundo ");
		String c = s.toString();
		s.adicione("Nikolai","Bermudes","150","Defensa","Mejor jugador del 2000");
		
    }
	
}