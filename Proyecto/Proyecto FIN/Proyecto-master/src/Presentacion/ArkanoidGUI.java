package Presentacion;
import javax.swing.*;


import Aplicacion.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
/**
 * @author Nikolai Bermudes, Jose Luis Gomez.
 * @deprecated Clase la cual dibuja la capa de aplicaion. 
 */
public class ArkanoidGUI extends JFrame {
	private Hashtable<Bloque,JLabel> bloques;
	private Hashtable<Poder,JLabel>poderes;
	
	public Arkanoid tablero;
	
	private JLabel vida;
	private JLabel record;
	
	protected JLabel barra;
	private JLabel pokebola;
	private JLabel puntaje;
	
	protected int vidas;
	
	private boolean active;
	private boolean started;
	
	private String tipoDeBola;
	private String tipoDeBarra;
	private String tipoDeBarra2;
	private String tipo;
	
	private Boolean estaPausa;
	
	private JButton salir;
	private JButton guardar;
	private JButton continuar;
	private JButton importar;
	private JFrame pausa;
	private JLabel fondoJuego;
	
	/**
	 * Create un Jframe.
	 */
	public ArkanoidGUI(int etapa, String imagenBola, String imagenBarra, String imagenBarra2, String modalidad){
		tipo = modalidad;
		tipoDeBola = imagenBola;
		tipoDeBarra = imagenBarra;
		tipoDeBarra2 = imagenBarra2;
		crearTablero();
		setUndecorated(true);
		setBounds(100, 100, 732, 541);
		prepareElementos();
		prepareAcciones();
		getContentPane().setLayout(null);
		
		
		estaPausa=true;
		
		
		active = true;
		started = false;
	}
	/** 
	 * @deprecated crea un arkanoid.
	 */
	protected void crearTablero(){
		tablero=new Arkanoid(tipoDeBarra,tipoDeBarra2,tipo);
	}
	public void dispose() {
		super.dispose();
		active = false;
	}
	/**
	 * @deprecated genera visualmente los elementos del nivel.
	 */
	private void prepareNivel() {
		ArrayList<ArrayList<Bloque>> bloquesParaPintar;
		poderes= new Hashtable<Poder, JLabel>();
		bloques= new Hashtable<Bloque, JLabel>();
		bloquesParaPintar=tablero.CreaNivel();
		JLabel bloqueTemporal;
		for(int y=0; y<bloquesParaPintar.size();++y) {
			for (int x=0; x<bloquesParaPintar.get(y).size();++x) {
				bloqueTemporal= new JLabel("");
				bloquesParaPintar.get(y).get(x).getAlto();
				bloqueTemporal.setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+bloquesParaPintar.get(y).get(x).getImagen())));
				bloqueTemporal.setBounds(bloquesParaPintar.get(y).get(x).getPosicionx(), bloquesParaPintar.get(y).get(x).getPosiciony(), bloquesParaPintar.get(y).get(x).getAncho(), bloquesParaPintar.get(y).get(x).getAlto());
				getContentPane().add(bloqueTemporal);
				bloques.put(bloquesParaPintar.get(y).get(x),bloqueTemporal);
			}
		}
		creaPoder();
	}
	/**
	 * @deprecated limpia los elmentos del nivel.
	 */
	private void limpiarNivel() {
		Enumeration<Bloque> e = bloques.keys(); 
    	Bloque clave;
    	while( e.hasMoreElements() ){
    	     clave = (Bloque) e.nextElement();
    	     bloques.get(clave).setVisible(false);
    	     this.remove(bloques.get(clave));
    	}
    	Enumeration<Poder> i = poderes.keys(); 
    	Poder clavePoder;
    	while( i.hasMoreElements() ){
    	     clavePoder = (Poder) i.nextElement();
    	     poderes.get(clavePoder).setVisible(false);
    	     this.remove(poderes.get(clavePoder));
    	     
    	}
    	fondoJuego.setVisible(false);
    	this.remove(fondoJuego); 
	}
	/**
	 *@deprecated genera todos los elementos del juego.
	 */
	protected void prepareElementos() {
		
		Base base= tablero.creaBase();
		Bola bola= tablero.creaBola();
		vidas = tablero.getVidas();
		
		barra = new JLabel("");
		barra.setIcon(new ImageIcon("src/Recursos/"+tablero.getImagen(base)+".gif"));
		barra.setBounds(tablero.getPosicionx(base), tablero.getPosiciony(base), 109, tablero.getAlto(base));
		getContentPane().add(barra);
		
		pokebola = new JLabel("");
		pokebola.setBackground(Color.BLUE);
		pokebola.setIcon(new ImageIcon("src/Recursos/"+tipoDeBola));
		pokebola.setBounds(tablero.getPosicionx(bola),tablero.getPosiciony(bola), tablero.getAncho(bola),tablero.getAlto(bola));
		getContentPane().add(pokebola);
		
		prepareNivel();
		
		prepararFondoJuego();
		
		JPanel estadoDelJuego = new JPanel();
		estadoDelJuego.setBackground(Color.BLACK);
		estadoDelJuego.setBounds(512, 0, 220, 541);
		getContentPane().add(estadoDelJuego);
		estadoDelJuego.setLayout(null);
		
		JLabel etiquetaVida = new JLabel("VIDA");
		etiquetaVida.setBounds(72, 87, 62, 29);
		etiquetaVida.setForeground(Color.RED);
		etiquetaVida.setFont(new Font("Minecraft", Font.BOLD, 24));
		estadoDelJuego.add(etiquetaVida);
		
		vida = new JLabel(Integer.toString(tablero.getVidas()));
		vida.setBounds(96, 115, 14, 38);
		vida.setForeground(Color.WHITE);
		vida.setFont(new Font("Minecraft", Font.BOLD, 22));
		estadoDelJuego.add(vida);
		
		JLabel etiquetaPuntaje = new JLabel("PUNTAJE");
		etiquetaPuntaje.setFont(new Font("Minecraft", Font.BOLD, 24));
		etiquetaPuntaje.setForeground(Color.RED);
		etiquetaPuntaje.setBounds(46, 164, 125, 38);
		estadoDelJuego.add(etiquetaPuntaje);
		
		puntaje = new JLabel("<html><center>0</center></html>");
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Minecraft", Font.BOLD, 22));
		puntaje.setBounds(44, 200, 114, 21);
		estadoDelJuego.add(puntaje);
		
		JLabel etiquetaRecord = new JLabel("RECORD");
		etiquetaRecord.setFont(new Font("Minecraft", Font.BOLD, 21));
		etiquetaRecord.setForeground(Color.RED);
		etiquetaRecord.setBounds(54, 237, 106, 29);
		estadoDelJuego.add(etiquetaRecord);
		
		record = new JLabel(Integer.toString(tablero.getRecord()));
		record.setForeground(Color.WHITE);
		record.setFont(new Font("Minecraft", Font.BOLD, 22));
		record.setBounds(96, 277, 14, 21);
		estadoDelJuego.add(record);
		
		JLabel etiquetaNivel = new JLabel("NIVEL");
		etiquetaNivel.setForeground(Color.RED);
		etiquetaNivel.setFont(new Font("Minecraft", Font.BOLD, 22));
		etiquetaNivel.setBounds(72, 309, 79, 29);
		estadoDelJuego.add(etiquetaNivel);
		
		JLabel nivel = new JLabel("1");
		nivel.setForeground(Color.WHITE);
		nivel.setFont(new Font("Minecraft", Font.BOLD, 22));
		nivel.setBounds(96, 348, 14, 21);
		estadoDelJuego.add(nivel);
		
		JLabel Arkanoid = new JLabel("New label");
		Arkanoid.setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/Arkanoid.png")));
		Arkanoid.setBounds(10, 14, 200, 64);
		estadoDelJuego.add(Arkanoid);
		
		JLabel fondoEstado = new JLabel("");
		fondoEstado.setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/gifs galaxia.gif")));
		fondoEstado.setBounds(0, 0, 220, 584);
		estadoDelJuego.add(fondoEstado);
		fondoEstado.setForeground(Color.GREEN);
		
	}
	/**
	 * @deprecated genera todos los oyentes del juego.
	 */
	protected void prepareAcciones(){
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
		        if(e.getKeyCode() == KeyEvent.VK_A){
	                moverIzquierda();
		        }else if(e.getKeyCode() == KeyEvent.VK_D){
		        	moverDerecha();
		        }else if (e.getKeyCode()== KeyEvent.VK_P) {
		        	pausar();
		        }else if (e.getKeyCode()== KeyEvent.VK_SPACE && !started) {
		        	jugar();
		        	//started = true;
		        }
			}
		});
	}
	
	private void pausar() {
		 estaPausa=false;
		 crearPausa();
		 
	}
	/**
	 * @deprecated es el encargado de indicar cuado empezar a jugar y cuando parar.
	 */
    private void jugar() {
    	Bola bola= tablero.getBola();
    	Base base =tablero.getBase();
    	Thread d = new Thread() {
    		public void run() {
    			boolean NopasoNivel= true;
    			while(tablero.gameOver()&& tablero.PerdioVida()&&NopasoNivel && estaPausa){
    	    		tablero.moverBola();
    	    		pokebola.setLocation(tablero.getPosicionx(bola),tablero.getPosiciony(bola));
    	    		if (tipo.equals("vsCpu"))tablero.getMaquina().mover();
    	    		revalidar();
    	    		revalidarBase2();
    	    		if(tablero.pasoNivel()) {
    	    			NopasoNivel=false;
    	    			tablero.reiniciarBaseBola();
    	    			pokebola.setLocation(tablero.getPosicionx(bola), tablero.getPosiciony(bola));
    	        		barra.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    	        		limpiarNivel();
    	        		prepareNivel();
    	        		prepararFondoJuego();
    	    		}try{
						sleep(3);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
    	    	}
    		}
    	};
    	d.start();
    }
    private void prepararFondoJuego() {
    	fondoJuego= new JLabel("");
		fondoJuego.setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+tablero.getImagen())));
		fondoJuego.setBounds(0, 0, 514, 541);
		getContentPane().add(fondoJuego);
    }
    /**
     * @deprecated crea los elemntos visusales del los poderes.
     */
    public void creaPoder() {
    	Hashtable<Bloque, Poder>poderesParaPintar=tablero.getPoderes();
    	Enumeration<Bloque> e =poderesParaPintar.keys();
    	Bloque clave;
    	Poder poder;
    	JLabel tempoder;
    	while (e.hasMoreElements()) {
    		clave=(Bloque)e.nextElement();
    		poder= poderesParaPintar.get(clave);
    		tempoder= new JLabel("");
    		tempoder.setBounds(tablero.getPosicionx(poder),tablero.getPosiciony(poder),tablero.getAncho(poder),tablero.getAlto(poder));
    		getContentPane().add(tempoder);
    		poderes.put(poder, tempoder);
    	}
    }
    /**
     * @deprecated revalida todos los elemntos del tablero.
     */
    protected void revalidar() {
    	Base base =tablero.getBase();
    	moverPoder();
    	Enumeration<Bloque> e = bloques.keys(); 
    	Bloque clave;
    	while( e.hasMoreElements() ){
    	     clave = (Bloque) e.nextElement();
    	     bloques.get(clave).setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+tablero.getImagen(clave))));
    	     if(tablero.getSonar(clave)&& active) {
    	    	 Sound toque = new Sound("src/Recursos/"+tablero.getSonido(clave),1);
    	    	 toque.inicie();
    	    	 tablero.SetNoSonar(clave);
    	    	 revalidarPoder(clave);
    	     }
    	}
    	if(vidas != tablero.getVidas()) {
    		tablero.restablecerestadosBaseBola();
    		Bola bola= tablero.getBola();
    		vida.setText(Integer.toString(tablero.getVidas()));
    		pokebola.setLocation(tablero.getPosicionx(bola), tablero.getPosiciony(bola));
    		barra.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    		vidas = tablero.getVidas();
    	}
    	puntaje.setText(Integer.toString(tablero.getRecord()));
    }
    /**
     * @deprecated encarga de mover el poder visualmente.
     */
    protected void moverPoder() {
    	Base base =tablero.getBase();
    	tablero.moverPoder();
    	Enumeration<Poder> e = poderes.keys(); 
    	Poder clave;
    	while( e.hasMoreElements()){
    	     clave = (Poder) e.nextElement();
    	     poderes.get(clave).setLocation(tablero.getPosicionx(clave), tablero.getPosiciony(clave));
    	     poderes.get(clave).setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+tablero.getImagen(clave))));
    	}
    	barra.setIcon(new ImageIcon(("src/Recursos/"+tablero.getImagen(base)+".gif")));
    }
    /**
     * @deprecated actualiza la imagen del poder.
     * @param bloque
     */
    private void revalidarPoder(Bloque bloque) {
    	Hashtable<Bloque, Poder>poderesParaPintar=tablero.getPoderes();
    	if(tablero.getPoderVisible(bloque)) {
    		poderes.get(poderesParaPintar.get(bloque)).setIcon(new ImageIcon(ArkanoidGUI.class.getResource("/Recursos/"+tablero.getImagen(poderesParaPintar.get(bloque)))));
    		tablero.setPoderVisible(bloque, false);
    	}
    }
    /**
     * mueve la barra a la izquierda
     */
    private void moverIzquierda(){
    	Base base=tablero.getBase();
    	tablero.moverBaseIzquierda();
    	barra.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    }
    /**
     * mueve la barra a la derecha.    
     */
    private void moverDerecha() {
    	Base base=tablero.getBase();
    	tablero.moverBaseDerecha();
    	barra.setLocation(tablero.getPosicionx(base),tablero.getPosiciony(base));
    }
    /**
     * crea una pausa.
     */
	 private void crearPausa() {
    	pausa=new JFrame();
		pausa.setBounds(150, 150, 300, 300);
		pausa.getContentPane().setLayout(null);
		//pausa.setUndecorated(true);
		prepararElementospausa();
		prepareAccionespausa();
		pausa.setVisible(true);
	}
	public void prepararElementospausa() {
		
		salir = new JButton("Salir");
		salir.setBounds(100, 220, 117, 30);
		pausa.add(salir);
		
		importar= new JButton("ImportarNivel");
		importar.setBounds(100, 180, 120, 30);
		pausa.add(importar);
		
		guardar = new JButton("Guardar");
		guardar.setBounds(100, 140, 120, 30);
		pausa.add(guardar);
		
		continuar = new JButton("Continuar");
		continuar.setBounds(100, 100, 120, 30);
		pausa.add(continuar);
		
		JLabel fondoPausa = new JLabel("");
		fondoPausa.setIcon(new ImageIcon("src/Recursos/gifs galaxia.gif"));
		fondoPausa.setBounds(0, 0, 300, 300);
		pausa.add(fondoPausa);
	}
	public void prepareAccionespausa() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salve();
			}
		});
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				continuar();
				estaPausa=true;
			}
		});
		importar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importar();
			}
		});
	}
	private void continuar() {
		pausa.dispose();
	}
	private void importar() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(importar)== JFileChooser.APPROVE_OPTION) {
			File nombre = file.getSelectedFile();
		}
			
	}
	private void salve() {
		JFileChooser file= new JFileChooser();
		file.setSelectedFile(new File("save.txt")); 
		if(file.showOpenDialog(guardar)== JFileChooser.APPROVE_OPTION) {
			//JOptionPane.showMessageDialog(null, "Lo sentimos esta funcion no esta disponible ahora");
			File nombre = file.getSelectedFile();
			try {
			    ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombre.toString()));
			    salida.writeObject(this);
			    salida.close();  
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"NO se pudo guardar");
			}
		} 
	}
	protected void revalidarBase2() {
		
	}
	private void salir() {
	int sino= JOptionPane.showConfirmDialog(null, "Esta seguro de salir.");
		if (sino==0)System.exit(1);
	}
}