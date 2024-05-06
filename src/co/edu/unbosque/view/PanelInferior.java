package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class PanelInferior extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton butAdelante, butPausar,butPlay,tipoTrasmision;
	private JLabel modotrasmision;
	private String tituloTrasmision;
	
	private static final String ADELANTE= "Adelante";
	private static final String PAUSAR= "pausar";
	private static final String PLAY= "Play";
	
	public PanelInferior(){
		
		JPanel panelInferior = new JPanel();

		Color morado = new Color(73, 39, 74, 255);
		Color rosita = new Color(246, 212, 210, 255);
		Font fuenteLetra = new Font("Times New Roman", Font.ITALIC, 16);
		setBackground(morado);
		setBorder(BorderFactory.createLineBorder(morado, 2));
		setPreferredSize(new Dimension(750, 50));

		// botones
		butAdelante = new JButton("Adelante");
		butAdelante.setBackground(rosita);
		butAdelante.setActionCommand(ADELANTE);


		butPlay = new JButton("Play");
		butPlay.setBackground(rosita);
		butPlay.setActionCommand(PLAY);


		tipoTrasmision = new JButton("Modo Trasmisión");
		tipoTrasmision.setBackground(rosita);
		tipoTrasmision.setFont(fuenteLetra);
		tipoTrasmision.setForeground(morado);
		tipoTrasmision.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));




		panelInferior.add(butAdelante);
		panelInferior.add(butPlay);
		
		panelInferior.add(tipoTrasmision);
		add(panelInferior);

	}


	public JButton getButAdelante() {
		return butAdelante;
	}

	public void setButAdelante(JButton butAdelante) {
		this.butAdelante = butAdelante;
	}





	public JButton getButPausar() {
		return butPausar;
	}


	public void setButPausar(JButton butPausar) {
		this.butPausar = butPausar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static String getPausar() {
		return PAUSAR;
	}


	public JButton getButPlay() {
		return butPlay;
	}




	public void setButPlay(JButton butPlay) {
		this.butPlay = butPlay;
	}

	public static String getAdelante() {
		return ADELANTE;
	}

	public static String getAtras() {
		return PAUSAR;
	}

	public static String getPlay() {
		return PLAY;
	}


	public JButton getTipoTrasmision() {
		return tipoTrasmision;
	}


	public void setTipoTrasmision(JButton tipoTrasmision) {
		this.tipoTrasmision = tipoTrasmision;
	}



	
}
