

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SuperCalculadoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SuperCalculadoraTest
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    private Velocidad v0,v50,v60,v30,v100;
    private Angulo a45;
    @Before
    public void setUp()
    {
        v0 = new Velocidad(0, a45);
        v50 = new Velocidad(50, a45);
        v30 = new Velocidad(30, a45);
        v100 = new Velocidad(100, a45);
    }

}
