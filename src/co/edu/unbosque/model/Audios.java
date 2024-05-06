package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Audios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String genero;
	protected String artista;
	protected String url;
	protected String duración;
	
	public Audios(String nombre , String artista,String genero,String url){
		this.nombre= nombre;
		this.artista=artista;
		this.genero= genero;
		this.url=url;

	}
	
	

	






 
 

}


