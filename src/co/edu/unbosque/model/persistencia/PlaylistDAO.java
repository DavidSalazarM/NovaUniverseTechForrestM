package co.edu.unbosque.model.persistencia;


import java.util.ArrayList;

public class PlaylistDAO {
	
	private ArrayList<PlaylistDTO> listaPlaylis;
	private BinariosFile binario;
	
	public PlaylistDAO() {
		listaPlaylis= new ArrayList<PlaylistDTO>();
		binario= new BinariosFile();
		
	}
	
	public void agregarPlaylist(PlaylistDTO lista) {
		if (!binario.verificar(4)) {
			listaPlaylis.add(lista);
			binario.escribirPlaylist(listaPlaylis);

		} else {

			listaPlaylis = binario.leerPlaylist();
			listaPlaylis.add(lista);
			binario.escribirPlaylist(listaPlaylis);
			binario.leerPlaylist();

		}
		
	}
	
	public String leerPlaylist() {
		if (!binario.verificar(4)) {
			return "No hay canciones guardadas";

		} else {
			listaPlaylis = binario.leerPlaylist();
			return "Se leyo correctamente";
			

		}
		
	}
	
	public void modificarePlaylist(int indice, PlaylistDTO playdto) {
		leerPlaylist();
		listaPlaylis.set(indice, playdto);
		binario.escribirPlaylist(listaPlaylis);
	}
	
	public void borrarCancion(int indice) {
		leerPlaylist();
		listaPlaylis.remove(indice);
		binario.escribirPlaylist(listaPlaylis);
	}

	public ArrayList<PlaylistDTO> getListaPlaylis() {
		return listaPlaylis;
	}

	public void setListaPlaylis(ArrayList<PlaylistDTO> listaPlaylis) {
		this.listaPlaylis = listaPlaylis;
	}

	public BinariosFile getBinario() {
		return binario;
	}

	public void setBinario(BinariosFile binario) {
		this.binario = binario;
	}
	
	
	
	
	
	

}
