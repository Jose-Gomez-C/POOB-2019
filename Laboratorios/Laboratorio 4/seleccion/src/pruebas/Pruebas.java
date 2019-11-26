package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Pruebas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Pruebas
{
    
    public Pruebas()
    {
    }
    
    @Test
    public void Prueba01(){
        Seleccion s = new Seleccion();
        String anterior = s.toString();
		try{
		s.adicione("Edwin Yesid", "Rodriguez Maldonado", "172", "Delantero", "Mejor goleador del 2015");
		s.adicione("Johann", "Paez", "170", "Delantero", "Mejor jugador del mundo ");
		}catch(SeleccionException e){
			
		}
		String despues = s.toString();
		assertFalse(anterior.equals(despues));
    }
	
    @Test
    public void Prueba02(){
        Seleccion s = new Seleccion();
		try{
		s.adicione("Edwin Yesid", "Rodriguez Maldonado", "172", "Delantero", "Mejor goleador del 2015");
		s.adicione("Johann", "Paez", "170", "Delantero", "Mejor jugador del mundo ");
		s.adicione();
		}catch(SeleccionException e){
		}
		Jugador E = s.getInformacion("Edwin Yesid", "Rodriguez Maldonado");
    }
	
	@Test
	public void deberiaLanzarExcepcionSiElJugadorNoTieneApellido(){
		Seleccion s = new Seleccion();
		try{
		s.adicione("Yerry","","195","Defensa","Nada");
		fail("Lanzo Excepcion");
		}catch(SeleccionException e){
			assertEquals(e.getMessage(),SeleccionException.SIN_APELLIDO);
		}
		
	}
	@Test
	public void Prueba04(){
		Seleccion s = new Seleccion();
		try{
			s.adicione("Cristiano","Ronaldo","alto","Delantero","Uefa");
			fail("Lanzo Excepcion");
		}catch(Exception e){
			assertEquals(e.getMessage(),SeleccionException.ALTURA_INVALIDA);
			
		}
	}
	@Test
	public void deberiaLanzarExcepcionSiElJugadorEstaRepetido(){
		Seleccion s = new Seleccion();
		
		try{
			s.adicione("Cristiano","Ronaldo","185","Delantero","Uefa");
			s.adicione("Cristiano","Ronaldo","185","Delantero","Uefa");
			fail("Lanzo Excepcion");
		}catch(Exception e){
			assertEquals(e.getMessage(),SeleccionException.JUGADOR_REPETIDO);
			
		}
	}
	
	@Test
	public void deberiaLanzarExcepcionSiLaPosicionNoExiste(){
		Seleccion s = new Seleccion();
		
		try{
			s.adicione("Cristiano","Ronaldo","185","chef","Uefa");
			fail("Lanzo Excepcion");
		}catch(Exception e){
			assertEquals(e.getMessage(),SeleccionException.NO_EXISTE_POSICION);
			
		}
	}
	@Test
	public void deberiaLanzarExcepcionSiElJugadorNoTieneNombre(){
		Seleccion s = new Seleccion();
		try{
		s.adicione("","Mina","195","Defensa","Nada");
		fail("Lanzo Excepcion");
		}catch(SeleccionException e){
			assertEquals(e.getMessage(),SeleccionException.SIN_NOMBRE);
		}
		
	}
}