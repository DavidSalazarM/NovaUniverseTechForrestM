package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaModificar extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelModificar panelModificar;
	private PanelModificarComercial panelModificarComercial;
	private PanelModificarLocucion panelModificarLocucion;
	
	
    public VentanaModificar(PanelModificar panel) {
    	panelModificar = panel;
        configurarVentana();
        add(panel);
    }


    public VentanaModificar(PanelModificarComercial panelComercial) {
        this.panelModificarComercial = panelComercial;
        configurarVentana();
        add(panelComercial);
    }

    public VentanaModificar(PanelModificarLocucion panelLocucion) {
        this.panelModificarLocucion = panelLocucion; 
        configurarVentana();
        add(panelLocucion); 
    }
	
    private void configurarVentana() {
		setTitle("Modificar");
        setSize(400, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Color arandanoClaro = new Color(122, 122, 194, 255);
        setBackground(arandanoClaro);
        setResizable(false);
    }



	public PanelModificar getPanelModificar() {
		return panelModificar;
	}


	public void setPanelModificar(PanelModificar panelModificar) {
		this.panelModificar = panelModificar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public PanelModificarComercial getPanelModificarComercial() {
		return panelModificarComercial;
	}


	public void setPanelModificarComercial(PanelModificarComercial panelModificarComercial) {
		this.panelModificarComercial = panelModificarComercial;
	}


	public PanelModificarLocucion getPanelModificarLocucion() {
		return panelModificarLocucion;
	}


	public void setPanelModificarLocucion(PanelModificarLocucion panelModificarLocucion) {
		this.panelModificarLocucion = panelModificarLocucion;
	}
	
	
}
