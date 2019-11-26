import java.util.Scanner;


/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados o radianes
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias para mantenerlos en grados
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author Jose Luis Gomez Camacho 
 * @author Steven Nikolai Bermudez Vega
 * @version 13/02/2019
 */
public class Angulo {

    /** Constantes para indicar que el argumento está en radianes */
    public static final int RADIANES = 0;
    /** Constantes para indicar que el argumento está en grados */
    public static final int GRADOS = 1;
    /** Constantes para indicar que el argumento está en gradianes */
    public static final int GRADIANES = 2;
    

    /** Constante para maximo error admitido al comparar dos angulos.  
     *  Recuerde que los cálculos en el computador con variables de plunto flotante
     *  tienen una precisión limitada, y se requiere un margen de tolerancia
     */
    public static final double MAXERROR = 0.00000000000001;

    private double grados;
    /** Crea un angulo a partir del valor dado en grados o en radianes
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public Angulo (double valor, int tipo)
    {
        if (tipo==0)
        {
            grados= valor*(180/Math.PI);
        }
        else if(tipo==2)
        {
            grados= valor*(180/200);
        }
        else
        {
            grados=valor;
        }
    }
    
    /**Valor del angulo en grados
     * @return el valor del angulo en grados, 0 <= result < 360
     */
    public double grados ()
    {
        double tempo=grados;
        if (grados<0)
            tempo=Math.abs(grados+360)%360;
        else if (grados%360==0)
            tempo=0.0;
        return tempo;
    }
    
    /**Valor del angulo en radianes
     * @return el valor del angulo en radianes, 0 <= result < 2*PI
     */
    public double radianes () 
    {
        double tempo=grados;
        if (grados<0)
            tempo=Math.abs(grados+360)%360;
        else if (grados%360==0)
            tempo=0.0;
        tempo=tempo*(Math.PI/180);
        return tempo;
    }
    
    
    /**
     * Suma este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this + a
     */
    public Angulo sume (Angulo ang) {
        return new Angulo(this.grados + ang.grados,1);
    }

    /**
     * Resta este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this - a
     */
    public Angulo reste (Angulo a) {
        return new Angulo(this.grados - a.grados,1);
    }

    /**
     * Multiplica este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a multiplicar
     * @return this * a
     */
    
    public Angulo multiplique (Angulo ang) {
        return new Angulo(this.grados*ang.grados,1);
    }

    /**
     * Divide este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a dividir
     * @return this / a
     */
    public Angulo divida (Angulo a) {
        Angulo tempo ;
        if(a.grados == 0)
        {
            tempo= a;
        }else{
        tempo = new Angulo(this.grados/a.grados,1);
        }
        return tempo;
    }
    
       
    /**
     * Multiplica esta angulo por un real
     * @param r real para hacer el producto 
     * @return r * this
     */
    public Angulo multiplique (double r) {
      return new Angulo(this.grados*r,1);
    }
    
    /**
     * Compara a este angulo con otro, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param a angulo para compararse
     * @return |this - a| < MAXERROR
     */
    public boolean equals (Angulo a) 
    {
        boolean ok=false;
        if(this.grados%360==0 && a.grados%360==0)
            ok=true;

        else
            ok = Math.abs(this.grados - a.grados)< MAXERROR;
        return ok;
    }
    
    /**
     * Compara este angulo con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param 0  Object a comparar con este
     * @return valor booleano
     */
    public boolean equals (Object o) {
        Angulo a = (Angulo) o;
        return equals (a) ;
    }

    /**Calcula el seno
     * @return el seno de este angulo
     */
    public double seno () {
      return Math.sin(this.grados*(Math.PI/180));
    }

    /**Calcula el coseno
     * @return el coseno de este angulo
     */
    public double coseno () {
      return Math.cos(this.grados*(Math.PI/180));
    }

    /**
     * Retorna el valor del angulo en grados
     * @return la informacion del objeto.
     */
    
    public String toString() {
      return String.valueOf(this.grados);
    }
 
}
