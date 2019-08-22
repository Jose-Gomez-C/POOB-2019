package Aplicacion;

public class BolaRapida extends Poder {

	public BolaRapida(int posx, int posy) {
		super(posx, posy);
		imagen="poderFast.png";
	}
	public void  habilidad(Bola bola, Base base) {
		super.habilidad(bola, base);
		bola.bolaVelocidadRapida();
	}
}
