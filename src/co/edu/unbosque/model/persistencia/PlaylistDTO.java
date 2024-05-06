package co.edu.unbosque.model.persistencia;

import java.io.Serializable;
import java.util.ArrayList;

public class PlaylistDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Object> listaAudios;
	
	

	public PlaylistDTO(ArrayList<Object> array) {
		this.listaAudios = array;
	}

	@Override
	public String toString() {
		return "PlaylistDTO [listaAudios=" + listaAudios + "]";
	}

	public ArrayList<Object> getListaAudios() {
		return listaAudios;
	}

	public void setListaAudios(ArrayList<Object> listaAudios) {
		this.listaAudios = listaAudios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
