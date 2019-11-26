package Aplicacion;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual se encarga de controlar la base. 
 */
public class Base extends Figura{
	private Rectangle plataforma;
	private String nombreOrignial;
	/**
	 * @deprecated metodo que que se encarga de crear una base
	 * @param posx posicion en x la cual va estar la base.
	 * @param posy posicion en y la cual va estar la base.
	 * @param tipoBarra la imagen que va a tener la barra.
	 */
	public Base(int posx, int posy, String tipoBarra) {
		
		posicionX=posx;
		posicionY=posy;
		ancho=89;
		alto=14;
		imagen=tipoBarra.substring(0, tipoBarra.length()-4);;
		cambio=20;
		
		nombreOrignial=tipoBarra.substring(0, tipoBarra.length()-4);
		plataforma = new Rectangle(posicionX, posicionY, ancho, alto);
		
	}
	public Rectangle getForma() {
		return plataforma;
	}
	public void setPosition(int newPositionx, int newPositiony) {
		super.setPosition(newPositionx, newPositiony);
		plataforma.setLocation(newPositionx, newPositiony);
	}
	/**
	 * @deprecated metodo el cual cambia el estado de la barra a una barra pequeña.
	 */
	public void basePequena() {
		if(imagen.equals(nombreOrignial)) {
			imagen=nombreOrignial+"pequena";
			plataforma.setBounds(posicionX, posicionY, ancho-20, alto);
			ancho=ancho-20;
		}else if(imagen.equals(nombreOrignial+"Grande")) {
			imagen=nombreOrignial+"pequena";
			plataforma.setBounds(posicionX, posicionY, ancho-40, alto);
			ancho=ancho-40;
		}
		
	}
	/**
	 * @deprecated metodo el cual cambia el estado de la barra a una barra grande.
	 */
	public void BaseGrande() {
		if(imagen.equals(nombreOrignial)) {
			imagen=nombreOrignial+"Grande";
			plataforma.setBounds(posicionX, posicionY, ancho+20, alto);
			ancho=ancho+20;
		}else if(imagen.equals(nombreOrignial+"pequena")) {
			imagen=nombreOrignial+"Grande";
			plataforma.setBounds(posicionX, posicionY, ancho+40, alto);
			ancho=ancho+40;
		}
	}
	/**
	 * @deprecated metodo el cual cambia el estado de la barra a una normal.
	 */
	public void BaseNormal() {
		if (imagen.equals(nombreOrignial+"Grande")) {
			imagen=nombreOrignial;
			plataforma.setBounds(posicionX, posicionY, ancho-20, alto);
			ancho=ancho-20;
		}else if(imagen.equals(nombreOrignial+"Pequena")){
			imagen=nombreOrignial;
			plataforma.setBounds(posicionX, posicionY, ancho+20, alto);
			ancho=ancho+20;
		}
		
	}
	/**
	 * @deprecated metodo el sabe si toco una bola.
	 * @param bola la blola con la cual se esta jugando.
	 */
	public void tocoBola(Bola bola) {
		if(bola.getShape().intersects(plataforma)) {
			bola.setPosition(bola.getPosicionx(),  451);
			bola.setDy();
		}
	}


	
}
