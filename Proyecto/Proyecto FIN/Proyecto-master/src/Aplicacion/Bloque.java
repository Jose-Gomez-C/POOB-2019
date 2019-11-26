package Aplicacion;

import java.awt.Rectangle;

public class Bloque extends Figura{
	/**
	 * @author Nikolai Bermudes, Jose Luis Gomez.
	 * @deprecated Clase controlar un bloque. 
	 */
	private Rectangle bloque;
	protected int puntaje;
	private Bloque temporal;
	private String sonido;
	private Boolean sonar;
	protected boolean crearPoder;
	protected boolean tienePoder;
	protected Boolean estaVivo;
	/**
	 * @deprecated metodo que crea un bloque.
	 * @param x posicion en x del bloque.
	 * @param y posicion en y del bloque.
	 */
	public Bloque(int x, int y){
		posicionX=x;
		posicionY=y;
		imagen="BloqueRojo.png";
		sonido="bloque rojo.wav";
		sonar=false;
		crearPoder=false;
		tienePoder=false;
		estaVivo=true;
		alto=15;
		ancho=54;
		puntaje = 100;
		bloque= new Rectangle(posicionX, posicionY, ancho, alto);
		
	}
	/**
	 * @deprecated metodo que crea un distintos bloques.
	 * @param x posicion en x del bloque.
	 * @param y posicion en y del bloque.
	 * @param tipo tipo de bloque que desea crear.
	 */
	public Bloque(String tipo,int x, int y){
		if (tipo == "invisible")temporal=new Invisible(x, y);
		else if (tipo == "verde")temporal=new Verde(x, y);
		else if (tipo == "gris")temporal=new Gris(x, y);
		else if (tipo == "azul")temporal=new Azul(x, y);
		else temporal= new Bloque(x,y);
	}
	/**
	 * @deprecated metodo encargado de romper un bloque.
	 */
	public void romperBloque() {
		imagen = "";
		bloque= new Rectangle(posicionX, posicionY, 0, 0);
		estaVivo=false;
	}
	public void setSonar() {
		sonar=true;
	} 
	public boolean getTienePoder() {
		return tienePoder;
	}
	public void SetNoSonar() {
		sonar=false;
	}
	public boolean getEstaVivo(){
		return estaVivo;
	}
	public Boolean getSonar() {
		return sonar;
	}
	public String getSonido() {
		return sonido;
	}
	public void setEstaVivo(boolean estado) {
		estaVivo=estado;
	}
	public Bloque getTemporal() {
		return temporal;
	}
	
	public Boolean getCrearPoder() {
		return crearPoder;
	}
	public void setCrearPoder(Boolean estado) {
		crearPoder=estado;
	}
	public Rectangle  getForma() {
		return bloque;
	}
	public int getPuntaje() {
		return puntaje;
		
	}
	
}