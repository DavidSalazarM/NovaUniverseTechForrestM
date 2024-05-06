package co.edu.unbosque.model.persistencia;

import java.io.Serializable;

import co.edu.unbosque.model.Audios;

public class ComercialDTO  extends Audios implements Serializable{



	private static final long serialVersionUID = 1L;
	
	
	public ComercialDTO(String nombre, String artista, String genero, String url) {
		super(nombre, artista, genero, url);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ComercialDTO [nombre=" + nombre + ", Tipo=" + genero + ", Empresa=" + artista + ", url=" + url + "]";
	}
	
	public String getNombre() {
		return super.nombre;
	}

	public void setNombre(String nombre) {
		super.nombre = nombre;
	}

	public String getGenero() {
		return super.genero;
	}

	public void setGenero(String genero) {
		super.genero = genero;
	}

	public String getDuración() {
		return super.duración;
	}

	public void setDuración(String duración) {
		super.duración = duración;
	}

	public String getArtista() {
		return super.artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getUrl() {
		return super.url;
	}



public void setUrl(String url) {
	super.url = url;
}
	

}
