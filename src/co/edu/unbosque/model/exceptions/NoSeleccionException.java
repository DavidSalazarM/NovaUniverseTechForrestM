package co.edu.unbosque.model.exceptions;

public class NoSeleccionException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSeleccionException() {
		super("No se ha seleccionado ningún archivo");
	}

}
