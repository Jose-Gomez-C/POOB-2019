/**
 * Librerias importadas de Java 
 * ArrayList para almacenar datos en memoria sin necesidad de declarar su tamaño.
 * Collections siendo todo aquello que se puede recorrer o iterar. Se puede saber su tamaño.
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 * Clase publica llamada Nodo
 */
public class Nodo {
    int dato;
    Nodo izquierdo,derecho;
    Circle fondo;
    Circle capa;
    int xp= 0;
    int yp= 0;
    final String[] colores= {"o","white","red","black","blue","yellow","green","magenta","gray","pink","orange","cyan"};
    /**
     * Constructor que establece unas caracteristicas a un objeto Nodo.
     */
    public Nodo(int numero,String color)
    {
        this.dato=numero;
        
        this.fondo= new Circle();
        this.fondo.changeSize(40);
        this.fondo.changeColor(color);
        this.fondo.moveVertical(150);
        this.fondo.moveHorizontal(900);
        
        this.capa= new Circle();
        this.capa.changeColor(colores[numero]);
        this.capa.moveVertical(150+5);
        this.capa.moveHorizontal(900+5);
        
        this.izquierdo=null;
        this.derecho=null;
    }
}