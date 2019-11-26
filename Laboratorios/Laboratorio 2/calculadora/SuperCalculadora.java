import java.util.Stack;

/** 
 * Representa una calculadora de velocidades
 * @author Jose Luis Gomez Camacho 
 * @author Steven Nikolai Bermudez Vega
 * @version 13/02/2019
 */

//No olvide documentar los métodos
public class SuperCalculadora{
    private Stack<Velocidad> operandos;
    private static boolean validacion = false; 
    //Consultar en el API Java la clase Stack
    
     /** 
     * Crea un contenedor de tipos velocidades
     * 
     */
    public SuperCalculadora(){
          operandos = new Stack<>();
    }
    
     /** Realiza una suma entre dos velocidades agregando este valor al contenedor
     * @param int longitud
     * @param int grados
     * @param int tipo
     */
    public void adicione(int longitud, int grados, int tipo){
        validacion = false;
        Angulo angulos= new Angulo(grados,tipo);
        Velocidad velocidades = new Velocidad(longitud,angulos);
        operandos.add(velocidades);
        validacion = true;
    }
    
     /** Elimina el primer elemento del contenedor
     */
    public void elimine(){
        validacion = false;
        operandos.pop();
        validacion = true;
    }
    
     /** Duplica el primer elemento del contenedor

     */
    public void duplique(){
        validacion = false;
        operandos.add(operandos.get(0));
        validacion = true;
    }
    
    //Los caracteres de las operaciones posibles son: +, -, x (producto vectorial),h (velocidad horizontal), v (velocidad vertical)
    /** Realiza las diferentes operaciones entre velocidades
     * @param char operacion
     */
    public void calcule(char operacion){
        validacion = false;
        if (operacion == '+'){
            Velocidad a = operandos.pop();
            Velocidad b = operandos.pop();
            a.sume(b);
            operandos.add(a);
            validacion = true;
        }else if(operacion == '-'){
            Velocidad a = operandos.pop();
            Velocidad b = operandos.pop();
            a.reste(b);
            operandos.add(a);
            validacion = true;
        }else if(operacion == 'x'){
            Velocidad a = operandos.pop();
            Velocidad b = operandos.pop();
            a.vectorial(b);
            operandos.add(a);
            validacion = true;
        }else if(operacion == 'h'){
            Velocidad a = operandos.pop();
            a.componenteH();
            operandos.add(a);
            validacion = true;
        }else if(operacion == 'v'){
            Velocidad a = operandos.pop();
            a.componenteV();
            operandos.add(a);
            validacion = true;
        }
        
    }
    
  
    //Los caracteres de las operaciones posibles son: * (producto escalar), t velocidad después de un tiempo
     /** Calcula el prodcto escalar y la velocidad despues de un tiempo de una velocidad
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public void calcule(char operacion, int parametro){
        validacion = false;
        if(operacion == '*'){
            Velocidad a = operandos.pop();
            a.escalar(parametro);
            operandos.add(a);
            validacion = true;
        }else if(operacion == 't'){
            Velocidad a = operandos.pop();
            a = new Velocidad(a.componenteV()-9.81*parametro,a.angulo());
            operandos.add(a);
            validacion = true;
        }
    }
    
     /** Muestra una velocidad
      * @return velocidad 
     */
    public String consulte(){
        validacion = false;
        return operandos.get(0).toString();
    }
    
     /** Verifica que todos los metodos se realicen de la manera adecuada
     * @return booleano 
     */
    public boolean ok(){
        return validacion;
    }
}
    



