import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCity.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestCity
{
    private CityOfHeroes t1, t2;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        t1=new CityOfHeroes(1500,600);
    }
    @Test
    public void t(){
        t1.addBuilding(0,100,100,15);
        t1.addBuilding(100,100,200,15);
        t1.addBuilding(300,100,450,15);
        t1.addBuilding(400,100,100,15);
        t1.addHeroe("green",1,15);
        t1.makeVisible();
        //t1.jump("green",106,79,true);
        int[]lista=t1.jumpPlan("green",3);
        System.out.println(lista[0]+" "+lista[1]);
        t1.jump("green",lista[1],lista[0],true);
    }
    @Test
    public void edificio(){
        t1.makeVisible();
        t1.addBuilding(100,100,100,15);
        t1.addHeroe("blue",1,45);
        t1.addBuilding(400,100,5,15);
        t1.makeVisible();
        //t1.jump("blue",55,45,true);

        //t1.removeHero("blue");
        //t1.jump("blue",50,60,true);
        //t1.addHeroe("green",2,50);
        //t1.jump("green",50,45,true);
        boolean ok=t1.isSafejump("blue",167,87);
        if(ok){
        t1.jump("blue",167,87,true);
        }else{
            System.out.println(ok);
        }
        
    }
    @Test
    public void deberiaJumpPlan(){
        t1.addBuilding(0,100,100,100);
        t1.addHeroe("blue",1,45);
        t1.addBuilding(300,300,300,300);
        t1.makeVisible();
        int[] list=t1.jumpPlan("blue",2);
        t1.jump("blue",74,58,true);
        //System.out.println(t2.jumpPlan("blue",2));
    }
    @Test
    public void deberiaLlegar(){
        t1.addBuilding(0,100,200,100);
        t1.addHeroe("blue",1,45);
        t1.addBuilding(400,100,700,300);
        t1.makeVisible();
        t1.jumpPlan("blue",2);
        t1.jump("blue",105,71,true);
        //System.out.println(t2.jumpPlan("blue",2));
    }
}
