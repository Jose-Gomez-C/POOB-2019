
/**
 * @author Jose Luis Gomez Camacho 
 * @author Steven Nikolai Bermudez Vega
 * @version 13/02/2019
 */
public class Velocidad{

    public static final double MAXERROR = 0.00000000000001;
    
    private double longitud;
    private Angulo angulo;
    
    /**
     * Constructor de la velocidad, en componentes polares
     * @param l longitud de la velocidad
     * @param a angulo de la velocidad
     */
    public Velocidad (double l, Angulo a) {
        longitud = l;
        angulo = a;
    }

    /**
     * Retorna el componente horizontal
     * @return componente horizontal de la velocidad
     */
    public double componenteH() {
        return angulo.coseno ()*longitud;
    }

    /**
     * Retorna el componente vertical de la velocidad
     * @return  componente vertical de la velocidad
     */
    public double componenteV() {
        return angulo.seno ()*longitud;
    }


    /**
     * Retorna el angulo de la velocidad
     * @return angulo de la velocidad
     */
    
    public Angulo angulo () {
        return angulo;
    }


    /**
     * Retorna la longitud de la velocidad
     * @return la longitud del origen al velocidad
     */
    public double longitud() {
        return longitud;
    }
    

    
    /**
     * Compara a esta velocidad con otra, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param v Velocidad para compararse
     * @return |this - a| < MAXERROR
     */
    private boolean equals (Velocidad v) {
        return (Math.abs(this.longitud - v.longitud)< MAXERROR);
    
    }

    /**
     * Compara a este velocidad con otra, para ver si son iguales, 
     * @param o objeto para compararse
     * @return valor booleano
     */
    @Override
    public boolean equals (Object o) {
        Velocidad a = (Velocidad) o;
        return equals (a) ;
    }
    

    /**
     * Rota el velocidad el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial de la velocidad, 
     * y la distancia es la misma.
     * @param a Angulo de la velocidad
     */
    public void rote(Angulo a) {
        this.angulo= this.angulo.sume(a);
    }

     /**
     * Suma las velocidades dadas
     * @param v Velocidad
     */
    public  void sume(Velocidad v){
        this.longitud = this.longitud+v.longitud;
    }
    
     /**
     * Resta las velocidades dadas
     * @param v Velocidad
     */
    public void reste(Velocidad v){
        this.longitud=this.longitud-v.longitud;
    }
    
    /**
     * Realiza una multiplicacion escalar a la velocidad
     * @param operando Int
     */
    public void escalar(int operando){
        this.longitud =this.longitud*(operando);
    }    
    
    /**
     * Realiza un producto vectorial con una velocidad dada
     * @param v Velocidad
     */
    public void vectorial(Velocidad v){
        this.longitud = 0;
        this.angulo = new Angulo(0,1);
    }
    
    //Adicione los métodos que requiera
    
    /** 
     * Retorna una cadena que describe a este velocidad (en componentes polares)
     * @return la informacion del objeto
     */
    @Override
    public String toString () {
        String s = "(" + String.valueOf(this.longitud)+","+ angulo.toString()+")";
        return s;
    }

}
