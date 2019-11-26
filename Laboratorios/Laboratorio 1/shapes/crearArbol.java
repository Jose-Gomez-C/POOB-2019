import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @Jose Luis Gomez Camacho - Nikolai Bermudez Vega
 */
public class crearArbol
{
    public Arbol arbol;
   
    /**
     *  Constructor que se encarga en recibir la informacion para la creacion del arbol
     */
    public crearArbol(ArrayList<Integer> lista, String color)
    {
        arbol = new  Arbol();
        Collections.reverse(lista);
        for(  int i : lista){
           arbol.insertar(i,color);
           
        }
    }
}
