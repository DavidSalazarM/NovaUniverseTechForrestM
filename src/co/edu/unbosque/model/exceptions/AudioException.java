package co.edu.unbosque.model.exceptions;

public class AudioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AudioException() {
		super("El archivo selecciónado no es .mp3");
	}

}
