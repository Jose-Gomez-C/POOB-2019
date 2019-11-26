package Aplicacion;

public class BasePequena extends Poder{
	public BasePequena(int posx, int posy) {
		super(posx, posy);
		imagen="PoderReducirBase.gif";
	}
	public void  habilidad(Bola bola, Base base) {
		super.habilidad(bola, base);
		base.basePequena();
	}
}