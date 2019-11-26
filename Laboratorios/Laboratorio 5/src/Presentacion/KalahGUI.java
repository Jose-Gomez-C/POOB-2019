package Presentacion;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.net.URL;
import java.text.*;
import java.awt.Color;
import java.util.*;
import java.util.Random;
import Aplicacion.*;

public class KalahGUI extends JFrame{ 

	private JMenuBar menuBar;
	private JMenu menu,nuevo;
	private JMenuItem abrir,salvar,salvarComo,salir,normal,personalizar;
	private JPanel panelDelTitulo;
	private ImageIcon imagen;
	private JLabel titulo;
	private JPanel juego;
	private ArrayList<JButton> tablero;
	private JButton almacen1;
	private JButton almacen2;
	private JDialog cambiarJuego;
	private JTextField textoCasa;
	private JTextField textoSemillas;
	private JButton colorJugador1;
	private JButton colorJugador2;
	private Color color1;
	private Color color2;
	private JButton jugarPersonalizado;
	private Kalah games;
	private JButton reiniciar;
	private JLabel etiquetaDeJugadas;
	private int numeroCasas;
	private int numeroSemillas;
	
	private KalahGUI(){
		super();
		this.setLayout(new BorderLayout());
		prepareElementos();
		prepareAcciones();
	}
	
