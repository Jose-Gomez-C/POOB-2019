package Aplicacion;

import java.awt.Rectangle;
/**
 * 
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual se encarga de crea un bloque azul.
 */
public class Azul extends Bloque {
	@SuppressWarnings("deprecation")
	public Azul(int x, int y) {
		super(x, y);
		imagen="BloqueAzul.png";
		puntaje= 300;
		tienePoder=true;
	}
	public void romperBloque() {
		super.romperBloque();
		crearPoder=true;
	}
}
