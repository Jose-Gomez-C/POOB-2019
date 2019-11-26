package Aplicacion;

import java.util.ArrayList;

public class JugadorCurioso extends Jugador {

	private Arkanoid game;
	public JugadorCurioso(int puntos , int vidas, Arkanoid game) {
		this.puntos = puntos;
		this.vidas = vidas;
		this.game = game;
	}
	
	public void mover() {
		int PoderesVisibles=0;
		
		ArrayList<Poder> poderes= game.getPoderesList();
		for(Poder i:poderes) {
			if(i.getmoverPoder()) {
				PoderesVisibles+=1;
			}
		}
		
			if(game.getBola().getPosicionx() < game.getBase2().getPosicionx() ) {
				game.moverBase2Izquierda();
			}else if (game.getBola().getPosicionx() > game.getBase2().getPosicionx()) {
				game.moverBase2Derecha();
			}
		
	}

}
