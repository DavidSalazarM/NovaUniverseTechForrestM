package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanelInferior panelInferior;
	private PanelCentral panelCentral;
	private PanelSuperior panelSuperior;
	private PanelEste panelEste;
    private PanelOeste panelOeste;
    
    public VentanaPrincipal() {
		setTitle("Inicio");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Color arandanoClaro = new Color(122, 122, 194, 255);
        setBackground(arandanoClaro);
        setResizable(false);

        // Crear los paneles
        panelInferior = new PanelInferior();
        panelCentral = new PanelCentral();
        panelSuperior = new PanelSuperior();
        panelEste = new PanelEste();
        panelOeste = new PanelOeste();
       
        setJMenuBar(panelSuperior.getMenuBar());
 



        //setLayout(new GridLayout(2, 3));
        // Establecer layout de la ventana principal
        setLayout(new BorderLayout());

        // Agregar paneles a la ventana principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelEste, BorderLayout.EAST);
        add(panelOeste, BorderLayout.WEST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
        
        
    }
    
    
    
    
    
    
    
    
	public PanelInferior getPanelInferior() {
		return panelInferior;
	}
	public void setPanelInferior(PanelInferior panelInferior) {
		this.panelInferior = panelInferior;
	}
	public PanelCentral getPanelCentral() {
		return panelCentral;
	}
	public void setPanelCentral(PanelCentral panelCentral) {
		this.panelCentral = panelCentral;
	}
	public PanelSuperior getPanelSuperior() {
		return panelSuperior;
	}
	public void setPanelSuperior(PanelSuperior panelSuperior) {
		this.panelSuperior = panelSuperior;
	}
	public PanelEste getPanelEste() {
		return panelEste;
	}
	public void setPanelEste(PanelEste panelEste) {
		this.panelEste = panelEste;
	}
	public PanelOeste getPanelOeste() {
		return panelOeste;
	}
	public void setPanelOeste(PanelOeste panelOeste) {
		this.panelOeste = panelOeste;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    

}
