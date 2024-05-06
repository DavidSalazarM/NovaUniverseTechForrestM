package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelOesteAbajo extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTable table;
    private Object[][] datosMostrar;
    private DefaultTableModel gestorTabla ;
    private DefaultTableCellRenderer personalizador;
    private DefaultTableCellRenderer personalizadorColumna;
    
    public PanelOesteAbajo() {
    	//datos varios para personalixar
    	Color rosita = new Color(246,212,210,255);
		 Color morado = new Color(73,39,74,255);
		 Color lila = new Color(148,97,142,255);
        
        Font tipoLetra = new Font("Times New Roman", Font.ITALIC, 15);
        Font tipoLetraTabla = new Font("Baguet Script", Font.ITALIC, 12);
        
        //  panel 
        setBackground(lila);
        setBorder(BorderFactory.createLineBorder(lila, 8));
        setPreferredSize(new Dimension(250, 10)); // 
        setLayout(null);

        // Nombre de cada columna y crear tabla 
        String[] nombresColumnas = {"#", "Nombre", "Artista", "Tipo"};
        table = new JTable(new DefaultTableModel(datosMostrar, nombresColumnas));
        table.setRowHeight(20); // altura de la tabla
        table.setDefaultEditor(Object.class, null); // desahabilita la edición de la tabla 

        // controlador de  la tabla
        gestorTabla = (DefaultTableModel) table.getModel();

        // personalizar tabla 
        personalizador = new DefaultTableCellRenderer() {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            // personaliza fila
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(rosita);
                c.setForeground(Color.WHITE);
                ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
                c.setFont(tipoLetraTabla); // cambio tipo  de letra de la columna
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
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Scroll de desplazamiento horizontal
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Scroll de desplazamiento vertical
        
        // titulo  para la tabla
        TitledBorder tituloNombre = BorderFactory.createTitledBorder("Biblioteca de Locuciones");
        tituloNombre.setTitleColor(lila);
        tituloNombre.setTitleFont(tipoLetra);

        // Establecer el borde con el título al JScrollPane
        scrollPane.setBorder(tituloNombre);
        
        // agregamos el JScrollPane al panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

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

	public DefaultTableModel getGestorTabla() {
		return gestorTabla;
	}

	public void setGestorTabla(DefaultTableModel gestorTabla) {
		this.gestorTabla = gestorTabla;
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
