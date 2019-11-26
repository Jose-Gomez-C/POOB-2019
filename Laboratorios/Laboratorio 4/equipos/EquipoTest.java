import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EquipoTest{
   

    
    public EquipoTest(){
    }


    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }
    
    @Test
    public void deberiaCalcularElValorDeUnEquipo(){
        String [] nombres={"Pedro","Judas"};
        Equipo eq= new Equipo(nombres);
        try {
           assertEquals(60000,eq.valorHora());
        } catch (EquipoExcepcion e){
            fail("Lanzó excepcion");
        }    
    }    
    
    @Test
    public void deberiaLanzarExcepcionSiElEquipoNoTienePersonas(){
        String [] nombres={};
        Equipo eq= new Equipo(nombres);
        try { 
           int valor=eq.valorHora();
           fail("No lanzó excepcion");
        } catch (EquipoExcepcion e) {
            assertEquals(EquipoExcepcion.EQUIPO_VACIO,e.getMessage());
        }    
    }    
   @Test
    public void deberiaLanzarExcepcionSiNoSeConoceElValorDeUnaPersona(){
        String [] nombres={"Pedro","Garcia","Juan"};
        Equipo eq= new Equipo(nombres);
        try { 
           int valor=eq.valorHora();
           fail("No lanza la excepcion");
        } catch (EquipoExcepcion e) {
            assertEquals(EquipoExcepcion.VALOR_DESCONOCIDO,e.getMessage());
        }    
    }     
    
   @Test
    public void deberiaLanzarExcepcionSiNoSeConoceUnaPersona(){
        String [] nombres={"Pedro","Carlos","Juan"};
        Equipo eq= new Equipo(nombres);
        try { 
           int valor=eq.valorHora();
           fail("No lanza la excepcion");
        } catch (EquipoExcepcion e) {
            assertEquals(EquipoExcepcion.PERSONA_DESCONOCIDA,e.getMessage());
        }    
    }
   @Test
   public void deberiaCalcularElvalorHoraEstimado(){
        String [] nombres={"Pedro","Judas","Marcos","Juan","Judas"};
        Equipo eq= new Equipo(nombres);
        try {
            assertEquals(36000,eq.valorHoraEstimado());
        } catch (EquipoExcepcion e){
            fail("Lanzó excepcion");
        } 
    }
   @Test
   public void deberiaLanzarExpepcionSiNoSeConoceUnaPersona(){
        String [] nombres={"Pedro","Judas","Marcos","Juan","Judas","Nico"};
        Equipo eq= new Equipo(nombres);
        try {
           int valor=eq.valorHoraEstimado();
           fail("No lanza la excepcion");
        } catch (EquipoExcepcion e){
            assertEquals(EquipoExcepcion.PERSONA_DESCONOCIDA,e.getMessage());
        } 
    }
   @Test
   public void deberiaCalcularElvalorHoraEstimado2(){
        String [] nombres={"Pedro","Judas","Marcos","Juan","Santiago","Garcia"};
        Equipo eq= new Equipo(nombres);
        try {
            assertEquals(30000,eq.valorHoraEstimado());
        } catch (EquipoExcepcion e){
            fail("Lanzó excepcion");
        } 
    }
   @Test
   public void deberiaLanzarExpepcionMas50(){
       String [] nombres={"Judas","Garcia","Ospina","Guarin"};
       Equipo eq= new Equipo(nombres);
       try {
           int valor=eq.valorHoraEstimado();
           fail("No lanza la excepcion");
        } catch (EquipoExcepcion e){
            assertEquals(EquipoExcepcion.MAS_50,e.getMessage());
        } 
    }
   @Test
   public void deberiaCalcularElvalorHoraAsumido(){
       String [] nombres={"Judas","Garcia","Ospina","Guarin"};
       Equipo eq= new Equipo(nombres);
       try {
           assertEquals(200000,eq.valorHoraAsumido());
        } catch (EquipoExcepcion e){
            System.out.println(e.getMessage());
            fail("Lanzó excepcion");
        } 
    }
   @Test
   public void deberiaLanzarExcepcionSiElEquipoNoTienePersonasValorAsumido(){
       String [] nombres={};
       Equipo eq= new Equipo(nombres);
        try { 
           int valor=eq.valorHoraAsumido();
           fail("No lanzó excepcion");
        } catch (EquipoExcepcion e) {
            assertEquals(EquipoExcepcion.EQUIPO_VACIO,e.getMessage());
        } 
    }
    }

