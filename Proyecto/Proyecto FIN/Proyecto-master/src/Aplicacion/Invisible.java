package Aplicacion;

import java.awt.Rectangle;

public class Invisible extends Bloque {
	public Invisible(int x, int y){
		super(x,y);
		imagen="";
		estaVivo=false;
	}
	
	public Rectangle getForma() {
		return new Rectangle(posicionX,posicionY,0,0);
	}
	
}
