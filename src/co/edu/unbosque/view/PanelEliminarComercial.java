package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelEliminarComercial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreCancion;
	private JButton botonBuscar, botonEliminar;
	private DefaultListModel<String> listaCanciones;
	private JList<String> jList;
	private static final String BUSCARCANCION = "buscarComercial";
	private static final String ELIMINARCANCION = "eliminarComercial";
	Color rosita = new Color(246, 212, 210, 255);
	Color morado = new Color(73, 39, 74, 255);
	Color lila = new Color(148, 97, 142, 255);

	public PanelEliminarComercial() {

		setSize(300, 500);
		setBackground(lila);
		setLayout(null);
		Font fuente = new Font("Times New Roman", Font.PLAIN, 20);// tipo de letra

		// creamos casilla para buscar

		nombreCancion = new JTextField(0);
		nombreCancion.setText("");
		nombreCancion.setForeground(morado);
		nombreCancion.setBounds(75, 85, 250, 40);
		// para la barra
		nombreCancion.setFont(fuente);
		nombreCancion.setText("Digite el nombre del comercial");
		nombreCancion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombreCancion.setText("");
			}
		});

		// creamos boton buscar

		botonBuscar = new JButton("Buscar");
		botonBuscar.setBounds(150, 150, 100, 40);
		botonBuscar.setBorder(new BevelBorder(BevelBorder.RAISED));
		botonBuscar.setActionCommand(BUSCARCANCION);
		botonBuscar.setBackground(rosita);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(150, 405, 100, 40);
		botonEliminar.setBorder(new BevelBorder(BevelBorder.RAISED));
		botonEliminar.setActionCommand(ELIMINARCANCION);
		botonEliminar.setBackground(rosita);

		listaCanciones = new DefaultListModel<>();

		// creamos Jlist

		jList = new JList<>(listaCanciones);
		JScrollPane scroll = new JScrollPane(jList);
		scroll.setBounds(40, 200, 300, 150);

		add(scroll);
		add(nombreCancion);
		add(botonBuscar);
		add(botonEliminar);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Tamaño del panel
		int width = getWidth();
		int height = getHeight();

		// Rellenar rectángulo superior y bordes redondeados
		g2d.setColor(morado);
		g2d.fillRoundRect(10, 10, width - 20, height / 2 - 180, 20, 20); // x, y, ancho, alto, arcWidth, arcHeight
		// Rellenar rectángulo inferior y bordes redondeados
		g2d.setColor(morado);
		g2d.fillRoundRect(10, 400, width - 20, height / 2 - 180, 20, 20); // x, y, ancho, alto, arcWidth, arcHeight

		// circulos
		double width2 = getWidth();
		double height2 = getHeight();

		g2d.setColor(rosita); // Establecer el color del círculo
		double diametro1 = 45; // Tamaño del círculo
		double x1 = (width - diametro1) / 12; // Calcular la posición x para centrar el círculo horizontalmente
		double y1 = (height - diametro1) / 5; // Calcular la posición y para centrar el círculo verticalmente
		g2d.fillOval((int) x1, (int) y1, (int) diametro1, (int) diametro1); // Dibujar un círculo relleno en la posición
																			// (x, y) con el diámetro especificado
	}

	public void listaCanciones(String[] lista) {

		String nombre = "";
		String autor = "";
		// dividimos lista
		for (String elemento : lista) {
			String[] parte = elemento.split("-");
			nombre = parte[0];
			autor = parte[1];

			// agregar las canciones para la lista
			listaCanciones.addElement(nombre + "-" + autor);

		}

	}

	public void buscarCancion(String nombre) {
		String[] resultadosCercanos = new String[jList.getModel().getSize()];
		int k = 0;
		// pattern se usa para buscar en cualquier parte del nombre la palabra que se
		// desea
		Pattern pattern = Pattern.compile(".*" + Pattern.quote(nombre) + ".*", Pattern.CASE_INSENSITIVE);
		// se hace bucle praa encontrar
		for (int i = 0; i < jList.getModel().getSize(); i++) {
			String cancion = jList.getModel().getElementAt(i);
			// verificar si el nombre hy el patrón coiciden
			if (cancion != null && pattern.matcher(cancion).matches()) {
				resultadosCercanos[k] = cancion;
				k++;
			}
		}

		// limpiamo la lista anterior
		listaCanciones.clear();
		// se añaden los valores que coicidan
		for (String seleccion : resultadosCercanos) {
			listaCanciones.addElement(seleccion);
		}
	}

	public JTextField getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(JTextField nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}

	public DefaultListModel<String> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(DefaultListModel<String> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	public JList<String> getjList() {
		return jList;
	}

	public void setjList(JList<String> jList) {
		this.jList = jList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getBuscarcancion() {
		return BUSCARCANCION;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public static String getEliminarcancion() {
		return ELIMINARCANCION;
	}

}
