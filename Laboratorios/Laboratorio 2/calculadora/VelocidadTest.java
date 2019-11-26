//
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VelocidadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VelocidadTest
{
    private Velocidad v0,v50,v30,v100;
    private Angulo  a45;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        a45 = new Angulo (45, Angulo.GRADOS);
        v0 = new Velocidad(0, a45);
        v50 = new Velocidad(50, a45);
        v30 = new Velocidad(30, a45);
        v100 = new Velocidad(100, a45);
    }

    @Test
    public void deberiaCrearBienlaVelocidad() {
        assertTrue (v0.equals(v0));
        assertTrue (v50.equals(v50));
        assertTrue (v30.equals(v30));
        assertTrue (v100.equals(v100));

    }
    
    
    @Test
    public void deberiaComponenteH() {
        assertEquals (0.0,v0.componenteH(), Velocidad.MAXERROR);
        assertEquals (25*Math.pow(2,0.5),v50.componenteH(), Velocidad.MAXERROR);
        assertEquals (15*Math.pow(2,0.5),v30.componenteH(), Velocidad.MAXERROR);
        assertEquals (50*Math.pow(2,0.5),v100.componenteH(), Velocidad.MAXERROR);

    }
    
    @Test
    public void deberiaComponenteV() {
        assertEquals (0.0,v0.componenteV(), Velocidad.MAXERROR);
        assertEquals (25*Math.pow(2,0.5),v50.componenteV(), Velocidad.MAXERROR);
        assertEquals (15*Math.pow(2,0.5),v30.componenteV(), Velocidad.MAXERROR);
         // assertEquals (50*Math.pow(2,0.5),v100.componenteV(), Velocidad.MAXERROR);

    }
    
    @Test
    public void deberiaAngulo() {
        assertEquals (a45,v0.angulo());
        assertEquals (a45,v50.angulo());
        assertEquals (a45,v30.angulo());
    }
    
    @Test
    public void deberiaLongitud() {
        assertEquals (0.0,v0.longitud(), Velocidad.MAXERROR);
        assertEquals (50.0,v50.longitud(), Velocidad.MAXERROR);
        assertEquals (30.0,v30.longitud(), Velocidad.MAXERROR);
        assertEquals (100.0,v100.longitud(), Velocidad.MAXERROR);
    }
    
    @Test
    public void deberiaRote() {
        //assertTrue (v30.equals(v0.rote(v30.grados())));
    }
    
    @Test
    public void deberiatoString() {
        assertEquals ("(0.0,45.0)",v0.toString());
        assertEquals ("(50.0,45.0)",v50.toString());
        assertEquals ("(30.0,45.0)",v30.toString());
        assertEquals ("(100.0,45.0)",v100.toString());
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
