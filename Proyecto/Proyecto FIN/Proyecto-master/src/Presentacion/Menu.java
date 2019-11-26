	package Presentacion;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Aplicacion.ArkanoidException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton multijugador;
	private JButton playerVsCpu;
	private JButton Casico;
	private Button salir;
	private JButton abrir;
	private ArkanoidGUI game;
	
	private JComboBox tipoDeBola;
	private JComboBox tipoBarra2;
	private JComboBox tipoBarra1;
	
	private String imagenBola;
	private String imagenBarra;
	private String imagenBarra2;
	
	private JLabel ColorDeLaBola;
	private JLabel fondo;
	private JLabel lblBarra;
	private JLabel lblOnePlayer;
	private JLabel lblTwoLabel ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setUndecorated(true);
		setAutoRequestFocus(false);
		setTitle("Arkanoid");
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Recursos/icon_Juego.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 525);
		setLocationRelativeTo(null);
		prepareElementos();
		prepareAcciones();
		prepareElementosVisibles();
		
	
	}
	
	private void prepareElementosVisibles() {
		imagenBola = "Bola_Normal.png";
		imagenBarra = "tipoDeBarra.gif";
		imagenBarra2 = "tipoDeBarra2.gif";
		tipoDeBola.setVisible(false);
		lblBarra.setVisible(false);
		lblOnePlayer.setVisible(false);
		lblTwoLabel.setVisible(false);
		tipoBarra1.setVisible(false);
		tipoBarra2.setVisible(false);
	}
		
	private void prepareElementos() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ColorDeLaBola = new JLabel("Color de la Bola");
		ColorDeLaBola.setFont(new Font("Arkanoid", Font.BOLD, 22));
		ColorDeLaBola.setForeground(new Color(255, 255, 255));
		ColorDeLaBola.setBounds(40, 211, 274, 33);
		ColorDeLaBola.setVisible(false);
		
		
		
		lblTwoLabel = new JLabel("PLAYER TWO");
		lblTwoLabel.setForeground(Color.WHITE);
		lblTwoLabel.setFont(new Font("Arkanoid", Font.BOLD, 22));
		lblTwoLabel.setBounds(112, 358, 180, 33);
		contentPane.add(lblTwoLabel);
		
		lblOnePlayer = new JLabel("PLAYER ONE");
		lblOnePlayer.setForeground(SystemColor.text);
		lblOnePlayer.setFont(new Font("Arkanoid", Font.BOLD, 22));
		lblOnePlayer.setBounds(112, 315, 202, 33);
		contentPane.add(lblOnePlayer);
		
		lblBarra = new JLabel("Tipo de Barra");
		lblBarra.setForeground(SystemColor.textHighlightText);
		lblBarra.setFont(new Font("Arkanoid", Font.BOLD, 22));
		lblBarra.setBounds(40, 271, 274, 33);
		contentPane.add(lblBarra);
		contentPane.add(ColorDeLaBola);
		
		tipoDeBola = new JComboBox();
		tipoDeBola.setForeground(Color.BLACK);
		tipoDeBola.setBounds(453, 216, 47, 28);
		tipoDeBola.setModel(loadImagesBallType());
		contentPane.add(tipoDeBola);
		
		tipoBarra2 = new JComboBox();
		tipoBarra2.setBounds(375, 369, 125, 20);
		tipoBarra2.setModel(loadImagesBar1Type());
		contentPane.add(tipoBarra2);
		
		tipoBarra1 = new JComboBox();
		tipoBarra1.setBounds(375, 326, 125, 20);
		tipoBarra1.setModel(loadImagesBar1Type());
		contentPane.add(tipoBarra1);
		
		abrir = new JButton("");
		abrir.setIcon(new ImageIcon(Menu.class.getResource("/Recursos/Capture.PNG")));
		abrir.setBounds(10, 474, 47, 39);
		contentPane.add(abrir);
		
		multijugador = new JButton("ONE VS ONE");
		multijugador.setFont(new Font("Arkanoid Solid", Font.PLAIN, 15));
		multijugador.setForeground(Color.WHITE);
		multijugador.setBackground(Color.BLUE);
		multijugador.setBounds(406, 415, 150, 33);
		contentPane.add(multijugador);
		
		playerVsCpu = new JButton("PLAYER VS CPU\r\n");
		playerVsCpu.setFont(new Font("Arkanoid Solid", Font.PLAIN, 14));
		playerVsCpu.setBackground(Color.BLUE);
		playerVsCpu.setForeground(Color.WHITE);
		playerVsCpu.setBounds(227, 415, 150, 33);
		contentPane.add(playerVsCpu);
		
		Casico = new JButton("ONE PLAYER");
		Casico.setFont(new Font("Arkanoid Solid", Font.PLAIN, 15));
		Casico.setBackground(Color.BLUE);
		Casico.setForeground(Color.WHITE);
		Casico.setBounds(40, 415, 150, 33);
		contentPane.add(Casico);
		
		salir = new Button("EXIT");
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Arkanoid Solid", Font.BOLD, 20));
		salir.setBackground(Color.RED);
		salir.setBounds(227, 480, 150, 33);
		contentPane.add(salir);
		
		fondo = new JLabel("");
		fondo.setFont(new Font("Arkanoid", Font.BOLD, 22));
		fondo.setIcon(new ImageIcon(Menu.class.getResource("/Recursos/Menu.gif")));
		fondo.setBounds(0, 0, 589, 600);
		contentPane.add(fondo);
	}
	
	private DefaultComboBoxModel<Icon> loadImagesBallType() {
		String s = new String();
		DefaultComboBoxModel<Icon> combo = new DefaultComboBoxModel<Icon>();
		
		combo.addElement(new ImageIcon("src/Recursos/Bola_Normal.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_2.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_3.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_4.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_5.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_6.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_7.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_8.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_9.png"));
		combo.addElement(new ImageIcon("src/Recursos/Pokebola_10.png"));
		return combo;
	}
	private DefaultComboBoxModel<Icon> loadImagesBar1Type() {
		String s = new String();
		DefaultComboBoxModel<Icon> combo = new DefaultComboBoxModel<Icon>();
		
		combo.addElement(new ImageIcon("src/Recursos/tipoDeBarraLbl.png"));
		combo.addElement(new ImageIcon("src/Recursos/tipoDeBarra2Lbl.png"));
		combo.addElement(new ImageIcon("src/Recursos/tipoDeBarra3Lbl.png"));
		return combo;
	}
	
	
	private void prepareAcciones() {	
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrir();
			}
		});
		
		Casico.addActionListener(new ActionListener() {
			int clicks = 0;
			public void actionPerformed(ActionEvent e) {
				escogerElementos(1);
				clicks +=1;
				if (clicks==2) {
					juego(1);
				}

			}
		});
		playerVsCpu.addActionListener(new ActionListener() {
			int clicks = 0;
			public void actionPerformed(ActionEvent e) {
				escogerElementos(2);
				clicks +=1;
				if (clicks==2) {
					juego(2);
				}

			}
		});
		multijugador.addActionListener(new ActionListener() {
			int clicks = 0;
			public void actionPerformed(ActionEvent e) {
				escogerElementos(2);
				clicks +=1;
				if (clicks==2) {
					juego(3);
				}

			}
		});
		tipoDeBola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = tipoDeBola.getSelectedItem().toString();
				if(path.equals("src/Recursos/Bola_Normal.png")) {
					imagenBola ="Bola_Normal.png";
				}else if(path.equals("src/Recursos/Pokebola_2.png")) {
					
					imagenBola ="Pokebola_2.png";
					
				}else if(path.equals("src/Recursos/Pokebola_3.png")) {
					imagenBola ="Pokebola_3.png";
					
				}else if(path.equals("src/Recursos/Pokebola_4.png")) {
					imagenBola ="Pokebola_4.png";
					
				}else if(path.equals("src/Recursos/Pokebola_5.png")) {
					imagenBola ="Pokebola_5.png";
					
				}else if(path.equals("src/Recursos/Pokebola_6.png")) {
					imagenBola ="Pokebola_6.png";
					
				}else if(path.equals("src/Recursos/Pokebola_7.png")) {
					imagenBola ="Pokebola_7.png";
					
				}else if(path.equals("src/Recursos/Pokebola_8.png")) {
					imagenBola ="Pokebola_8.png";
					
				}else if(path.equals("src/Recursos/Pokebola_9.png")) {
					imagenBola ="Pokebola_9.png";
					
				}else if(path.equals("src/Recursos/Pokebola_10.png")) {
					imagenBola ="Pokebola_10.png";
					
				}
			}
		});
		tipoBarra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = tipoBarra1.getSelectedItem().toString();
				if(path.equals("src/Recursos/tipoDeBarraLbl.png")) {
					imagenBarra ="tipoDeBarra.gif";
				}else if(path.equals("src/Recursos/tipoDeBarra2Lbl.png")) {
					imagenBarra ="tipoDeBarra2.gif";
					
				}else if(path.equals("src/Recursos/tipoDeBarra3Lbl.png")) {
					imagenBarra ="tipoDeBarra3.gif";
					
				}
			}
		});
		tipoBarra2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = tipoBarra2.getSelectedItem().toString();
				if(path.equals("src/Recursos/tipoDeBarraLbl.png")) {
					imagenBarra2 ="tipoDeBarra.gif";
				}else if(path.equals("src/Recursos/tipoDeBarra2Lbl.png")) {
					imagenBarra2 ="tipoDeBarra2.gif";
					
				}else if(path.equals("src/Recursos/tipoDeBarra3Lbl.png")) {
					imagenBarra2 ="tipoDeBarra3.gif";
					
				}
			}
		});
	}
	private void escogerElementos(int tipoDeJuego) {
		fondo.setIcon(new ImageIcon(Menu.class.getResource("/Recursos/Menu2.gif")));
		ColorDeLaBola.setVisible(true);
		tipoDeBola.setVisible(true);
		lblBarra.setVisible(true);
		lblOnePlayer.setVisible(true);
		tipoBarra1.setVisible(true);
		if(tipoDeJuego==2) {
			lblTwoLabel.setVisible(true);
			tipoBarra2.setVisible(true);
		}
	}
	private void juego(int etapa) {
		dispose();
		if(etapa ==1) {
			game = new ArkanoidGUI(etapa,imagenBola,imagenBarra,imagenBarra2,"normal");
		}else if(etapa ==3) {
			game= new Arkanoid2Players(1,imagenBola,imagenBarra,imagenBarra2,"vsPlayer");
		}else if(etapa ==2) {
			game= new Arkanoid2Players(2,imagenBola,imagenBarra,imagenBarra2,"vsCpu");
		}
		game.setVisible(true);
		game.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	private void abrir() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(abrir)== JFileChooser.APPROVE_OPTION) {
			File nombre = file.getSelectedFile();
	        try {
	            ObjectInputStream documento = new ObjectInputStream(new FileInputStream(nombre.toString()));
	            game = (ArkanoidGUI)documento.readObject();
	        }catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "No se pudo abrir.");
	        }
	        game.setVisible(true);
		}
		
	}
}
