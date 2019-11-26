package Pruebas;
import Aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class prueba{
	
	private Kalah juego;
	private Kalah segundoJuego;
	
	@Before
	public void setUp(){
		juego= new Kalah(6,3);
		segundoJuego = new Kalah(6,14);
	}
	
	@Test
	public void DeberiaCrearIgual(){
		int[] resultado= new int[] {0,0,4,4,4,3,3,0,3,3,3,3,3,3};
		try{
			boolean turno = juego.juegue(1);
			assertArrayEquals(juego.estado(),resultado);
			assertFalse(turno);
		}catch(KalahException e){
			System.out.println(e.getMessage());
		}	
	}
	@Test
	public void NoDeberiaCrearIgual(){
		int[] resultado= new int[] {0,0,4,4,4,3,3,0,3,3,3,3,3,3};
		try{
			boolean turno = juego.juegue(2);
			assertFalse(juego.estado()==resultado);
			assertFalse(turno);
		}catch(KalahException e){
			System.out.println(e.getMessage());
		}	
	}
	@Test
	public void NoDeberiaCambiarTurno(){
		int[] resultado= new int[] {0,3,3,3,0,4,4,1,3,3,3,3,3,3};
		try{
			boolean turno= juego.juegue(4);
			assertTrue(turno);
			assertArrayEquals(juego.estado(),resultado);
		}catch(KalahException e){
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void DeberiaRobar(){
		int[] resultado= new int[] {0,0,4,4,0,4,4,5,3,3,0,3,3,3};
		try{
			boolean turno= juego.juegue(4);
			boolean turno2= juego.juegue(1);
			assertTrue(turno);
			assertFalse(turno2);
			System.out.println(juego.estado());
			assertArrayEquals(juego.estado(),resultado);
		}catch(KalahException e){
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void DeberiaRotarCompleto(){
		int[] resultado= new int[] {0,1,16,15,15,15,15,1,15,15,15,15,15,15};
		try{
			boolean turno= segundoJuego.juegue(1);
			assertFalse(turno);
			assertArrayEquals(segundoJuego.estado(),resultado);
		}catch(KalahException e){
			System.out.println(e.getMessage());
		}
	}
}