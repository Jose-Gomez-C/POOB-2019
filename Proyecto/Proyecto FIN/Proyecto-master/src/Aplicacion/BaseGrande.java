package Aplicacion;

public class BaseGrande extends Poder {
	public BaseGrande(int posx, int posy) {
		super(posx, posy);
		imagen="PoderApliarBase.gif";
	}
	
	/**
	 * @deprecated genera el poder en la base.
	 */
	public void  habilidad(Bola bola, Base base) {
		super.habilidad(bola, base);
		base.BaseGrande();
	}
}
