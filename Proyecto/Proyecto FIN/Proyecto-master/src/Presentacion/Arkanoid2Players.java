package Presentacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Aplicacion.*;

public class Arkanoid2Players extends ArkanoidGUI {
	private JLabel barra2Player;
	private JLabel barra1Player;
	
	private int modoJuego;
	
	public Arkanoid2Players(int etapa, String imagenBola, String imagenBarra2, String imagenBarra, String modalidad) {
		super(etapa, imagenBola, imagenBarra, imagenBarra2,modalidad);
		modoJuego=etapa;
		
	}
	protected void prepareElementos() {
		Base base2 = tablero.creaBase2();
		barra2Player = new JLabel("");
		barra2Player.setIcon(new ImageIcon("src/Recursos/"+tablero.getImagen(base2)+".gif"));
		barra2Player.setBounds(tablero.getPosicionx(base2)+60, tablero.getPosiciony(base2), 109, tablero.getAlto(base2));
		getContentPane().add(barra2Player);
		super.prepareElementos();
		Base base = tablero.getBase();
		barra.setBounds(tablero.getPosicionx(base)-140, tablero.getPosiciony(base), 109, tablero.getAlto(base));
	}
	
	protected void prepareAcciones() {
		super.prepareAcciones();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
		        if(e.getKeyCode() == KeyEvent.VK_LEFT){
	                moverIzquierdaBase2();
		        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
		        	moverDerechaBase2();
		        }
			}
		});
		
	}
	protected void revalidarBase2() {
		 Base base2= tablero.getBase2();
		 if(modoJuego==2)barra2Player.setLocation(tablero.getPosicionx(base2), tablero.getPosiciony(base2));
	}
	private void moverIzquierdaBase2(){
    	
    	Base base=tablero.getBase2();
    	tablero.moverBase2Izquierda();
    	barra2Player.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    }
	private void moverDerechaBase2() {
    	Base base=tablero.getBase2();
    	tablero.moverBase2Derecha();
    	barra2Player.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    }
	 protected void moverPoder() {
		 Base base =tablero.getBase2();
		 super.moverPoder();
		 barra2Player.setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+tablero.getImagen(base)+".gif")));
	 }
	

}
