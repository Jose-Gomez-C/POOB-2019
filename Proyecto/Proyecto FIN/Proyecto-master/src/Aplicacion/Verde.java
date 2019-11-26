package Aplicacion;

public class Verde extends Bloque{
	private int resistencia;
	public Verde(int posx,int posy) {
		super(posx,posy);
		imagen="BloqueVerde.png";
		resistencia=1;
		puntaje=100;
	}
	
	public void romperBloque() {
		if (resistencia == 0) {
			super.romperBloque();
		}else {
			--resistencia;
			imagen="BloqueVerdeRoto.png";
		}
	}
}
