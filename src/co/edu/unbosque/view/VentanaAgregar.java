package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAgregar extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanelAMCancion panelCancion;
	private PanelAgregarComercial panelComercial;
	private PanelAgregarLocucion panelLocucion;
    private JPanel panel;
	
    public VentanaAgregar(PanelAMCancion panel) {
        panelCancion = panel;
        configurarVentana();
        add(panelCancion);
    }


    public VentanaAgregar(PanelAgregarComercial panelComercial) {
        this.panelComercial = panelComercial;
        configurarVentana();
        add(this.panelComercial);
    }

    public VentanaAgregar(PanelAgregarLocucion panelLocucion) {
        this.panelLocucion = panelLocucion; 
        configurarVentana();
        add(this.panelLocucion); 
    }
	    private void configurarVentana() {
	        setTitle("Agregar");
	        setSize(400, 500);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        Color arandanoClaro = new Color(122, 122, 194, 255);
	        setBackground(arandanoClaro);
	        setResizable(false);
	    }
	
	

	public PanelAMCancion getPanelCancion() {
		return panelCancion;
	}

	public void setPanelCancion(PanelAMCancion panelCancion) {
		this.panelCancion = panelCancion;
	}

	public PanelAgregarComercial getPanelComercial() {
		return panelComercial;
	}

	public void setPanelComercial(PanelAgregarComercial panelComercial) {
		this.panelComercial = panelComercial;
	}


	public PanelAgregarLocucion getPanelLocucion() {
		return panelLocucion;
	}


	public void setPanelLocucion(PanelAgregarLocucion panelLocucion) {
		this.panelLocucion = panelLocucion;
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
