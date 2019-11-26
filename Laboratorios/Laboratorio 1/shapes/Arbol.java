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
 * Esta clase reune las cualidades Nodos y los convierte en un arbol binario; 
 * estableciendo una jerarquia de padre e hijo.
 */
public class Arbol
{
    Nodo raiz;
    public Arbol()
    {
        raiz=null;
    }
    /**
     * Metodo que se encarga de insertas cada objeto que nos llega con la informacion 
     * mas importante como: dato y color.
     * 
     * Cada objeto tiene una cierta posicion dada la jerarquia que se establece en el problema.
     */
    public void insertar(int dato,String color)
    {
        Nodo nuevo = new Nodo(dato,color);
        if (raiz == null)
        {
            raiz=nuevo;
            raiz.fondo.makeVisible();
            raiz.capa.makeVisible();
        }
        else
        {
            Nodo aux = raiz;
            Nodo padre;
            while(true)
            {
                padre=aux;
                
                if (dato<aux.dato)
                {
                    aux=aux.izquierdo;
                    if (aux==null)
                    {
                        
                        padre.izquierdo=nuevo;
                      
                        
                        nuevo.fondo.moveHorizontal(((padre.xp)-150));
                        nuevo.fondo.moveVertical(padre.yp+75);
                        
                        nuevo.capa.moveHorizontal(((padre.xp)-150));
                        nuevo.capa.moveVertical((padre.yp)+75);
                        
                        nuevo.fondo.makeVisible();
                        nuevo.capa.makeVisible();
                        
                        nuevo.yp+=padre.yp+75;
                        nuevo.xp+=padre.xp-200;

                        return;
                    }
                }
                else
                {
                    aux=aux.derecho;
                    if (aux==null)
                    {
                        padre.derecho=nuevo;
                        nuevo.fondo.moveHorizontal((padre.xp)+150);
                        nuevo.fondo.moveVertical(padre.yp+75);

                        nuevo.capa.moveHorizontal(((padre.xp)+150));
                        nuevo.capa.moveVertical(padre.yp+75);
                        
                        nuevo.yp+=padre.yp+75;
                        nuevo.xp+=padre.xp+200;
                        nuevo.fondo.makeVisible();
                        nuevo.capa.makeVisible();
                        return;
                    }
                }
            }
        }
    }
  
}
