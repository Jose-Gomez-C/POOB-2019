package Aplicacion;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
/**
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual crea los niveles. 
 */
public class Nivel {
	private ArrayList<ArrayList<Bloque>> bloques;
	private Hashtable<Bloque, Poder>poderes;
	private ArrayList<Poder> podereslist;
	private int [] [] nivel;
	int posx;
	int posy;
	/**
	 * @deprecated crea un nivel segun el numero que llega.
	 * @param nivel El nivel escogido para crear.
	 */
	public Nivel(int nivel) {
		podereslist= new ArrayList<Poder>();
		bloques = new ArrayList<ArrayList<Bloque>>();
		poderes= new Hashtable<Bloque,Poder>();
		if (nivel==1)nivelUno();
		else if(nivel==2)nivelDos();
		else if(nivel==3)nivelTres();
		else if(nivel==4)nivelCuatro();
		else if(nivel==5)nivelCinco();
		else if (nivel==100)nivelPrueba();
		else if(nivel ==101)nivelPrueba01();
		else if (nivel==102)nivelPrueba02();
		else if (nivel==103)nivelPrueba03();
		else if (nivel==104)nivelPrueba04();
		else if (nivel==105)nivelPrueba05();
		else nivelAleatorio();
	}
	/**
	 * @deprecated crea el nivel uno.
	 */
	private void nivelUno() {
		nivel= new int[][] {{0,0,0,1,1,0,0,0},{0,0,1,8,8,1,0,0},{0,0,1,8,1,1,0,0},{0,0,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0},{0,0,1,1,1,1,0,0},{0,2,2,1,1,1,3,0},{2,8,8,1,1,8,8,3},
			{2,8,2,2,3,8,3,3},{2,2,2,2,3,3,3,3},{2,2,2,2,3,3,3,3},{2,2,2,2,3,3,3,3},
			{2,2,2,2,3,3,3,3},{0,2,2,0,0,3,3,0}};
		crearNivel();
	}
	/**
	 * @deprecated crea el nivel dos.
	 */
	private void nivelDos() {
		nivel=new int[][] {{0,0,8,2,8,0,0},{0,8,0,0,0,8,0},{8,0,0,0,0,0,8},{8,0,0,1,0,0,8},
			{8,0,3,3,3,0,8},{8,0,0,1,0,0,8},{8,0,0,0,0,0,8},{0,8,0,0,0,8,0},{0,0,8,8,8,0,0}};
		crearNivel();
	}
	/**
	 * @deprecated crea el nivel tres.
	 */
	private void nivelTres() {
		nivel= new int[][] {{0,0,3,0,0,3,0,0},{0,0,0,3,3,0,0,0},{0,0,0,3,3,0,0,0},{0,0,2,2,2,2,0,0},{0,0,2,1,1,2,0,0},
			{0,2,2,1,1,2,2,0},{0,2,2,2,2,2,2,0},{2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2},
			{2,0,2,0,0,2,0,2},{2,0,2,0,0,2,0,2},{2,0,2,0,0,2,0,2},{0,0,0,2,2,0,0,0},
			{0,0,0,2,2,0,0,0}};
		crearNivel();
	}
	/**
	 * @deprecated crea el nivel cuatro.
	 */
	private void nivelCuatro() {
		nivel= new int[][] {{0,0,0,1,1,0,0,0},{0,0,2,1,1,2,0,0},{0,2,2,8,8,2,2,0},{2,2,2,8,8,2,2,2},{2,2,8,8,8,8,2,2},
			{2,2,8,8,8,8,2,2},{3,0,3,1,1,3,0,3},{0,0,0,1,1,0,0,0},{0,1,0,1,1,0,0,0},
			{0,1,0,1,1,0,0,0},{0,1,1,1,1,0,0,0},{0,0,1,0,0,0,0,0}};
		crearNivel();
	}
	/**
	 * @deprecated crea el nivel cinco.
	 */
	private void nivelCinco() {
		
		nivel= new int[][] {{0,0,0,0,2,2,2,0},{0,0,0,0,2,2,3,0},{0,0,0,2,2,3,3,3},{0,0,0,2,2,3,3,2}
		    ,{0,0,0,2,2,2,2,2},{0,0,8,2,2,2,2,2},{0,0,1,2,2,2,2,2},{0,0,1,2,2,2,2,2}
		    ,{0,8,1,1,2,2,2,0},{0,1,1,1,2,2,2,0},{0,1,1,1,1,0,0,0},{0,8,1,8,0,0,0,0}
		    ,{0,1,1,1,0,0,0,0},{1,1,1,0,0,0,0,0},{1,1,0,0,0,0,0,0}};
		crearNivel();
	}
	/**
	 * @deprecated crea el nivel aleatorio.
	 */
	private void nivelAleatorio() {
		int[] aleatorio = new int[] {1,1,1,1,1,1,1,2,2,2,2,2,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,8,8,8,8,8,8,8,8};
		Random r = new Random();
		//r.nextInt(38)
		nivel= new int[15][8];
		for (int y=0;y<15;++y) {
			for (int x= 0;x<8;++x) {
				nivel[y][x]=aleatorio[r.nextInt(38)];	
			}
		}
		crearNivel();
	}
	private void nivelPrueba() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1}};
		crearNivel();
	}
	private void nivelPrueba01() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
		    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{2,2,2,2,2,2,2,2}};
		crearNivel();
	}
	private void nivelPrueba02() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{8,8,8,8,8,8,8,8}};
	    crearNivel();
	}
	private void nivelPrueba03() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{3,3,3,3,3,3,3,3}};
	    crearNivel();
	}
	private void nivelPrueba04() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{1,2,3,8,0,0,0,0}};
	    crearNivel();
	}
	private void nivelPrueba05() {
		nivel= new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{3,3,3,3,3,3,3,3}};
	    crearNivel();
	}
	/**
	 * @deprecated crea los bloques y los poderes respectivos del nivel.
	 */
	private void crearNivel() {
		Random r = new Random();
		ArrayList<Bloque> fila;
		posx=45;
		posy=79;
		Bloque temporal;
		Poder poderTempo;
		for(int y = 0 ; y <nivel.length ; ++y) {
			fila=new ArrayList<Bloque>();
			for(int x=0;x<nivel[y].length;++x) {
				if (nivel[y][x]==1){
					temporal=new Bloque(posx+(54*x)+2,posy+(15*y)+2);
					fila.add(temporal);
				}else if(nivel[y][x]==2){
					temporal= new Bloque("verde", posx+(54*x)+2,posy+(15*y)+2);
					fila.add(temporal.getTemporal());
				}else if(nivel[y][x]==3){
					temporal= new Bloque("azul", posx+(54*x)+2,posy+(15*y)+2);
					fila.add(temporal.getTemporal());
					//r.nextInt(4)+1
					poderTempo= new Poder(temporal.getTemporal().getPosicionx(), temporal.getTemporal().getPosiciony(),r.nextInt(3)+1);
					poderes.put(temporal.getTemporal(), poderTempo.getPoder());
					podereslist.add(poderTempo.getPoder());
				}else if (nivel[y][x]==8) {
					temporal= new Bloque("gris", posx+(54*x)+2,posy+(15*y)+2);
					fila.add(temporal.getTemporal());
				}else {
					temporal=new Invisible(posx+(54*x)+2,posy+(15*y)+1);
					fila.add(temporal);
				}
			}
			bloques.add(fila);
		}
	}
	public ArrayList<ArrayList<Bloque>> getBolques(){
		return bloques;
	}
	public Hashtable<Bloque, Poder> getPoderes(){
		return poderes;
	}
	public ArrayList<Poder> getPodereslist(){
		return podereslist;
	}

}
