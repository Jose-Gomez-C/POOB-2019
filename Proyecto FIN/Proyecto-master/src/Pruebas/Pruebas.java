package Pruebas;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Aplicacion.*;
public class Pruebas {
	@Test
	public void deberiaMoverBola() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		while(tablero.PerdioVida()) {
			bola.jugar();
			tablero.reducirVida();
		}
		assertTrue(tablero.PerdioVida());
		assertEquals(tablero.getVidas(), 2);
	}
	@Test
	public void deberiaTenerContactoBolaBase() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		Base base = tablero.creaBase();
		while (!bola.getShape().intersects(base.getForma())){
			bola.jugar();
		}
		base.tocoBola(bola);
		assertTrue(bola.getShape().intersects(base.getForma()));
		assertEquals(tablero.getVidas(), 3);
	}
	@Test
	public void deberiaTenerContactoBloque() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		Base base = tablero.creaBase();
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(100);
		Boolean tocoBloque=true;
		while(tocoBloque) {
			bola.jugar();
			for(int y =0; y<bloques.size();++y) {
				for(int x=0; x<bloques.get(y).size();++x) {
					tocoBloque=!bola.tocoBloque(bloques.get(y).get(x));
					//System.out.println(tocoBloque);
					if(!tocoBloque) {
						bloques.get(y).get(x).romperBloque();
						//System.out.println("hola");
					}
				}
			}
		}
		int bloquesRotos=0;
		for(int y =0; y<bloques.size();++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bloques.get(y).get(x).getEstaVivo())bloquesRotos+=1;
			}
		}
		//System.out.println(bloquesRotos);
		assertEquals(bloquesRotos, 6);
	}
	@Test
	public void deberiaTenerContactoBloquesVerde() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		Base base = tablero.creaBase();
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(101);
		Boolean tocoBloque=true;
		while(tocoBloque) {
			bola.jugar();
			for(int y =0; y<bloques.size();++y) {
				for(int x=0; x<bloques.get(y).size();++x) {
					tocoBloque=!bola.tocoBloque(bloques.get(y).get(x));
					//System.out.println(tocoBloque);
					if(!tocoBloque) {
						bloques.get(y).get(x).romperBloque();
						//System.out.println("hola");
					}
				}
			}
		}
		int bloquesRotos=0;
		for(int y =0; y<bloques.size();++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bloques.get(y).get(x).getEstaVivo())bloquesRotos+=1;
			}
		}
		//System.out.println(bloquesRotos);
		assertEquals(bloquesRotos, 7);
	}
	
	@Test
	public void deberiaTenerContactoBloqueGris() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		Base base = tablero.creaBase();
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(102);
		Boolean tocoBloque=true;
		while(tocoBloque) {
			bola.jugar();
			for(int y =0; y<bloques.size();++y) {
				for(int x=0; x<bloques.get(y).size();++x) {
					tocoBloque=!bola.tocoBloque(bloques.get(y).get(x));
					//System.out.println(tocoBloque);
					if(!tocoBloque) {
						bloques.get(y).get(x).romperBloque();
						//System.out.println("hola");
					}
				}
			}
		}
		int bloquesRotos=0;
		for(int y =0; y<bloques.size();++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bloques.get(y).get(x).getEstaVivo())bloquesRotos+=1;
			}
		}
		//System.out.println(bloquesRotos);
		assertEquals(bloquesRotos, 0);
	}
	@Test
	public void deberiaTenerContactoBloquesAzules() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Bola bola= tablero.creaBola();
		Base base = tablero.creaBase();
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(105);
		Boolean tocoBloque=true;
		while(tocoBloque) {
			bola.jugar();
			for(int y =0; y<bloques.size();++y) {
				for(int x=0; x<bloques.get(y).size();++x) {
					tocoBloque=!bola.tocoBloque(bloques.get(y).get(x));
					if(!tocoBloque) {
						bloques.get(y).get(x).romperBloque();
					}
				}
			}
		}
		int bloquesRotos=0;
		for(int y =0; y<bloques.size();++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bloques.get(y).get(x).getEstaVivo())bloquesRotos+=1;
			}
		}
		assertEquals(bloquesRotos, 6);
	}
	@Test
	public void deberiaCrearPoderescrearPoderes() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(103);
		ArrayList<Poder> poderes=tablero.getPoderesList();
		assertEquals(poderes.size(),8);
	}
	@Test
	public void deberiaTenerPoderesCorrectos() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(104);
		assertEquals(bloques.get(14).get(0).getPuntaje(), 100);
		assertEquals(bloques.get(14).get(1).getPuntaje(), 100);
		assertEquals(bloques.get(14).get(2).getPuntaje(), 300);
		assertEquals(bloques.get(14).get(3).getPuntaje(), 0);
	}
	@Test
	public void deberiaPoderBaseGrande() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Base base= tablero.creaBase();
		base.BaseGrande();
		assertEquals(base.getAncho(), 109);
	}
	@Test 
	public void DeberiaPoderBasePequena() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Base base= tablero.creaBase();
		base.basePequena();
		assertEquals(base.getAncho(), 69);
	}
	@Test 
	public void DeberiaPoderBolaRapida() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Base base= tablero.creaBase();
		Bola bola = tablero.creaBola();
		bola.bolaVelocidadRapida();
		assertEquals(bola.getDx(), 2);
	}
	@Test 
	public void DeberiaPoderCombinado() {
		Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
		Base base= tablero.creaBase();
		base.basePequena();
		base.BaseGrande();
		assertEquals(base.getAncho(), 109);
	}
	@Test
	public void DeberiaMoversePoder() {
			Arkanoid tablero= new Arkanoid("barraNormal","barraNormal","normal");
			Bola bola= tablero.creaBola();
			Base base = tablero.creaBase();
			ArrayList<ArrayList<Bloque>> bloques=tablero.CreaNivel(105);
			Boolean tocoBloque=true;
			while(tocoBloque) {
				bola.jugar();
				for(int y =0; y<bloques.size();++y) {
					for(int x=0; x<bloques.get(y).size();++x) {
						tocoBloque=!bola.tocoBloque(bloques.get(y).get(x));
						if(!tocoBloque) {
							bloques.get(y).get(x).romperBloque();
						}
					}
				}
			}
			int bloquesRotos=0;
			for(int y =0; y<bloques.size();++y) {
				for(int x=0; x<bloques.get(y).size();++x) {
					if(bloques.get(y).get(x).getEstaVivo())bloquesRotos+=1;
				}
			}
			tablero.moverPoder();
			ArrayList<Poder> poderes=tablero.getPoderesList();
			Poder poder = new Poder(10, 10);
			for(Poder i:poderes) {
				if (i.getmoverPoder())poder=i;
			}
			poder.setMoverpoder(true);
			assertTrue(poder.getmoverPoder());
			assertEquals(bloquesRotos, 6);
		
		
	}
}
