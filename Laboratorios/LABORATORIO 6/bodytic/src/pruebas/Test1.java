package pruebas;


import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aplicacion.BodyTicException;
import aplicacion.Deportista;
import aplicacion.DeportistaAvanzado;
import aplicacion.DeportistaHablador;
import aplicacion.Salon;


public class Test1 {
    
    @Test
    public void deberiaHacerPosicionX(){
        Salon salon = null;
        salon = salon.demeSalon();
        DeportistaHablador niki = new DeportistaHablador(salon, "niki", 100,100);
        DeportistaHablador brown = new DeportistaHablador(salon, "brown", 400,100);
        int a = niki.getPosicionX();
        int b = brown.getPosicionX();
        niki.inicie();
        brown.inicie();
        assertTrue(niki.getPosicionX() > 100);
        assertTrue(brown.getPosicionX() > 100);
        niki.inicie();
        brown.inicie();
        niki.inicie();
        brown.inicie();
        assertEquals(a, niki.getPosicionX());
        assertEquals(b, brown.getPosicionX());
    }
    

     @Test
    public void deberiaMoverseDiferente(){
        Salon salon = null;
        salon = salon.demeSalon();
        Deportista deportista = new DeportistaHablador(salon,"deportista",0,0);
        Deportista deportista2 = new DeportistaAvanzado(salon,"deportista2",0,0);
        deportista.inicie();
        deportista2.inicie();
        deportista.inicie();
        deportista2.inicie();              
        assertTrue(deportista.getPosicionX()!=deportista2.getPosicionX());
    }
    //@Test
    public void deberiaSaltar(){
        Salon salon = null;
        salon = salon.demeSalon();
        DeportistaHablador niki = new DeportistaHablador(salon, "niki", 100,100);
        DeportistaHablador brown = new DeportistaHablador(salon, "brown", 400,100);
        int a = niki.getPosicionY();
        int b = brown.getPosicionY();
        niki.inicie();
        brown.inicie();
        assertTrue(niki.getPosicionY() > a);
        assertTrue(brown.getPosicionY() > a);
        niki.inicie();
        brown.inicie();
        assertEquals(a, niki.getPosicionY());
        assertEquals(b, brown.getPosicionY());
        niki.inicie();
        brown.inicie();   
        niki.inicie();
        brown.inicie();         
        assertFalse(a == niki.getPosicionY());
        assertFalse(b != brown.getPosicionY());
    }
    @Test
	public void deberiaAbrir01() {
		Salon salon = Salon.demeSalon();
		try {
			salon.abrir01("src/pruebas/save.dat");
		} catch (BodyTicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void noDeberiaAbrir01() {
		Salon salon = Salon.demeSalon();
		try {
			salon.abrir01("");
		} catch (BodyTicException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Test
	public void deberiaSalvar01() {
		Salon salon = Salon.demeSalon();
		try {
			salon.guardar01("salvar01Prueba");
		} catch (BodyTicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void noDeberiaImportar() {
		Salon salon = Salon.demeSalon();
		try {
			salon.importar("");
		} catch (BodyTicException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
    	
    	

}
