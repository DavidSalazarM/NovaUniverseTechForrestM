package co.edu.unbosque.model;

import co.edu.unbosque.model.persistencia.BinariosFile;
import co.edu.unbosque.model.persistencia.CancionDAO;
import co.edu.unbosque.model.persistencia.CancionDTO;
import co.edu.unbosque.model.persistencia.ComercialDAO;
import co.edu.unbosque.model.persistencia.ComercialDTO;
import co.edu.unbosque.model.persistencia.LocucionDAO;
import co.edu.unbosque.model.persistencia.LocucionDTO;
import co.edu.unbosque.model.persistencia.PlaylistDAO;
import co.edu.unbosque.model.persistencia.PlaylistDTO;
import co.edu.unbosque.model.persistencia.Propiedades;

public class Fachada {
	private CancionDAO cancion;
	private Propiedades propiedades;
	private ComercialDAO comercial;
	private LocucionDAO podscast;
	private BinariosFile binarios;
	private PlaylistDAO playlist;

public  Fachada() {
	// TODO Auto-generated constructor stub

	cancion= new CancionDAO();
	propiedades=new Propiedades();
	comercial= new ComercialDAO();
	podscast= new LocucionDAO();
	binarios= new BinariosFile();
	setPlaylist(new PlaylistDAO());
	
}
	
public void crearPropiedadesCanciones() {
	 cancion.leerCancions();
		for(int i=0;i<cancion.getCancion().size();i++) {
			CancionDTO array= cancion.getCancion().get(i);
			String clave=String.valueOf(i);
			propiedades.escribirPropiedades(clave, array.getNombre(),array.getArtista(),array.getGenero(), 1);
		}
}
public void crearPropiedadesPodscast() {
	podscast.leerPodscast();
		for(int i=0;i<podscast.getpCast().size();i++) {
			LocucionDTO array= podscast.getpCast().get(i);
			String clave=String.valueOf(i);
			propiedades.escribirPropiedades(clave, array.getNombre(),array.getArtista(),array.getGenero(), 2);
		}
}

public void crearPropiedadesComercial() {
	comercial.leerComercial(); 
		for(int i=0;i<comercial.getComercial().size();i++) {
			ComercialDTO array= comercial.getComercial().get(i);
			String clave=String.valueOf(i);
			propiedades.escribirPropiedades(clave, array.getNombre(),array.getArtista(),array.getGenero(), 3);
		}
}



public void crearPropiedadesPlaylist(){
	playlist.leerPlaylist();
	try{
	PlaylistDTO array = playlist.getListaPlaylis().get(playlist.getListaPlaylis().size()-1);
	for(int i=0; i< array.getListaAudios().size();i++ ){
		Object objeto = array.getListaAudios().get(i);
		String clave=String.valueOf(i);
		
		  if (objeto instanceof CancionDTO) {
		        
			  CancionDTO audio = (CancionDTO) objeto;
			  propiedades.escribirPropiedadesPlaylist(clave, audio.getNombre(),audio.getArtista(),audio.getGenero());
		    }
		  if (objeto instanceof ComercialDTO) {
		        
			  ComercialDTO audio = (ComercialDTO) objeto;
			  propiedades.escribirPropiedadesPlaylist(clave, audio.getNombre(),audio.getArtista(),audio.getGenero());
		    }
		  if (objeto instanceof LocucionDTO) {
		        
			  LocucionDTO audio = (LocucionDTO) objeto;
			  propiedades.escribirPropiedadesPlaylist(clave, audio.getNombre(),audio.getArtista(),audio.getGenero());
		    }
	}}catch (Exception e) {
		
	}
}


public CancionDAO getCancion() {
	return cancion;
}

public void setCancion(CancionDAO cancion) {
	this.cancion = cancion;
}

public Propiedades getPropiedades() {
	return propiedades;
}

public void setPropiedades(Propiedades propiedades) {
	this.propiedades = propiedades;
}

public ComercialDAO getComercial() {
	return comercial;
}

public void setComercial(ComercialDAO comercial) {
	this.comercial = comercial;
}

public LocucionDAO getPodscast() {
	return podscast;
}

public void setPodscast(LocucionDAO podscast) {
	this.podscast = podscast;
}

public BinariosFile getBinarios() {
	return binarios;
}

public void setBinarios(BinariosFile binarios) {
	this.binarios = binarios;
}

public PlaylistDAO getPlaylist() {
	return playlist;
}

public void setPlaylist(PlaylistDAO playlist) {
	this.playlist = playlist;
}


	

}
