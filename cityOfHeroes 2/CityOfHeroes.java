import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.lang.Math;
/**
 * .
 *
 * @authors jose Luis Gomez C, Nikolai Bermudez
 * Esta clase permite crear edificios y heroes.
 * 
 */
public class CityOfHeroes
{
    private int ancho;
    private int c;
    private int[] ejex;
    private int[] aux;
    private int altura, anchura;
    
    private ArrayList<Integer> posx;
    private ArrayList<String> colores;
    private Canvas canvas;


    private Hashtable<Integer, Edificio> Edificios;
    private Hashtable<String,Heroe> Heroes;
    
    private Rectangle calle;
    private Rectangle city;
    private Circle sol;
    
    private boolean visible=false;
    private boolean fin;
    
    /**j
     * Constructor de objetos de la clase CityOfHeroes el cual pide una altura 
     * y ancho de la ciudad. 
     */
    public CityOfHeroes(int width,int height)
    {
        ejex = new int[width];
        aux = new int[width];
        altura = height;
        anchura = width;
        
        canvas = Canvas.getCanvas();
        
        city = new Rectangle();
        city.changeSize(height,width);
        city.changeColor("cyan");
        city.makeVisible();
        city.setCambiarxy(0,0);
        
        calle= new Rectangle();
        calle.changeSize(40,width);
        calle.moveHorizontal(-70);
        calle.moveVertical(height-55);
        calle.changeColor("gray");
        
        sol = new Circle();
        sol.changeColor("yellow");
        
        c=0;
        posx= new ArrayList<Integer>();
        colores= new ArrayList<String>();
        Edificios =new Hashtable<Integer, Edificio>();
        Heroes = new Hashtable<String,Heroe>();
        fin=true;
    }
    public void undo(){
     
    
    }
    public void redo(){
    
    }
    /**
     * Metodo que añade un edificios, con las caracteristicas que el usuario nos de como:
     * posicion, anchura, altura y dureza; todos de tipo entero.
     */
    public void addBuilding(int x, int width, int height,int hardness)
    {  
        boolean ok = true;
        for(int i=x;i<=x+width;++i){
            if (ejex[i] !=0)
                ok=false;
        }
        if (width<0 || height<0 || height>altura-150 || width>anchura)
              ok=false;
        if (ok)
        {
           if (c>7){
               c = 0;
           }
           Edificio edificio;
           for (int i=x;i<x+width;++i){
                ejex[i]= height;
                aux[i] = x;
             }
           Edificios.put(x,edificio= new Edificio(x,width,height,altura,anchura,hardness,c));
           if(visible){
               edificio.makeVisible();
            }
           posx.add(x);
           Collections.sort(posx);
           c+=1;
        }
        else
        {
            fin=false;
        }
    }
    /**
     * Metodo que añade un heroe, con respecto a las caracteristicas que nos envie el usuario como:
     * color de tipo String
     * edificio donde el heroe inicia su aventura y su fuerza, de tipo entero.
     */
    public void addHeroe(String color, int hidingBuilding, int strength)
    {
       boolean ok= posx.size()>hidingBuilding-1 && posx.size()!=0 ;
       if (ok){
           Heroe heroe;
           int x = posx.get(hidingBuilding-1);
           int y = altura-45-Edificios.get(x).getAlto();
           colores.add(color);
           heroe = new Heroe(color,x,y,strength,Edificios.get(x).getAncho());
           if(visible){
               heroe.makeVisible();
            }
           Heroes.put(color,heroe);
           Edificios.get(x).setVisitante(heroe);
        }
        else{
        fin=false;
        }  
    }
    /**
     * Metodo que elimina un edificio con respecto al orden visual del usuario
     */

