package Aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import Presentacion.Sound;

/**
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual controla la bola.
 */
public class Bola extends Figura {
	
	private int dx = 1;
	private int dy = 1;
	private Ellipse2D bola;
	/**
	 * @deprecated crea una bola.
	 * @param posx posicion en x de la bola.
	 * @param posy posicion en y de la bola.
	 */
	public Bola(int posx , int posy) {
		this.posicionX=posx;
		posicionY=posy;
		alto=18;
		ancho=20;
		cambio=10;
		bola = new Ellipse2D.Double((double) posicionX, (double) posicionY, 18, 18);
		imagen="Bola_Normal.PNG";
	}
	/**
	 * @deprecated metodo que se encarga de saber como la bola se debe mover. 
	 */
	public void jugar() {
		posicionX += dx;
		posicionY -= dy;
		
		if (posicionX <30 ) {
			posicionX = 50;
			dx = -dx;
		}
		if (posicionX + ancho > 489) {
			posicionX = 489 - ancho;
			dx = -dx;
		}
		if (posicionY < 20) {
			posicionY = 20;
			dy = -dy;
		}
		if (posicionY > 500) {
			posicionY = 500;
			dy = -dy;
		}

		bola.setFrame(posicionX, posicionY, ancho, alto);
		
	}
	/**
	 * @deprecated metodo que se encarga de saber si choco con un bloque.
	 * @param indicacion lugar de movimiento de la bola.
	 * @param newPos nueva posicion del la bola.
	 */
	public void chocoConBloque(String indicacion, int newPos) {
		if(indicacion=="Arriba" ) {
			posicionY=newPos;
			dy = -dy;
		}else if(indicacion == "Abajo"){
			posicionY=newPos;
			dy = -dy;
		}else if(indicacion == "Derecha") {
			posicionX=newPos;
			dx = -dx;
		}else if (indicacion == "Izquierda"){
			posicionX= newPos; 
			dx = -dx;
		}
	}
	public Ellipse2D getShape() {
		return bola;
	}
	public boolean tocoBloque(Bloque bloque) {
		return bola.intersects(bloque.getForma());
	}
	public boolean puntoToco(Rectangle punto) {
		return bola.intersects(punto);
	}

	public void setDy() {
		dy = -dy;
	}
	public void bolaVelocidadRapida() {
		System.out.println(dx);
		System.out.println(dy);
		if((dx==1 && dy==1)||(dx==-1 && dy==-1)||(dx==-1 && dy==1)||(dx==1 && dy==-1)) {
			dx=dx*(Math.abs(dy)+1);
			dy=dy*(Math.abs(dy)+1);
		}
	}
	public void bolaVelocidadNormal() {
		dx=1;
		dy=1;
	}  
	public int getDx() {
		return dx;
	}
	public int getDy() {
		return dy;
	}
}
