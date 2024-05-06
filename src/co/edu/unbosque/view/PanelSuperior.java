package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class PanelSuperior extends JPanel {

	private static final long serialVersionUID = 1L;
	private JMenu butAjusteAudios,butIniciarTransmision;
	private JMenu cancion, locucion, comercial;
	private JMenuItem agregarCancion,agregarLocucion,agregarComercial;
	private JMenuItem modificarCancion,modificarLocucion,modificarComercial;
	private JMenuItem eliminarCancion,eliminarLocucion,eliminarComercial;
	private JMenuItem nuevaParilla;
	private JMenuBar menuBar;
	private JButton detener;
	 private JLabel titulo;

	private static final String INICIARTRANSMISION = "IniciarTransmision";
	private static final String AJUSTEAUDIOS = "AjusteAudios";
	private static final String DETENERT = "detenerTrasmision";
	private static final String AGREGARCANCION = "agregarCanciones";
	


	public PanelSuperior() {
		
		// colores y fuente
		Color rosita = new Color(246,212,210,255);
		 Color morado = new Color(73,39,74,255);
		 Color lila = new Color(148,97,142,255);
		Font fuenteLetra = new Font("Times New Roman", Font.ITALIC, 16);
// parametros del panel 
		JPanel panelSuperior = new JPanel();
		panelSuperior.setPreferredSize(new Dimension(800, 50));
		panelSuperior.setBackground(morado);
		panelSuperior.setLayout(null); 
		setBorder(BorderFactory.createLineBorder(lila, 2)); 
	    setPreferredSize(new Dimension(750, 60)); 
// creamos el contendor de las opciones de boton ajustes Audios
		JMenuBar menuBarAudio = new JMenuBar();
		menuBarAudio.setBackground(rosita);
		
		JMenuBar menuBarTrasmitir = new JMenuBar();
		menuBarTrasmitir.setBackground(rosita);
// agregamos botón ajustes audios y el menu da cada uno 
		
		butAjusteAudios = new JMenu("Ajuste audios");
		butAjusteAudios.setBorder(new BevelBorder(BevelBorder.RAISED));
		butAjusteAudios.setPreferredSize(new Dimension(100, 50));
		cancion = new JMenu("Gestionar canciones");
		locucion = new JMenu("Gestionar locuciones");
		comercial = new JMenu("Gestionar comerciales");
		
		//opciones de canción
		agregarCancion= new JMenuItem("Agregar canción");
		modificarCancion= new JMenuItem("Modificar canción");
		eliminarCancion= new JMenuItem("Eliminar canción");
		cancion.add(agregarCancion);
		cancion.add(modificarCancion);
		cancion.add(eliminarCancion);
		agregarCancion.setActionCommand(AGREGARCANCION);
		
		//opciones de locución
		agregarLocucion= new JMenuItem("Agregar locución");
		modificarLocucion= new JMenuItem("Modificar locución");
		eliminarLocucion= new JMenuItem("Eliminar locución");
		locucion.add(agregarLocucion);
		locucion.add(modificarLocucion);
		locucion.add(eliminarLocucion);
		
		// opciones de Comercial
		agregarComercial= new JMenuItem("Agregar comercial");
		modificarComercial= new JMenuItem("Modificar comercial");
		eliminarComercial= new JMenuItem("Eliminar comercial");
		comercial.add(agregarComercial);
		comercial.add(modificarComercial);
		comercial.add(eliminarComercial);
		

		
		titulo= new JLabel("Nombre Emisora");
		titulo.setForeground(Color.white);
		titulo.setFont(fuenteLetra);
		
		titulo.setBounds(320, 15, 300, 30); 
		
		
		butAjusteAudios.add(cancion);
		butAjusteAudios.add(locucion);
		butAjusteAudios.add(comercial);
		menuBarAudio.add(butAjusteAudios);


		menuBarAudio.setBounds(10, 5, 100, 50); 
		
		// boton inciar y detener trasmicion
		
		butIniciarTransmision = new JMenu(" Iniciar trasmición");
		butIniciarTransmision.setBorder(new BevelBorder(BevelBorder.RAISED));
		butIniciarTransmision.setPreferredSize(new Dimension(130, 50));
		nuevaParilla= new JMenuItem("Nueva programación");
		butIniciarTransmision.add(nuevaParilla);
        menuBarTrasmitir.add(butIniciarTransmision);
		menuBarTrasmitir.setBounds(500, 5, 130, 50); 
		
		detener= new JButton("Detener trasmisión");
		detener.setBackground(rosita);
		detener.setBounds(650, 5, 130, 50); 
		detener.setBorder(new BevelBorder(BevelBorder.RAISED));
		detener.setActionCommand(DETENERT);
		
		
		
		
	
		panelSuperior.add(menuBarAudio);
		panelSuperior.add(menuBarTrasmitir);
		panelSuperior.add(titulo);
		panelSuperior.add(detener);



		add(panelSuperior);
	}



	
	public JMenu getButIniciarTransmision() {
		return butIniciarTransmision;
	}




	public void setButIniciarTransmision(JMenu butIniciarTransmision) {
		this.butIniciarTransmision = butIniciarTransmision;
	}




	public static String getIniciartransmision() {
		return INICIARTRANSMISION;
	}

	public static String getAjusteaudios() {
		return AJUSTEAUDIOS;
	}

	public JMenu getButAjusteAudios() {
		return butAjusteAudios;
	}

	public void setButAjusteAudios(JMenu butAjusteAudios) {
		this.butAjusteAudios = butAjusteAudios;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getCancion() {
		return cancion;
	}

	public void setCancion(JMenu cancion) {
		this.cancion = cancion;
	}

	public JMenu getLocucion() {
		return locucion;
	}

	public void setLocucion(JMenu locucion) {
		this.locucion = locucion;
	}

	public JMenu getComercial() {
		return comercial;
	}

	public void setComercial(JMenu comercial) {
		this.comercial = comercial;
	}

	public JMenuItem getAgregarCancion() {
		return agregarCancion;
	}

	public void setAgregarCancion(JMenuItem agregarCancion) {
		this.agregarCancion = agregarCancion;
	}






	public JLabel getTitulo() {
		return titulo;
	}




	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}



	public static String getAgregarcancion() {
		return AGREGARCANCION;
	}




	public JMenuItem getAgregarLocucion() {
		return agregarLocucion;
	}

	public void setAgregarLocucion(JMenuItem agregarLocucion) {
		this.agregarLocucion = agregarLocucion;
	}

	public JMenuItem getAgregarComercial() {
		return agregarComercial;
	}

	public void setAgregarComercial(JMenuItem agregarComercial) {
		this.agregarComercial = agregarComercial;
	}

	public JMenuItem getModificarCancion() {
		return modificarCancion;
	}

	public void setModificarCancion(JMenuItem modificarCancion) {
		this.modificarCancion = modificarCancion;
	}

	public JMenuItem getModificarLocucion() {
		return modificarLocucion;
	}

	public void setModificarLocucion(JMenuItem modificarLocucion) {
		this.modificarLocucion = modificarLocucion;
	}

	public JMenuItem getModificarComercial() {
		return modificarComercial;
	}

	public void setModificarComercial(JMenuItem modificarComercial) {
		this.modificarComercial = modificarComercial;
	}

	public JMenuItem getEliminarCancion() {
		return eliminarCancion;
	}

	public void setEliminarCancion(JMenuItem eliminarCancion) {
		this.eliminarCancion = eliminarCancion;
	}

	public JMenuItem getEliminarLocucion() {
		return eliminarLocucion;
	}

	public void setEliminarLocucion(JMenuItem eliminarLocucion) {
		this.eliminarLocucion = eliminarLocucion;
	}

	public JMenuItem getEliminarComercial() {
		return eliminarComercial;
	}

	public void setEliminarComercial(JMenuItem eliminarComercial) {
		this.eliminarComercial = eliminarComercial;
	}



	public JMenuItem getNuevaParilla() {
		return nuevaParilla;
	}




	public void setNuevaParilla(JMenuItem nuevaParilla) {
		this.nuevaParilla = nuevaParilla;
	}






	public static String getDetenert() {
		return DETENERT;
	}




	public JButton getDetener() {
		return detener;
	}




	public void setDetener(JButton detener) {
		this.detener = detener;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
