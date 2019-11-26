package Aplicacion;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;



/**
 * @author Nikolai Bermude
 * @author Jose Luis Gomez.
 * @deprecated Clase la cual controla toda la parte logica del juego 
 */
public class Arkanoid implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = (long) 1.0;
	private int posicionX;
	private int posicionY;
	private int alto;
	private int ancho;
	private String imagen;
	private String imagenBarra;
	private String imagenBarra2;
	private Bola bola;
	private Base base;
	private Nivel nivel;
	private ArrayList<ArrayList<Bloque>> bloques;
	private Rectangle rectanguloPerderVida;
	private int vida;
	private int record;
	private int vidas;
	private Base base2;
	private Hashtable<Bloque, Poder> poderes;
	private ArrayList<Poder> podereslist;
	private Arkanoid tablero;
	private Bloque bloqueAnterior;
	private int prueba;
	private String tipo;
	private Jugador maquina;
	
	/**
	 * @deprecated Metodo encargado de la construccion del tablero.
	 * @param tipoBarra La imagen que el usuario eligio para la barra
	 * @param tipoDeBarra2 La imagen que el usuario eligio para la barra 2
	 */
	public Arkanoid(String tipoBarra,String tipoDeBarra2, String modalidad){
		tablero = this;
		imagenBarra= tipoBarra;
		imagenBarra2 = tipoDeBarra2;
		tipo = modalidad;
		vida = 3;
		vidas=3;
		posicionX=0;
		posicionY=0;
		ancho=522;
		alto=541;
		record = 0;
		imagen="fondoJuego.png";
		rectanguloPerderVida = new Rectangle(24,486,471,36);
	}
	/**
	 * @deprecated Metodo encargado de la construccion del la bola.
	 * @return la bola creada. 
	 */
	public Bola creaBola() {
		bola=new Bola(245,451);
		return bola;
	}
	/**
	 * @deprecated Metodo encargado de saber si la bola esta tocando algun bloque del nivel.
	 */
	public void tocoBLoque() {
		boolean tocoBloque=true;
		for(int y =0; y<bloques.size()&&tocoBloque;++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bola.tocoBloque(bloques.get(y).get(x))) {
					if(bola.getPosicionx()+16<=bloques.get(y).get(x).getPosicionx())bola.chocoConBloque("Izquierda",bloques.get(y).get(x).getPosicionx()-20);
					else if(bola.getPosicionx()>=bloques.get(y).get(x).getPosicionx()+52)bola.chocoConBloque("Derecha",bloques.get(y).get(x).getPosicionx()+55);
					else if(bola.getPosiciony()<=bloques.get(y).get(x).getPosiciony()-16)bola.chocoConBloque("Arriba",bloques.get(y).get(x).getPosiciony()-19);
					else if(bola.getPosiciony()>=bloques.get(y).get(x).getPosiciony()+13)bola.chocoConBloque("Abajo",bloques.get(y).get(x).getPosiciony()+16);
					bloqueAnterior=bloques.get(y).get(x);
					bloques.get(y).get(x).romperBloque();
					puntaje(bloques.get(y).get(x));
					bloques.get(y).get(x).setSonar();
					tocoBloque=false;
				}
			}
		}
	}
	/**
	 * @deprecated Metodo encargado de mover el poder y saber si el poder toca la base o toca el fondo del juego.
	 */
	public void moverPoder() {
		for(Poder i:podereslist) {
			if(i.getmoverPoder()) { 
				i.moverPoder();
				if(i.tocoBase(base)) i.habilidad(bola, base);
				else if (base2!=null) {
					if (i.tocoBase(base2))i.habilidad(bola, base2);
				}
				else if (i.tocoFondo(rectanguloPerderVida)) i.romperPoder();
			}
		}
	}
	/**
	 * @deprecated Metodo encargado de saber si se debe pasar de nivel.
	 * @return Un valor booleano indicado si paso el nivel o no.
	 */
	public boolean pasoNivel() {
		int bloquesVivos=0;
		for(int y =0; y<bloques.size();++y) {
			for(int x=0; x<bloques.get(y).size();++x) {
				if(bloques.get(y).get(x).estaVivo)++bloquesVivos;
			}
		}

		return bloquesVivos==0;
	}
	/**
	 * @deprecated Metodo encargado de cambiar el estado de la base a su forma original.
	 */
	public void restablecerestadosBaseBola() {
		base.BaseNormal();
		bola.bolaVelocidadNormal();
		if(base2!= null)base2.BaseNormal();
	}
	/**
	 * @deprecated Metodo encargado de crear una base.
	 * @return retorna la base creada.
	 */
	public Base creaBase() {
		base= new Base(215,470,imagenBarra);
		return base;
	}
	/**
	 * @deprecated Metodo encargado de crear una base para el modo dos jugadores.
	 * @return retorna la base creada.
	 */
	public Base creaBase2() {
		if(tipo.equals("vsPlayer")) {
			base2 = new Base(300,470,imagenBarra2);
			
		}else if(tipo.equals("vsCpu")) {
			base2 = new Base(300,470,imagenBarra2);
			addMaquina("curioso");
		}
		return base2;
	}
	/**
	 * @deprecated Metodo encargado de anadir a la maquina y su tipo
	 */
	public void addMaquina(String tipoDeMaquina) {
		if(tipoDeMaquina.equals("curioso")) {
			maquina = new JugadorCurioso(0,3,this);
		}
		
	}
	/**
	 * @deprecated Metodo encargado en el movimiento de la base principal al lado izquierdo
	 */
	public void moverBaseIzquierda() {
    	int velocidad=base.getCambio();
    	if(base.getPosicionx()>=30) {
    		base.setPosition(base.getPosicionx()-velocidad, base.getPosiciony());
    		}
    }
	/**
	 * @deprecated Metodo encargado en el movimiento de la segunda base al lado izquierdo
	 */
	public void moverBase2Izquierda() {
    	int velocidad=base2.getCambio();
    	if(base2.getPosicionx()>=30) {
    		base2.setPosition(base2.getPosicionx()-velocidad, base2.getPosiciony());
    		}
    }
	/**
	 * @deprecated Metodo encargado en el movimiento de la base principal al lado derecho
	 */
	public void moverBaseDerecha() {
		int velocidad= base.getCambio();
		if(base.getPosicionx()<=400) {
			base.setPosition(base.getPosicionx()+velocidad, base.getPosiciony());
		}
	}
	/**
	 * @deprecated Metodo encargado en el movimiento de la segunda base al lado derecho
	 */
	public void moverBase2Derecha() {
		int velocidad= base2.getCambio();
		if(base2.getPosicionx()<=400) {
			base2.setPosition(base2.getPosicionx()+velocidad, base2.getPosiciony());
		}
	}
	/**
	 * @deprecated Metodo encargado de mover la bola saber si la bola toca la base o toco un bloque y si perdio vidas.
	 */
	public void moverBola() {
		bola.jugar();
		base.tocoBola(bola);
		if(base2!= null)base2.tocoBola(bola);
		tocoBLoque();
		reducirVida();
		
	}
	/**
	 * @deprecated Metodo encargado de saber si el jugador a perdido una vida.
	 */
	public void reducirVida() {
		if(bola.getShape().intersects(rectanguloPerderVida)) {
			vida -=1;
			reiniciarBaseBola();
		}
	}
	/**
	 * @deprecated Metodo encargado de colocar la base y la bola en su posicion inicial.
	 */
	public void reiniciarBaseBola() {
		if (bola!= null)bola.setPosition(245, 451);	
		if (base != null)base.setPosition(215, 470);
	}
	/**
	 * @deprecated Metodo encargado de informar si el jugadort perdio una vida.
	 * @return retorna si el usuario perdio una vida.
	 */
	public Boolean PerdioVida() {
		Boolean fin=true;
		if (vidas!=vida) {
			vidas=vida;
			fin=false;
		}else fin=true;
		return fin;
	}
	/**
	 * @deprecated Metodo encargado en limpiar cada lista de bloques y poderes para hacer un nuevo juego.
	 */
	public void pasarNivel() {
		reiniciarBaseBola();
		bloques.clear();
		poderes.clear();
		podereslist.clear();
	}
	/**
	 * @deprecated Metodo encargado de crear un nivel.
	 * @return El arraylist de bloques que son del nivel. 
	 */
	public ArrayList<ArrayList<Bloque>> CreaNivel() {
		Random r = new Random();
		//r.nextInt(6) + 1
		nivel= new Nivel(r.nextInt(6) + 1);
		bloques= nivel.getBolques();
		poderes=nivel.getPoderes();
		podereslist=nivel.getPodereslist();
		return bloques;	
	}
	/**
	 * @deprecated Metodo encargado de crear un nivel para las pruebas.
	 * @param numeroNivel numero del nivel que desea crear
	 * @return El arraylist de bloques que son del nivel. 
	 */
	public ArrayList<ArrayList<Bloque>> CreaNivel(int numeroNivel) {
		nivel= new Nivel(numeroNivel);
		bloques= nivel.getBolques();
		poderes=nivel.getPoderes();
		podereslist=nivel.getPodereslist();
		return bloques;
	}
	/**
	 * @deprecated Metodo encargado de acumular el puntaje del jugador.
	 * @param bloque bloque el cual se desea saber el nombre.
	 */
	public void puntaje(Bloque bloque) {
		record+=bloque.getPuntaje();
	}
	/**
	 * @deprecated Metodo encargado de saber si el jugador perdio una vida.
	 * @return un valor boolean indicando si perdio. 
	 */
	public Boolean gameOver() {
		return vida!=0;
	}
	/**
	 * @deprecated Metodo encargado de saber si el poder se debe mover.
	 * @param bloque El bloque que hacido tocado para saber si tiene poder o no.
	 * @return un booleano indicado si moverlo. 
	 */
	public boolean moverPoder(Bloque bloque) {
		boolean ok;
		if(!bloque.getTienePoder())ok=false;
		else ok=poderes.get(bloque).getmoverPoder();
		return ok;
	}
	public Bola getBola() {
		return bola;
	}
	public Base getBase() {
		return base;
	}
	public boolean getPoderVisible(Bloque bloque) {
		return bloque.getCrearPoder();
	}
	public void setPoderVisible(Bloque bloque,Boolean estado) {
		bloque.setCrearPoder(estado);
		poderes.get(bloque).setMoverpoder(!estado);
	}

    public Hashtable<Bloque, Poder> getPoderes(){
    	return poderes;
    }
	public  int getAlto() {
		return alto;
	}
	public ArrayList<Poder> getPoderesList(){
		return podereslist;
	}
	public  int getAncho() {
		return ancho;
	}
	
	public  int getPosicionx() {
		return posicionX;
	}
	
	public  int getPosiciony() {
		return posicionY;
	}
	
	public  String getImagen() {
		return imagen;
	}
	public int getVidas() {
		return vida;
	}
	public int getRecord() {
		return record;
	}
	public  int getAlto(Figura figura) {
		return figura.getAlto();
	}
	
	public  int getAncho(Figura figura) {
		return figura.getAncho();
	}
	
	public  int getPosicionx(Figura figura) {
		return figura.getPosicionx();
	}
	
	public  int getPosiciony(Figura figura) {
		return figura.getPosiciony();
	}
	
	public  String getImagen(Figura figura) {
		return figura.getImagen();
	}
	public int getCabio(Figura figura) {
		return figura.getCambio();
	}
	public void setPosition(Figura figura, int newx,int newy ) {
		figura.setPosition(newx, newy);
	}
	public String getSonido(Figura figura) {
		return figura.getSonido();
	}
	public Boolean getSonar(Figura figura) {
		return figura.getSonar();
	}
	public void SetNoSonar(Figura figura) {
		figura.SetNoSonar();
	}
	public Base getBase2() {
		return base2;
	}
	public Jugador getMaquina() {
		return maquina;
	}
	
	public void guardar(String nombreArchivo) throws ArkanoidException {
    	try {
    	ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
    	salida.writeObject(this);
    	salida.close();
    	}catch (Exception e) {
			throw new ArkanoidException(ArkanoidException.NO_GUARDO);
		}   
	}
	public void importar(String nombreArchivo) throws ArkanoidException {
		try {
		    BufferedReader archivo= new BufferedReader(new FileReader(nombreArchivo));
		    String linea=archivo.readLine();
		    String[] lista;
		    int[][] nivel= new int[15][8];
		    int numeroLinea=0;
		    while(linea != null) {
		    	linea=linea.trim();
		    	lista=linea.split(" ");
		    	for (int i =0;i>lista.length;++i) {
		    		if(lista[i]=="rojo")nivel[numeroLinea][i]=1;
		    		else if (lista[i]=="azul")nivel[numeroLinea][i]=3;
		    		else if (lista[i]=="verde")nivel[numeroLinea][i]=2;
		    		else if (lista[i]=="gris")nivel[numeroLinea][i]=2;
		    		else nivel[numeroLinea][i]=0;
		    	}
		    	linea=archivo.readLine();
		    	numeroLinea +=1;
		    	}
	    	}catch (IOException e) {
	    		throw new ArkanoidException(ArkanoidException.NO_ABRIO);
	    	}
	    }
	

	public Arkanoid demeTablero() {
		return tablero;
	}
}
