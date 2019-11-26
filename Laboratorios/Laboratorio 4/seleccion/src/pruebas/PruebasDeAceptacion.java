package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PruebasDeAceptacion.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PruebasDeAceptacion
{
    
    public PruebasDeAceptacion()
    {
    }
    
    @Test
    public void Prueba01(){
        Seleccion s = new Seleccion();
        String anterior = s.toString();
		s.adicione("Edwin Yesid", "Rodriguez Maldonado", "172", "Delantero", "Mejor goleador del 2015");
		String siguiente = s.toString();
		assertNotEquals(anterior, siguiente);
		s.adicione("Johann", "Paez", "170", "Delantero", "Mejor jugador del mundo"); 
		String mismo = s.toString();
		assertNotEquals(mismo, siguiente);
    }
	
    @Test
    public void Prueba02(){
        Seleccion s = new Seleccion();
        String anterior = s.toString();
		s.adicione("Edwin Yesid", "Rodriguez Maldonado", "172", "Delantero", "Mejor goleador del 2015");
		String siguiente = s.toString();
		assertNotEquals(anterior, siguiente);
		s.adicione();
		String mismo = s.toString();
		assertNotEquals(mismo, siguiente);
		
    }
}