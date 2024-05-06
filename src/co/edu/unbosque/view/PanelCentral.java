package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelCentral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Object[][] datosMostrar;
	private DefaultTableModel gestorTablaDos;
	private DefaultTableCellRenderer personalizador;
	private DefaultTableCellRenderer personalizadorColumna;

	
	
	public PanelCentral() {
		Color rosita = new Color(246, 212, 210, 255);
		Color lila = new Color(177, 117, 255, 255);
		Color morado = new Color(73, 39, 74, 255);

		Font tipoLetra = new Font("Times New Roman", Font.ITALIC, 15);
		Font tipoLetraTabla = new Font("Baguet Script", Font.ITALIC, 12);

		setBackground(rosita);
		setBorder(BorderFactory.createLineBorder(lila, 2));
		setPreferredSize(new Dimension(200, 20));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new GridBagLayout());
		GridBagConstraints divisor = new GridBagConstraints();

		JPanel panelArriba = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon myIcon = new ImageIcon("./Imagenes/ImgCentro.jpg");
                Image image = myIcon.getImage();

                // Calcula el tamaño de la imagen
                int panelWidth = getWidth(); // Ancho del panel
                int panelHeight = getHeight(); // Alto del panel
                int imageWidth = myIcon.getIconWidth();
                int imageHeight = myIcon.getIconHeight();

                // Escala la imagen al tamaño del panel manteniendo la proporción
                int scaledWidth = panelWidth;
                int scaledHeight = panelWidth * imageHeight / imageWidth;

                // Calcula las coordenadas para centrar la imagen verticalmente
                int y = (panelHeight - scaledHeight) / 2;

                // Dibuja la imagen en el panel
                g.drawImage(image, 0, y, scaledWidth, scaledHeight, this);
            }
        };
        panelArriba.setBackground(morado);
        panelArriba.setBorder(BorderFactory.createLineBorder(rosita, 2));
        panelArriba.setPreferredSize(new Dimension(200, 50)); // Tamaño del panel para la imagen

		// restricciones para el panel de arriba
		divisor.gridx = 0;
		divisor.gridy = 0;
		divisor.fill = GridBagConstraints.BOTH;
		divisor.weightx = 1.0;
		divisor.weighty = 0.35; // 25% del espacio vertical disponible
		add(panelArriba, divisor);
		
	
		
		

		//JPanel imagen = new JPanel() {
		
			
        
		
		
		// Nombre de cada columna y crear tabla
		String[] nombresColumnas = { "#", "Nombre", "Autor", "Tipo" };
		table = new JTable(new DefaultTableModel(datosMostrar, nombresColumnas));
		table.setRowHeight(20); // altura de la tabla
		table.setDefaultEditor(Object.class, null); // desahabilita la edición de la tabla

		// controlador de la tabla
		gestorTablaDos = (DefaultTableModel) table.getModel();
		// personalizar tabla
		personalizador = new DefaultTableCellRenderer() {

			private static final long serialVersionUID = 1L;

			// personaliza fila
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (!isSelected) {
					// cada fila par cambia color de la fila a lila las otras al color
					if (row % 2 == 0) {
						c.setBackground(rosita);
					} else {
						c.setBackground(Color.white);
					}
				}
				c.setFont(tipoLetraTabla); // Tipo de letra de la fila
				return c;
			}
		};
		personalizador.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, personalizador);

		// prsonalizar columnas
		personalizadorColumna = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground(rosita);
				c.setForeground(Color.WHITE);
				((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
				c.setFont(tipoLetraTabla); // cambio tipo de letra de la columna
				return c;
			}
		};
		table.getTableHeader().setDefaultRenderer(personalizadorColumna);

		// tamaño de columnas
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // dsesactiva ajustes automáticamento
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		// JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Scroll de desplazamiento
																								// horizontal
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Scroll de desplazamiento
																							// vertical

		// titulo para la tabla
		TitledBorder tituloNombre = BorderFactory.createTitledBorder("PlaylistModel");
		tituloNombre.setTitleColor(lila);
		tituloNombre.setTitleFont(tipoLetra);

		// Establecer el borde con el título al JScrollPane
		scrollPane.setBorder(tituloNombre);

		// restricciones para el panel de abajo
		divisor.gridx = 0;
		divisor.gridy = 1;
		divisor.weighty = 0.65; // 75% del espacio vertical disponible

	
		add(scrollPane, divisor);
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Object[][] getDatosMostrar() {
		return datosMostrar;
	}

	public void setDatosMostrar(Object[][] datosMostrar) {
		this.datosMostrar = datosMostrar;
	}

	public DefaultTableModel getGestorTablaDos() {
		return gestorTablaDos;
	}

	public void setGestorTablaDos(DefaultTableModel gestorTablaDos) {
		this.gestorTablaDos = gestorTablaDos;
	}

	public DefaultTableCellRenderer getPersonalizador() {
		return personalizador;
	}

	public void setPersonalizador(DefaultTableCellRenderer personalizador) {
		this.personalizador = personalizador;
	}

	public DefaultTableCellRenderer getPersonalizadorColumna() {
		return personalizadorColumna;
	}

	public void setPersonalizadorColumna(DefaultTableCellRenderer personalizadorColumna) {
		this.personalizadorColumna = personalizadorColumna;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
