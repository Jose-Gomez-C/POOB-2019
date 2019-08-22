package Aplicacion;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public  class Figura {
	
	protected int posicionX;
	protected int posicionY;
	protected String imagen;
	protected int ancho;
	protected int alto;
	protected int cambio;

	public Figura() {
	}
	public  int getAlto() {
		return alto;
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
	public void setPosition(int newPositionx, int newPositiony){
		posicionX= newPositionx;
		posicionY= newPositiony;
	}
	public int getCambio() {
		return cambio;
	}
	public boolean puedeJugar(Figura plataforma) {
		return true;
	}
	public void jugar() {
		
	}
	
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(10,10,10,10);
	}
	
	public Rectangle getForma() {
		return new Rectangle();
	}
	public String getSonido() {
		return" ";
	}
	public Boolean getSonar() {
		return false;
	}
	public void SetNoSonar() {

	}
}
