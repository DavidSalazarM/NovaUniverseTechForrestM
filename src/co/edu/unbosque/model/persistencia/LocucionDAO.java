package co.edu.unbosque.model.persistencia;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.Clasificable;

public class LocucionDAO implements Clasificable{
	
	private ArrayList<LocucionDTO> pCast;
	private BinariosFile binario= new BinariosFile();
	private Propiedades propiedades;
	private String[] humor=new String[0];
	private String[] historia=new String[0];;
	private String[] noticia=new String[0];;
	private String[] chisme=new String[0];;
	private String[] otros=new String[0];;
	

	
	public LocucionDAO(){
		pCast=new ArrayList<LocucionDTO>();
		propiedades= new Propiedades();
		
	}
	
	@Override
	public void clasificar() {
		boolean error= propiedades.leerPropiedades(2);
		int cantidad= propiedades.getLinea().length;
		if(error) {
			for(int i=0; i<cantidad;i++) {
				String[] genero= propiedades.getLinea();
				String clave=genero[i]; 
				String[] claveParte= clave.split(";");
				
				switch (claveParte[2].toUpperCase()) {
				case"HUMOR":
					humor= Arrays.copyOf(humor, humor.length+1);
					humor[humor.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case "HISTORIA":
					historia= Arrays.copyOf(historia, historia.length+1);
					historia[historia.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case "NOTICIA":
					noticia= Arrays.copyOf(noticia, noticia.length+1);
					noticia[noticia.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
				
				
				case "CHISME":
					chisme= Arrays.copyOf(chisme, chisme.length+1);
					chisme[chisme.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case "OTROS":
					otros= Arrays.copyOf(otros, otros.length+1);
					otros[otros.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
				}
		}
		}
			
		
	}
	
	public void agregarPodscast(LocucionDTO lista) {
		if (!binario.verificar(2)) {
			pCast.add(lista);
			binario.escribirPodscast(pCast);

		} else {

			pCast = binario.leerPodscast();
			pCast.add(lista);
			binario.escribirPodscast(pCast);

		}

	}

    public String leerPodscast() {
		if (!binario.verificar(2)) {
			return "No hay canciones guardadas";

		} else {
			pCast = binario.leerPodscast();
			return "Se leyo correctamente";
			

		}
    }

	public void modificarPodscast(int indice, LocucionDTO can) {
		leerPodscast();
		pCast.set(indice, can);
		binario.escribirPodscast(pCast);
		

	}
	public String buscarRuta(int indice) {
		leerPodscast();
		String ruta= pCast.get(indice).getUrl();
		return ruta;
	}

	public void borrarPodscast(int indice) {
		leerPodscast();
		pCast.remove(indice);
		binario.escribirPodscast(pCast);
	}

	public ArrayList<LocucionDTO> getpCast() {
		return pCast;
	}

	public void setpCast(ArrayList<LocucionDTO> pCast) {
		this.pCast = pCast;
	}

	public BinariosFile getBinario() {
		return binario;
	}

	public void setBinario(BinariosFile binario) {
		this.binario = binario;
	}

	public Propiedades getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	public String[] getHumor() {
		return humor;
	}

	public void setHumor(String[] humor) {
		this.humor = humor;
	}

	public String[] getHistoria() {
		return historia;
	}

	public void setHistoria(String[] historia) {
		this.historia = historia;
	}

	public String[] getNoticia() {
		return noticia;
	}

	public void setNoticia(String[] noticia) {
		this.noticia = noticia;
	}

	public String[] getChisme() {
		return chisme;
	}

	public void setChisme(String[] chisme) {
		this.chisme = chisme;
	}

	public String[] getOtros() {
		return otros;
	}

	public void setOtros(String[] otros) {
		this.otros = otros;
	}


}