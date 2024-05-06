package co.edu.unbosque.view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileSystemView;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class PanelAMCancion extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreCancion, tituloArtista;
	private JComboBox<String> genero;
    private JButton elegirCancion, agregar;

    private static final String GUARDARCANCION = "GuardarCancion";
    private static final String ELEGIRCANCION = "ElegirCancion";

    Color rosita = new Color(246,212,210,255);
	 Color morado = new Color(73,39,74,255);
	 Color lila = new Color(148,97,142,255);

    public PanelAMCancion() {
    	
    	
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
        nombreCancion.setText("Digite el nombre de la canción ");
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
        tituloArtista.setText("Digite el artista ");
        tituloArtista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	tituloArtista.setText("");
            }
        });
        
        genero = new JComboBox<String>();
        genero.addItem("Elija un genero");
        genero.addItem("POP");
        genero.addItem("BACHATA");
        genero.addItem("BALADA");
        genero.addItem("REGUETON");
        genero.addItem("VALLENATO");
        genero.addItem("ROCK");
        genero.addItem("DANCE/ELECTRO");
        genero.addItem("CLASICA");
        genero.addItem("SALSA");
        genero.addItem("OTROS");
        
        
        genero.setForeground(morado);
        genero.setBounds(110, 240, 200, 40);

        elegirCancion = new JButton("Elegir canción");
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




	public void setGenero(JComboBox<String> genero) {
		this.genero = genero;
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








	public static String getGuardarcancion() {
		return GUARDARCANCION;
	}




	public static String getElegircancion() {
		return ELEGIRCANCION;
	}








	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	


}