    public void removeBuilding(int position){
        int x = posx.get(position);
        Edificios.get(x).makeInvisible();
        for (int i=x;i<x+Edificios.get(x).getAncho();++i){
                ejex[i]= 0;
        }
    }
    /**
     * Este metodo remueve un heroe, el que el usuario indique con su color respectivo.
     */
    public void removeHero(String color){
      boolean ok=false;
      for(String i:colores){
          if (i==color){
              ok=true;
              break;
            }
        }
      if (colores.size()>0 && ok){
          Heroes.get(color).makeInvisible();
          quitarVisitante(color,aux[Heroes.get(color).getxPosition()]);
       }
      else{
           fin=false;
        }
    }
    public void zoom(char z){
        if (z =='+' || z =='-'){
            canvas.acercar(z);
        }
       else{
            fin=false;
        }
    }
    /**
     * Este metodo genera el salto de un heroe, el usuario escoge cual heroe quiere que salte.
     */
    public void jump(String heroe, int velocity, int angle, boolean slow ){
      boolean ok=false;
      for(String i:colores){
          if (i==heroe){
              ok=true;
              break;
            }
        }
      if (colores.size()>0 && ok){
            Heroes.get(heroe).jump(velocity,angle,slow,calle.GetyPosition(),ejex,altura,ok,anchura);
            cortaredificio(heroe,aux[Heroes.get(heroe).getxPosition()]);
       }
    }
    public int[] jumpPlan(String heroe,int building){
        int[] fin = new int[2];
        int llave = posx.get(building-1);
        int llave2 = aux[Heroes.get(heroe).getxPosition()];
        int Xmax =  llave - Heroes.get(heroe).getxPosition();
        double angulo;
        double v0;
        double div;
        if (Edificios.get(llave2).getAlto() < Edificios.get(llave).getAlto()){
            int Ymax = Edificios.get(llave).getAlto()-Edificios.get(aux[Heroes.get(heroe).getxPosition()]).getAlto();
            div = (4*(double)(Ymax))/(2*(double)(Xmax));
            angulo= Math.atan(div);
            v0 = Math.sqrt((Ymax*2*(9.8))/Math.pow((Math.sin(angulo)),2));
        }else{
            int Ymax = Edificios.get(aux[Heroes.get(heroe).getxPosition()]).getAlto();
            div = (4*(double)(Ymax))/(2*(double)(Xmax));
            angulo = Math.atan(div);
            v0 = Math.sqrt((Xmax*(9.8))/(Math.sin(2*angulo)));
        }
        int cont=0;
        int angulos=(int)((angulo*180)/Math.PI);
        while(angulos>90){
            if (isSafejump(heroe,(int)(v0),angulos)){
                fin[0] =angulos ;
                fin[1] = (int)(v0);
                angulos=91;
            }else if(cont==0){
                int ymax=0;
                for(int i:posx){
                    ymax=Edificios.get(i).getAlto()>ymax?Edificios.get(i).getAlto():ymax;
                }
                ymax+=200;
                div=(4*(double)(ymax)/(2*(double)(Xmax)));
                angulo=Math.atan(div);
                v0=Math.sqrt((ymax*2*9.8)/Math.pow((Math.sin(angulo)),2));
                angulos=(int)((angulo*180)/Math.PI);
                cont+=1;
                System.out.println(angulos+"Angulo");
                System.out.println(v0+"Velocidad");
            }else{
                angulos+=1;
            }
        }
        return fin;
        }
    public boolean isSafejump(String heroe, int velocity, int angle){
        boolean fin=false;
        ArrayList<Integer> list;
        list=Heroes.get(heroe).simulasalto(velocity,angle,calle.GetyPosition(),ejex,altura,anchura);
        System.out.println(list.get(0)+"posy");
        System.out.println(calle.GetyPosition()-2+"Calle");
        if(calle.GetyPosition()-10>list.get(0)){
            if (list.get(0)-10<Edificios.get(aux[list.get(1)]).getyPosition()){
                fin=true;
             }
        }
        return fin;
    }
    public int strength(String color){
        return Heroes.get(color).getstrength();
    }
    public void makeVisible(){
        canvas.setVisible(true);
        calle.makeVisible();
        sol.makeVisible();
        for(int i:posx){
            Edificios.get(i).makeVisible();
          }
        for(String i:colores){
            Heroes.get(i).makeVisible();
          }
    }
    public void makeInvisible(){
        canvas.setVisible(true);
        calle.makeInvisible();
        sol.makeInvisible();
        for(int i:posx){
            Edificios.get(i).makeInvisible();
         }
        for(String i:colores){
            Heroes.get(i).makeInvisible();
         }
    }
    public boolean ok(){
        return fin;
    }
    private void cortaredificio(String color,int x){
        if (calle.GetyPosition()-10>Heroes.get(color).getyPosition()){
            if(Heroes.get(color).getyPosition()-10>Edificios.get(x).getyPosition()){
                Edificios.get(x).changeSize(altura-50-Heroes.get(color).getyPosition(),Edificios.get(x).getAncho());
                Edificios.get(x).changexy(x,Heroes.get(color).getyPosition()+10);
                newaltura(Edificios.get(x).getAlto(),x,Edificios.get(x).getAncho());
                Edificios.get(x).puerta();
                Heroes.get(color).changexy(x+(Edificios.get(x).getAncho()/2),Heroes.get(color).getyPosition());
                vida(x,color);
                pelea(x,color);
            //{else if (Heroes.get(color).getyPosition()
            }else{
                    System.out.println(Heroes.get(color).getyPosition());
                    Heroes.get(color).changexy(x+(Edificios.get(x).getAncho()/2),Edificios.get(x).getyPosition()-10);
                    pelea(x,color);
                }
        }else{
            removeHero(color);
        }
      }
    private void quitarVisitante(String color,int x){
        Edificios.get(x).setVisitante(null);
     }
    private void pelea(int x, String color){
        if (Edificios.get(x).getVisitante()!=null){
            if(Edificios.get(x).getVisitante().getstrength()>=Heroes.get(color).getstrength()){
                removeHero(color);
                Edificios.get(x).setVisitante(Heroes.get(color));
            }else{
                 removeHero(Edificios.get(x).getVisitante().getColor());
                 Edificios.get(x).setVisitante(Heroes.get(color));
              }
         }else{
            Edificios.get(x).setVisitante(Heroes.get(color));
         }
    }
    private void newaltura(int alto,int x,int width){
        for (int i=x;i<x+width;++i){
                ejex[i]= alto;
         }
    }
    private void vida(int x,String color){
        int vida = Heroes.get(color).getstrength();
        int daño = Edificios.get(x).gethardness();
        Heroes.get(color).changestrength(vida-daño);
    }
}