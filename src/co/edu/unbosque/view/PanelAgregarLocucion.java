package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelAgregarLocucion extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField nombreCancion, tituloArtista;
	private JComboBox<String> genero;
    private JButton elegirCancion, agregar;

    private static final String GUARDARCANCION = "GuardarLocucion";
    private static final String ELEGIRCANCION = "ElegirLocucion";

    Color rosita = new Color(246,212,210,255);
	 Color morado = new Color(73,39,74,255);
	 Color lila = new Color(148,97,142,255);
	

    public  PanelAgregarLocucion() {
		// TODO Auto-generated constructor stub
    	
    	setSize(300, 500);
        setBackground(lila);
        setLayout(null);
        Font fuente = new Font("Times New Roman", Font.PLAIN, 20);//tipo de letra

        // creamos casillas escribir nombre

        nombreCancion = new JTextField(0);
        nombreCancion.setText("");
        nombreCancion.setForeground(morado);
        nombreCancion.setBounds(80, 100, 250, 40);
        //para la barra
        nombreCancion.setFont(fuente);
        nombreCancion.setText("Digite ");
        nombreCancion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	nombreCancion.setText("");
            }
        });

        tituloArtista = new JTextField(0);
        tituloArtista.setText("");
        tituloArtista.setForeground(morado);
        tituloArtista.setBounds(80, 180, 250, 40);
        //para la barra
        tituloArtista.setFont(fuente);
        tituloArtista.setText("Digite ");
        tituloArtista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	tituloArtista.setText("");
            }
        });
        

        genero = new JComboBox<String>();
        genero.addItem("Elija un genero");
        genero.addItem("HUMOR");
        genero.addItem("HISTORIA");
        genero.addItem("NOTICIA");
        genero.addItem("CHISME");
        genero.addItem("OTROS");

        
        genero.setForeground(morado);
        genero.setBounds(110, 240, 200, 40);

        elegirCancion = new JButton("Elegir locución");
        elegirCancion.setBounds(150, 300, 100, 40);
        elegirCancion.setBorder(new BevelBorder(BevelBorder.RAISED));
        elegirCancion.setActionCommand(ELEGIRCANCION);
        elegirCancion.setBackground(rosita);

        agregar = new JButton("Agregar");
        agregar.setBounds(150, 405, 100, 40);
        agregar.setBorder(new BevelBorder(BevelBorder.RAISED));
        agregar.setActionCommand(GUARDARCANCION);
        agregar.setBackground(rosita);
        


        add(nombreCancion);
        add(elegirCancion);
        add(agregar);
        add(tituloArtista);
        add(genero);
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
        
        
        double width2 = getWidth();
        double height2 = getHeight();  
        //circulos
        
        g2d.setColor(rosita); // Establecer el color del círculo
        double diametro1 = 45; // Tamaño del círculo
        double x1 = (width - diametro1) / 12; // Calcular la posición x para centrar el círculo horizontalmente
        double y1 = (height - diametro1) / 4.3; // Calcular la posición y para centrar el círculo verticalmente
        g2d.fillOval((int)x1, (int)y1, (int)diametro1, (int)diametro1); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado
   
        g2d.setColor(rosita); // Establecer el color del círculo
        double diametro2 = 45; // Tamaño del círculo
        double x2 = (width - diametro2) / 12; // Calcular la posición x para centrar el círculo horizontalmente
        double y2 = (height - diametro2) / 2.3; // Calcular la posición y para centrar el círculo verticalmente
        g2d.fillOval((int)x2, (int)y2, (int)diametro2, (int)diametro2); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado
    }

	


	public JTextField getNombreCancion() {
		return nombreCancion;
	}


	public void setNombreCancion(JTextField nombreCancion) {
		this.nombreCancion = nombreCancion;
	}




	public JTextField getTituloArtista() {
		return tituloArtista;
	}




	public void setTituloArtista(JTextField tituloArtista) {
		this.tituloArtista = tituloArtista;
	}

	public JComboBox<String> getGenero() {
		return genero;
	}




	public JButton getElegirCancion() {
		return elegirCancion;
	}




	public void setElegirCancion(JButton elegirCancion) {
		this.elegirCancion = elegirCancion;
	}




	public JButton getAgregar() {
		return agregar;
	}




	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public static String getGuardarcancion() {
		return GUARDARCANCION;
	}




	public static String getElegircancion() {
		return ELEGIRCANCION;
	}




	public void setGenero(JComboBox<String> genero) {
		this.genero = genero;
	}
	
	


}
