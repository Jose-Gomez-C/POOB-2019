 /**
 * Librerias importadas de Java 
 * ArrayList para almacenar datos en memoria sin necesidad de declarar su tamaño.
 * Collections siendo todo aquello que se puede recorrer o iterar. Se puede saber su tamaño.
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 * @Jose Luis Gomez Camacho - Nikolai Bermudez Vega
 * 
   */
public class Ceiling
{
    // instance variables - replace the example below with your own
    ArrayList<Integer> grafo= new ArrayList<Integer>();
    ArrayList<Rectangle> piezas;
    private final String[] colores= {"o","white","red","black","blue","yellow","green","magenta","gray","pink","orange","cyan"};
    private String colorfondo;
    public Rectangle fondo;
    public Rectangle fondo1;
    public Rectangle pieza;
    public  static int xp;
    public static int yp;
    crearArbol arbol;
    
    /**
     * Esta funcion crea una figura reprentativa de techo,
     * el techo a representar su longitud maxima debe ser de 10 y los 
     * colores permitidos para el fondo son:
     * "white","red","black","blue","yellow","green","magenta",
     * "gray","pink","orange" y "cyan" el ultimo es el recomendable para que 
     * no exista conflictos con el color de los numeros. 
     */
    public Ceiling(int[] list,String color)
    {
        
        piezas = new ArrayList<Rectangle>();
        colorfondo=color;
        for (int i : list){
            grafo.add(i);
        }

        fondo= new Rectangle();
        fondo.changeSize(40+(32*(grafo.size()-1)),46);
        fondo.changeColor(color);
        Collections.reverse(grafo);
        for (int i = 0; i < grafo.size();++i){
            pieza = new Rectangle();
            pieza.moveVertical(3+(i*32));
            pieza.moveHorizontal(3);
            pieza.changeColor(colores[grafo.get(i)]);
            piezas.add(pieza);
        }
        
    }
    /**
     * Metodo que se encarga de generar de añadir una capa a nuestro grafo actual
     */
    public void add (int layer)
    {
        grafo.add(0,layer);
        fondo.changeSize(40+(32*(grafo.size()-1)),46);
        
        for (int i = 0; i < grafo.size();++i){
            pieza = new Rectangle();
            pieza.moveVertical(3+(i*32)+xp);
            pieza.moveHorizontal(3+yp);
            pieza.changeColor(colores[grafo.get(i)]);
            piezas.add(pieza);
        }
    }
    /**
     * Metodo que se encarga de borrar cada objeto cuando el usuario lo desee.
     */
    public void delete()
    {
        grafo.remove(0);
        for (Rectangle i :piezas)
        {
            i.makeInvisible();
        }
        piezas.clear();
        fondo.changeSize((40+(32*(grafo.size()-1))),46);
        for (int i = 0; i < grafo.size();++i){
            pieza = new Rectangle();
            pieza.moveVertical(3+(i*32)+xp);
            pieza.moveHorizontal(3+yp);
            pieza.changeColor(colores[grafo.get(i)]);
            piezas.add(pieza);
    }
}
    /**
     * Metodo que se encarga del movimiento horizontal (x) y vertical (y) de los objetos.
     */
    public void move(int x, int y)
    {
        fondo.makeInvisible();
        xp+=x;
        yp+=y;
        fondo.moveVertical(y);
        fondo.moveHorizontal(x);
        for (Rectangle i :piezas)
        {
            i.makeInvisible();
        }
        for (Rectangle i:piezas)
        {
            i.moveVertical(y);
            i.moveHorizontal(x);
        }
        fondo.makeVisible();
        for (Rectangle i :piezas)
        {
            i.makeVisible();
        }
 
    
    }
    /**
     * Metodo que hace visible el conjunto de objeto que tenemos como rectangulos.
     */
    public void showCeiling(){
        fondo.makeVisible();
        for (Rectangle i : piezas){
            i.makeVisible();
        }
        
    }
    /**
     * Metodo que hace visible el arbol binario ingresado.
     */
    public void showTree()
    {
        arbol= new crearArbol(grafo,colorfondo);
        
        
    }
    
}    