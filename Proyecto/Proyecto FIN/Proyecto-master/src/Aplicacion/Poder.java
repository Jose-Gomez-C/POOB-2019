package Aplicacion;

import java.awt.Rectangle;
/**
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual se encarga de contorlar los poderes.
 */
public class Poder extends Figura{
	private Poder poder;
	protected Rectangle hitBox;
	protected boolean moverPoder;
	/**
	 * @deprecated metodo que crea un bloque.
	 * @param posx la posicion en x del poder.
	 * @param posy la posicion en y del poder.
	 */
	public Poder(int posx, int posy) {
		posicionX= posx;
		posicionY= posy;
		alto=15;
		ancho=54;
		imagen="";
		hitBox = new Rectangle(posicionX, posicionY, ancho, alto);
		moverPoder=false;
	}
	/**
	 * @deprecated crea los distintos poderes.
	 * @param posx posicion en x del poder.
	 * @param posy posicion en y del poder.
	 * @param tipoPoder el podere que desea crear.
	 */
	public Poder(int posx, int posy,int tipoPoder) {
		if(tipoPoder==1)poder= new BasePequena(posx, posy);
		else if (tipoPoder==2)poder= new BaseGrande(posx, posy);
		else if (tipoPoder==3)poder= new BolaRapida(posx, posy);
	}
	/**
	 * @deprecated metodo que quita la hitbox y su imagen del bloque.
	 */
	public void romperPoder() {
		imagen="";
		moverPoder=false;
	}
	/**
	 * @deprecated metodo que da el poder al al jugador.
	 * @param bola bola al cual se le va a aplicar el poder.
	 * @param base base al cual se le va a aplicar el poder.
	 */
	protected void habilidad(Bola bola, Base base) {
		moverPoder=false;
		imagen="";
	}
	public Poder getPoder() {
		return poder;
	}
	/**
	 * @deprecated metodo que cambia la posicion del bloque en vertical.
	 */
	public void moverPoder() {
		setPosition(posicionX, posicionY+1);
	} 
	
	public boolean getmoverPoder() {
		return moverPoder;
	}
	/**
	 * @deprecated metodo que sabe si toco la base.
	 * @param base la cual quiere intersectar.
	 * @return si el poder toco el la base 
	 */
	public boolean tocoBase(Base base) {
		return hitBox.intersects(base.getForma());
	}
	/**
	 * @deprecated metodo que sabe si toco el fondo.
	 * @param fondo rectangulo el cual es la parte final del juego. 
	 * @return si el poder toco el el fondo 
	 */
	public boolean tocoFondo(Rectangle fondo) {
		return hitBox.intersects(fondo);
	}
	public void setMoverpoder(Boolean estado) {
		moverPoder=estado;
	}
	public void setPosition(int newPositionx, int newPositiony){
		super.setPosition(newPositionx, newPositiony);
		hitBox.setLocation(newPositionx, newPositiony);
	}
}
