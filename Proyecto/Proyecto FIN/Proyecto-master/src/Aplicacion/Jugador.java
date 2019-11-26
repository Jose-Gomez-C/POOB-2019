package Aplicacion;

public abstract class Jugador {

	protected int puntos;
	protected int vidas;

	
	public int getPuntos() {
		return puntos;
	}
	
	public int getVidas() {
		return vidas;
	}
	/**
	 * @deprecated metodo que se encarga de mover la base dirigida por la maquina
	 */
	public void mover() {	
	}
	/**
	 * @deprecated metodo que se encarga de sumar los puntos de la base
	 */
	public void sumarPuntos(int puntosAdquiridos) {
		puntos += puntosAdquiridos;
	}
	/**
	 * @deprecated metodo que se encarga de sumar las vidas de la base
	 */
	public void sumarVidas(int vidasAdquiridas) {
		vidas += vidasAdquiridas;
		
	}
}
