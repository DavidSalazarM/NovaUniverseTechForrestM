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
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelModificar extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField nombreCancion,nuevoNombre,nuevoArtista;
	private JComboBox<String>nuevoGenero;
	private JButton butBuscar, butModificar;
	private DefaultListModel<String> listaCanciones;
	private JList<String> jList;
	private static final String BUSCARCANCION = "buscarCancionM";
   private static final String MOFDIFICAR = "modificarCancion";
   private static final String SELECCIONAR = "seleccionar";
   
   Color rosita = new Color(246,212,210,255);
	 Color morado = new Color(73,39,74,255);
	 Color lila = new Color(148,97,142,255);
	
	public PanelModificar() {
		
    	setSize(300, 600);
        setBackground(lila);
        setLayout(null);
        Font fuente = new Font("Times New Roman", Font.PLAIN, 20);//tipo de letra
        
        // creamos casillas escribir nombre
        
        nombreCancion = new JTextField(0);
        nombreCancion.setText("");
        nombreCancion.setForeground(morado);
        nombreCancion.setBounds(100, 90, 200, 40);
      //para la barra
        nombreCancion.setFont(fuente);
        nombreCancion.setText("Nombre de la canción  ");
        nombreCancion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	nombreCancion.setText("");
            }
        });
        
        nuevoNombre = new JTextField(0);
        nuevoNombre.setText("");
        nuevoNombre.setForeground(morado);
        nuevoNombre.setBounds(80, 350, 250, 40);
        //para la barra
        nuevoNombre.setFont(fuente);
        nuevoNombre.setText("Nuevo nombre de la canción ");
        nuevoNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	nuevoNombre.setText("");
            }
        });
        
       
        nuevoArtista = new JTextField(0);
        nuevoArtista.setText("");
        nuevoArtista.setForeground(morado);
        nuevoArtista.setBounds(80, 400, 250, 40);
      //para la barra
        nuevoArtista.setFont(fuente);
        nuevoArtista.setText("Nombre del artista ");
        nuevoArtista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	nuevoArtista.setText("");
            }
        });
        
        nuevoGenero = new JComboBox<String>();
        nuevoGenero.addItem("Elija un genero");
        nuevoGenero.addItem("POP");
        nuevoGenero.addItem("BACHATA");
        nuevoGenero.addItem("BALADA");
        nuevoGenero.addItem("REGUETON");
        nuevoGenero.addItem("VALLENATO");
        nuevoGenero.addItem("ROCK");
        nuevoGenero.addItem("DANCE/ELECTRO");
        nuevoGenero.addItem("CLASICA");
        nuevoGenero.addItem("SALSA");
        nuevoGenero.addItem("OTROS");
        nuevoGenero.setBounds(110, 450, 160, 40);
        
       // creamos boton buscar
        
        butBuscar = new JButton("Buscar");
        butBuscar.setBounds(150, 135, 100, 40);
        butBuscar.setBorder(new BevelBorder(BevelBorder.RAISED));
        butBuscar.setActionCommand(BUSCARCANCION);
        butBuscar.setBackground(rosita);
        
        butModificar = new JButton("Modificar");
        butModificar.setBounds(150, 509, 100, 40);
        butModificar.setBorder(new BevelBorder(BevelBorder.RAISED));
        butModificar.setActionCommand(MOFDIFICAR);
        butModificar.setBackground(rosita);
        
        listaCanciones= new DefaultListModel<>();
        
        
        // creamos Jlist 
       
        jList= new JList<>(listaCanciones);
        JScrollPane scroll= new JScrollPane(jList);
        scroll.setBounds(40, 180, 310, 150);
        
        add(scroll);
        add(nombreCancion);
        add(butBuscar);
        add(nuevoArtista);
        add(nuevoNombre);
        add(nuevoGenero);
        add(butModificar);
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
        g2d.fillRoundRect(10, 10, width - 20, height / 2- 320, 20, 20); // x, y, ancho, alto, arcWidth, arcHeight
        // Rellenar rectángulo inferior y bordes redondeados 
        g2d.setColor(morado);
        g2d.fillRoundRect(10, 500, width - 20, height / 2 - 320, 20, 20); // x, y, ancho, alto, arcWidth, arcHeight
        
      //circulos
        double width2 = getWidth();
        double height2 = getHeight();
         
        g2d.setColor(rosita); // Establecer el color del círculo
        double diametro1 = 45; // Tamaño del círculo
        double x1 = (width - diametro1) / 7; // Calcular la posición x para centrar el círculo horizontalmente
        double y1 = (height - diametro1) / 8; // Calcular la posición y para centrar el círculo verticalmente
        g2d.fillOval((int)x1, (int)y1, (int)diametro1, (int)diametro1); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado
   
        g2d.setColor(rosita); // Establecer el color del círculo
        double diametro2 = 40; // Tamaño del círculo
        double x2 = (width - diametro2) / 12.5; // Calcular la posición x para centrar el círculo horizontalmente
        double y2 = (height - diametro2) / 2.01; // Calcular la posición y para centrar el círculo verticalmente
        g2d.fillOval((int)x2, (int)y2, (int)diametro2, (int)diametro2); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado
        
         g2d.setColor(rosita); // Establecer el color del círculo
        double diametro3 = 40; // Tamaño del círculo
        double x3 = (width - diametro2) / 12.5; // Calcular la posición x para centrar el círculo horizontalmente
        double y3 = (height - diametro2) / 1.78; // Calcular la posición y para centrar el círculo verticalmente
        g2d.fillOval((int)x3, (int)y3, (int)diametro3, (int)diametro3); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado

	}

	public void listaCanciones(String[] lista ) {
		
		listaCanciones.clear();
		String nombre="";
		String autor="";
		// dividimos lista
		for(String elemento: lista) {
			String[] parte= elemento.split("-");
			nombre= parte[0];
			autor= parte[1];
	
		//agregar las canciones para la lista	
			listaCanciones.addElement(nombre+"-"+autor);
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

	public JButton getButBuscar() {
		return butBuscar;
	}

	public void setButBuscar(JButton butBuscar) {
		this.butBuscar = butBuscar;
	}

	public JButton getButModificar() {
		return butModificar;
	}

	public void setButModificar(JButton butModificar) {
		this.butModificar = butModificar;
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

	public static String getMofdificar() {
		return MOFDIFICAR;
	}

	public JTextField getNuevoNombre() {
		return nuevoNombre;
	}

	public void setNuevoNombre(JTextField nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}

	public JTextField getNuevoArtista() {
		return nuevoArtista;
	}

	public void setNuevoArtista(JTextField nuevoArtista) {
		this.nuevoArtista = nuevoArtista;
	}



	public JComboBox<String> getNuevoGenero() {
		return nuevoGenero;
	}

	public void setNuevoGenero(JComboBox<String> nuevoGenero) {
		this.nuevoGenero = nuevoGenero;
	}

	public static String getSeleccionar() {
		return SELECCIONAR;
	}
	
	

}
