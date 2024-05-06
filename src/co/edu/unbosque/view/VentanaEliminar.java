package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;

public class VentanaEliminar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelEliminar panelEliminarCancion;
	private PanelEliminarComercial panelEliminarComercial;
	private PanelEliminarLocucion panelEliminarLocucion;
    public VentanaEliminar(PanelEliminar panel) {
    	panelEliminarCancion = panel;
        configurarVentana();
        add(panelEliminarCancion);
    }


    public VentanaEliminar(PanelEliminarComercial panelComercial) {
        this.panelEliminarComercial = panelComercial;
        configurarVentana();
        add(panelComercial);
    }

    public VentanaEliminar(PanelEliminarLocucion panelLocucion) {
        this.panelEliminarLocucion = panelLocucion; 
        configurarVentana();
        add(panelLocucion); 
    }
	    private void configurarVentana() {
	        setTitle("Eliminar");
	        setSize(400, 500);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        Color arandanoClaro = new Color(122, 122, 194, 255);
	        setBackground(arandanoClaro);
	        setResizable(false);
	    
	    }


		public PanelEliminar getPanelEliminarCancion() {
			return panelEliminarCancion;
		}


		public void setPanelEliminarCancion(PanelEliminar panelEliminarCancion) {
			this.panelEliminarCancion = panelEliminarCancion;
		}


		public PanelEliminarComercial getPanelEliminarComercial() {
			return panelEliminarComercial;
		}


		public void setPanelEliminarComercial(PanelEliminarComercial panelEliminarComercial) {
			this.panelEliminarComercial = panelEliminarComercial;
		}


		public PanelEliminarLocucion getPanelEliminarLocucion() {
			return panelEliminarLocucion;
		}


		public void setPanelEliminarLocucion(PanelEliminarLocucion panelEliminarLocucion) {
			this.panelEliminarLocucion = panelEliminarLocucion;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    

	
	

}
