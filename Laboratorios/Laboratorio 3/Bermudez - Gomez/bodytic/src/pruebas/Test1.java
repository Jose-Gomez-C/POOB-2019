package pruebas;


import aplicacion.*;

import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test1
{
    /**
     * Default constructor for test class Test
     */
    public Test1()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    

    
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
    @Test
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
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
