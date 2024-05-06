package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelOeste extends JPanel {
	private static final long serialVersionUID = 1L;
	PanelOesteAbajo panelOesteAbajo;
	PanelOesteArriba panelOesteArriba;

	public PanelOeste() {
		
// para dividir
		setLayout(new GridLayout(2, 1));
		
		Color rosita = new Color(246,212,210,255);
		 Color morado = new Color(73,39,74,255);
		 Color lila = new Color(148,97,142,255);

// para el borde
		setBackground(lila);
		Border borde = BorderFactory.createLineBorder(lila, 2);
		//setBorder(BorderFactory.createLineBorder(lila, 2));
		setPreferredSize(new Dimension(200, 20)); 

// Crear subpaneles
		panelOesteArriba = new PanelOesteArriba();
		panelOesteAbajo = new PanelOesteAbajo();
//Color de los sub-paneles
		panelOesteArriba.setBackground(lila);
		panelOesteAbajo.setBackground(lila);
//para el borde
		panelOesteAbajo.setBorder(borde);
		panelOesteArriba.setBorder(borde);

// Agregar subpaneles al panelOeste
		add(panelOesteArriba, BorderLayout.NORTH);
		add(panelOesteAbajo, BorderLayout.CENTER);
	}
	public PanelOesteAbajo getPanelOesteAbajo() {
		return panelOesteAbajo;
	}

	public void setPanelOesteAbajo(PanelOesteAbajo panelOesteAbajo) {
		this.panelOesteAbajo = panelOesteAbajo;
	}

	public PanelOesteArriba getPanelOesteArriba() {
		return panelOesteArriba;
	}

	public void setPanelOesteArriba(PanelOesteArriba panelOesteArriba) {
		this.panelOesteArriba = panelOesteArriba;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}