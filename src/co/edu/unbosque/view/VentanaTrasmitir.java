package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class VentanaTrasmitir extends JFrame{ 
	 private JPanel panelTrasmitir;
	  private JTextField nombretrasmision;
	  private JButton trasmitir;
	  private JComboBox<String> tipoTrasmision,tipomusica,cantidadAnuncio,cantidadLocucion;
	  private static final String GUARDARTRASMISON = "guardartrasmision";
	private static final long serialVersionUID = 1L;
	
	Color rosita = new Color(246,212,210,255);
	 Color morado = new Color(73,39,74,255);
	 Color lila = new Color(148,97,142,255);

	public VentanaTrasmitir() {
		
       setTitle("Trasmitir");
       setSize(400, 500);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
       setBackground(lila);
       setResizable(false);
       Font fuente = new Font("Times New Roman", Font.PLAIN, 20);//tipo de letra
       
       
       panelTrasmitir = new JPanel() {
		private static final long serialVersionUID = 1L;

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
                
             //circulo
               double width2 = getWidth();
               double height2 = getHeight();
                
               g2d.setColor(rosita); // Establecer el color del círculo
               double diametro1 = 40; // Tamaño del círculo
               double x1 = (width - diametro1) / 12; // Calcular la posición x para centrar el círculo horizontalmente
               double y1 = (height - diametro1) / 5; // Calcular la posición y para centrar el círculo verticalmente
               g2d.fillOval((int)x1, (int)y1, (int)diametro1, (int)diametro1); // Dibujar un círculo relleno en la posición (x, y) con el diámetro especificado
       	}
       };
       
       panelTrasmitir.setBackground(lila);
       panelTrasmitir.setPreferredSize(new Dimension(400, 300));
       panelTrasmitir.setLayout(null);
       
       nombretrasmision= new JTextField();
       nombretrasmision.setText("");
       nombretrasmision.setForeground(morado);
       nombretrasmision.setBounds(74, 83, 300, 40);
     //para la barra
       nombretrasmision.setFont(fuente);
       nombretrasmision.setText("Digite el nombre de la transmición");
       nombretrasmision.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	nombretrasmision.setText("");
           }
       });
       
       tipoTrasmision= new JComboBox<String>();
       tipoTrasmision.setBounds(180, 185, 190, 40);
       tipoTrasmision.addItem("Elija un modo de trasmisión");
       tipoTrasmision.addItem("AM");
       tipoTrasmision.addItem("PM");
       tipoTrasmision.addItem("STREAMING");
       
       tipomusica= new JComboBox<String>();
       tipomusica.setBounds(34, 185, 130, 40);
       tipomusica.addItem("Elija un genero");
       tipomusica.addItem("POP");
       tipomusica.addItem("BACHATA");
       tipomusica.addItem("BALADA");
       tipomusica.addItem("REGUETON");
       tipomusica.addItem("VALLENATO");
       tipomusica.addItem("ROCK");
       tipomusica.addItem("DANCE/ELECTRO");
       tipomusica.addItem("CLASICA");
       tipomusica.addItem("SALSA");
       tipomusica.addItem("OTROS");
       
       cantidadAnuncio= new JComboBox<String>();
       cantidadAnuncio.setBounds(10, 300, 175, 40);
       cantidadAnuncio.addItem("Elija cantidad de anuncios");
       cantidadAnuncio.addItem("1");
       cantidadAnuncio.addItem("2");
       cantidadAnuncio.addItem("3");
       
       cantidadLocucion= new JComboBox<String>();
       cantidadLocucion.setBounds(190, 300, 185, 40);
       cantidadLocucion.addItem("Elija cantidad de locuciones");
       cantidadLocucion.addItem("1");
       cantidadLocucion.addItem("2");
       cantidadLocucion.addItem("3");
       
       trasmitir= new JButton("Trasmitir");
       trasmitir.setBounds(155, 405, 100, 40);
       trasmitir.setBorder(new BevelBorder(BevelBorder.RAISED));
       trasmitir.setActionCommand(GUARDARTRASMISON);
       trasmitir.setBackground(rosita);
       
       panelTrasmitir.add(cantidadAnuncio);
       panelTrasmitir.add(cantidadLocucion);
       panelTrasmitir.add(tipomusica);
       panelTrasmitir.add(tipoTrasmision);
       panelTrasmitir.add(nombretrasmision);
       panelTrasmitir.add(trasmitir);
       
       add(panelTrasmitir);
 
	}
	

	public JPanel getPanelTrasmitir() {
		return panelTrasmitir;
	}

	public void setPanelTrasmitir(JPanel panelTrasmitir) {
		this.panelTrasmitir = panelTrasmitir;
	}

	public JTextField getNombretrasmision() {
		return nombretrasmision;
	}

	public void setNombretrasmision(JTextField nombretrasmision) {
		this.nombretrasmision = nombretrasmision;
	}

	public JButton getTrasmitir() {
		return trasmitir;
	}

	public void setTrasmitir(JButton trasmitir) {
		this.trasmitir = trasmitir;
	}

	public JComboBox<String> getTipoTrasmision() {
		return tipoTrasmision;
	}

	public void setTipoTrasmision(JComboBox<String> tipoTrasmision) {
		this.tipoTrasmision = tipoTrasmision;
	}

	public JComboBox<String> getTipomusica() {
		return tipomusica;
	}

	public void setTipomusica(JComboBox<String> tipomusica) {
		this.tipomusica = tipomusica;
	}

	public JComboBox<String> getCantidadAnuncio() {
		return cantidadAnuncio;
	}

	public void setCantidadAnuncio(JComboBox<String> cantidadAnuncio) {
		this.cantidadAnuncio = cantidadAnuncio;
	}

	public JComboBox<String> getCantidadLocucion() {
		return cantidadLocucion;
	}

	public void setCantidadLocucion(JComboBox<String> cantidadLocucion) {
		this.cantidadLocucion = cantidadLocucion;
	}

	public static String getGuardartrasmison() {
		return GUARDARTRASMISON;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