	private void jugar(int cualCasa){
		int[] estado = games.estado();
		/*
		double cualCasaDouble = cualCasa;
		
		if (!games.turnoMaquina()){
			int menor=(tablero.size()/2+1);
			int mayor=(tablero.size()-1);
			cualCasaDouble=(Math.random()*(mayor)+menor);
			cualCasa = (int)(cualCasaDouble);
			while(estado[cualCasa]==0 && games.termino()){
				cualCasaDouble =Math.random()*(mayor)+menor;
				cualCasa = (int)(cualCasaDouble);
			}
		}
		*/	
		if(cualCasa>tablero.size()/2){
			cualCasa=tablero.size()+tablero.size()/2-cualCasa;
		}
		try{
			games.juegue(cualCasa);
		}catch(KalahException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		estado = games.estado();
		for (int i=0;i<tablero.size();++i){
			if (i==0)tablero.get(i).setText(Integer.toString(estado[i]));
			if (i==tablero.size()/2)tablero.get(tablero.size()/2).setText(Integer.toString(estado[i]));
			if (i>tablero.size()/2){
				tablero.get(tablero.size()+tablero.size()/2-i).setText(Integer.toString(estado[i]));
			}else{
				tablero.get(i).setText(Integer.toString(estado[i]));
			}
		}
		etiquetaDeJugadas.setText("   Numero de Jugadas: "+games.getJugadoas());
		String ganador="";
		if(games.termino()){
			try{
			ganador=games.gano()?"Gano el jugador 1":"Gano la cpu";
			JOptionPane.showMessageDialog(null,ganador);
			}catch(KalahException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		
	}
	public void setTamano(int ancho,int alto){
		this.setSize(ancho,alto);
	}
	
	public void setLocalizacion(int x, int y){
		this.setLocation(x,y);
	}	
	private void makeVisible(){
		this.setVisible(true);
	}	
	private void salga(){
		int confirma= JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?");			
		if(confirma== 0) {
			System.exit(1);
		}
	}
	private void guardarComo(){
		JFileChooser file= new JFileChooser();
		file.setSelectedFile(new File("save.txt")); 
		if(file.showSaveDialog(salvar)==JFileChooser.APPROVE_OPTION)JOptionPane.showMessageDialog(this,"Lo sentimos esta funcion no esta disponible ahora");
	}
	private void open() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(abrir)== JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Lo sentimos esta funcion no esta disponible ahora");
		}
	}
	
	private void guardar(){
		JOptionPane.showMessageDialog(this,"Lo sentimos esta funcion no esta disponible ahora","Guardar",JOptionPane.OK_OPTION);
	}
	private void normal(){
		prepareElementosTablero(6 ,3,Color.red,Color.blue);
	}
	private void prepareElementosTablero(int casas,int semillas,Color colorJ1,Color colorJ2){
		this.getContentPane().removeAll();
		setLayout(new BorderLayout());
		games=new Kalah(casas,semillas);
		boolean insertarAlmacen=true;
		tablero= new ArrayList<JButton>();
		boolean equipo=true;
		prepareTitulo();
		juego= new JPanel();
		juego.setLayout(new GridLayout(2,casas));
		String semilla=Integer.toString(semillas);
		this.add(juego,BorderLayout.CENTER);
		JPanel panealmacen= new JPanel();
		panealmacen.setLayout(new GridLayout(1,1));
		almacen1=new JButton();
		almacen1.setBackground(colorJ1);
		almacen1.setText("<html>Almacen de la CPU<br><center>Semillas=0</center></html>");
		almacen1.setForeground(Color.WHITE);
		panealmacen.add(almacen1);
		JPanel panelalmacen2= new JPanel();
		panelalmacen2.setLayout(new GridLayout(1,1));
		almacen2= new JButton();
		almacen2.setText("<html>Almacen del Jugador <br><center>Semillas=0</center></html>");
		almacen2.setForeground(Color.WHITE);
		almacen2.setBackground(colorJ2);
		panelalmacen2.add(almacen2);
		this.add(panelalmacen2,BorderLayout.EAST);
		this.add(panealmacen,BorderLayout.WEST);
		tablero.add(almacen1);
		for(int i=0;i<casas*2;++i){
			JButton casa= new JButton(semilla);
			casa.setForeground(Color.WHITE);
			juego.add(casa);
			tablero.add(casa);
			if(i<casas-1){
				casa.setBackground(colorJ2);
			}else if(insertarAlmacen && i==casas-1){
				tablero.add(almacen2);
				casa.setBackground(colorJ2);
			}else{
				casa.setBackground(colorJ1);
			}
		}
		numeroCasas=casas;
		numeroSemillas=semillas;
		color1=colorJ1;
		color2=colorJ2;
		prepareAccionesBotones();
		refresque();
	}
	private void prepareTitulo(){
		panelDelTitulo= new JPanel();
		imagen= new ImageIcon("src/Recursos/kalah.png");
		titulo= new JLabel(imagen);
		panelDelTitulo.add(titulo);
		this.add(panelDelTitulo,BorderLayout.NORTH);
	}
	private void refresque(){
		this.revalidate();
	}
	private void personalizado(){
		cambiarJuego= new JDialog();
		cambiarJuego.setVisible(true);
		cambiarJuego.setSize(300,150);
		cambiarJuego.setLocation(700,450);
		cambiarJuego.setTitle("Personalizar");
		cambiarJuego.setLayout(new GridLayout(5,2));
		
		JLabel etiquetaDecasas= new JLabel("Numero de casas:");
		cambiarJuego.add(etiquetaDecasas);
		
		textoCasa= new JTextField();
		cambiarJuego.add(textoCasa);
		
		JLabel etiquetaDeSemillas = new JLabel("Numero de semillas:");
		cambiarJuego.add(etiquetaDeSemillas);
		
		textoSemillas= new JTextField();
		cambiarJuego.add(textoSemillas);
		
		JLabel etiquetaDeColorJ1= new JLabel("Color del jugador 1");
		cambiarJuego.add(etiquetaDeColorJ1);
		
		cambiarJuego.add(colorJugador1);
		
		JLabel etiquetaDeColorJ2 = new JLabel("Selecione el color de la cpu");
		cambiarJuego.add(etiquetaDeColorJ2);
		
		cambiarJuego.add(colorJugador2);
		
		cambiarJuego.add(jugarPersonalizado);
		
		refresque();
		
	}
	private void paletaDeColores1(){
		JDialog colores= new JDialog();
		color1=JColorChooser.showDialog(colores,"Elige un color", Color.RED);
	}
	private void paletaDeColores2(){
		JDialog colores= new JDialog();
		color2=JColorChooser.showDialog(colores,"Elige un color", Color.BLUE);
	}
	private void modoPerzonalizado(){
		try{
			int casa= Integer.parseInt(textoCasa.getText());
			int semilla= Integer.parseInt(textoSemillas.getText());
			prepareElementosTablero(casa,semilla,color1,color2);
			bordeInferior();
		}catch(Exception e){
				JOptionPane.showMessageDialog(this,"El campo casa o semillas tiene elementos no numericos o estan vacios.");
		}
	}
	private void prepareAccionesBotones(){
		for (int i=0; i<tablero.size();++i){
			int casaElegida=i;
			tablero.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					jugar(casaElegida);
				}
			});
		}
	}
	private void volver(){
		prepareElementosTablero(numeroCasas,numeroSemillas,color1,color2);
		bordeInferior();
		refresque();
	}
	private void prepareAcciones(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		});
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		salvarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				normal();
			}
		});
		personalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalizado();
			}
		});
		colorJugador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paletaDeColores1();
			}
		});
		colorJugador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paletaDeColores2();
			}
		});
		jugarPersonalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modoPerzonalizado();
			}
		});

	}
	private void bordeInferior(){
		JPanel inferior= new JPanel();
		inferior.setLayout(new GridLayout(1,2));
		reiniciar= new JButton("Reiniciar");
		etiquetaDeJugadas = new JLabel("   Numero de Jugadas: "+games.getJugadoas());
		inferior.add(reiniciar);
		inferior.add(etiquetaDeJugadas);
		this.add(inferior,BorderLayout.SOUTH);
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
	}
	private void prepareElementosMenu(){
		menuBar= new JMenuBar();
		menu=  new JMenu("Menu");
		nuevo= new JMenu("Nuevo");
		normal= new JMenuItem("Modo normal");
		personalizar= new JMenuItem("Modo personalizado");
		nuevo.add(normal);
		nuevo.add(personalizar);
		menu.add(nuevo);
		abrir= new JMenuItem("Abrir");
		menu.add(abrir);
		salvar= new JMenuItem("Guardar");
		menu.add(salvar);
		salvarComo= new JMenuItem("Guardar Como");
		menu.add(salvarComo);
		salir= new JMenuItem("Salir");
		menu.add(salir);
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		colorJugador1= new JButton("Selecione el color");
		colorJugador2= new JButton("Selecione el color");
		jugarPersonalizado= new JButton("jugar");
	}
	private void prepareElementos(){
		this.setTitle("Kalah");
		this.setTamano(970,525);
		this.setLocalizacion(500,250);
		prepareElementosMenu();
		normal();
		bordeInferior();
	}

	public static void main(String[] args){
		KalahGUI game= new KalahGUI();
		game.makeVisible();
	}
	
} 
