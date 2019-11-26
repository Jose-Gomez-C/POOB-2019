import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
      for(String i:nombres){
           Persona temp= new Persona(i);
           personas.add(temp);
           
        }
    }
    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
       int valorhora=0;
       if (0==personas.size()){
           throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
       for(Persona i:personas){
               valorhora+=i.valorHora();
        }
       return valorhora;
    }
    /**
     * Calcula el valor hora estimado de un equipo.
     * Más del 50% del equipo debe tener valores conocidos 
     * El valor de las personas a las que se desconoce su valor es el promedio entre el mínimo y el máximo de las conocidas
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor o existe una persona desconocida
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int valoresDesconocidos=0;
        int promedio=((valorHoraMaximo()+valorHoraMinimo())/2);
        int valorHora=0;
        System.out.println(personas.size());
        if (0==personas.size()){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        for(Persona i:personas){
            try{
                valorHora+=i.valorHora();
            }catch (EquipoExcepcion e){

                if (e.getMessage().equals(EquipoExcepcion.PERSONA_DESCONOCIDA)){
                    throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
                }else{
                    System.out.println(valoresDesconocidos+"entro");
                    valorHora+=promedio;
                    ++valoresDesconocidos;
                    if (valoresDesconocidos>personas.size()/2){
                        throw new EquipoExcepcion(EquipoExcepcion.MAS_50);
                     }
                }
            }
         }
        return valorHora/personas.size();
    }   
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor hora de los desconocidos es el valor de la primera persona conocida
     * El valor hora de los que no se conoce su valor es el valor de la última persona conocida
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor 
     */
    public int valorHoraAsumido()throws EquipoExcepcion{
        if (0==personas.size()){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
         }
        int primero=primerValorHora();
        if(primero==0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        int ultimo=ultimoValorHora();
        int total=0;
        for(Persona i:personas){
            try{
                total+=i.valorHora();
            }catch(EquipoExcepcion e){
                if (e.getMessage().equals(EquipoExcepcion.PERSONA_DESCONOCIDA)){
                    total+=primero;
                }else if (e.getMessage().equals(EquipoExcepcion.VALOR_DESCONOCIDO)){
                    total+=ultimo;
                }
            }
        }
        return total;
    }
    private int primerValorHora()throws EquipoExcepcion{
        int primero=0;
        boolean encontro=true;
        for(int i=0;i<personas.size()&&encontro;++i){
            try{
                primero=personas.get(i).valorHora();
                encontro=false;
            }catch(EquipoExcepcion e){
            }
        }
        return primero;
    }
    private int ultimoValorHora()throws EquipoExcepcion{
        int ultimo=0;
        boolean encontro=true;
        for(int i=personas.size()-1;i>=0&&encontro;--i){
            try{
                ultimo=personas.get(i).valorHora();
                encontro=false;
            }catch(EquipoExcepcion e){
            }
        }
        return ultimo;
    }
    private int valorHoraMaximo()throws EquipoExcepcion{
        int max=0;
        
        for (Persona i:personas){
            try{
                max=i.valorHora()>max?i.valorHora():max;
            }catch(EquipoExcepcion e){
                
            }
        }
        return max;
    }
    private int valorHoraMinimo()throws EquipoExcepcion{
        int min=Integer.MAX_VALUE;
        for (Persona i:personas){
            try{
                min=i.valorHora()<min?i.valorHora():min;
            } catch(EquipoExcepcion e){
            }
        }
        return min;
    }
}
