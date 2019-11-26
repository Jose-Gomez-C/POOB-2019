package equipos;

import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    public double o = double.POSITIVE_INFINITY;
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
      return 0;
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
       return 0;
    };
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * Más del 50% del equipo debe tener valores conocidos 
     * El valor de las personas a las que se desconoce su valor es el promedio entre el mínimo y el máximo de las conocidas
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor o existe una persona conocida
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        return 0;
    }   
    
    
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor hora de los desconocidos es el valor de la primera persona conocida
     * El valor hora de los que no se conoce su valor es el valor de la última persona conocida
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor 
     */
    public int valorHoraAsumido(){
        return 0;
    }   
    
    
    
}
