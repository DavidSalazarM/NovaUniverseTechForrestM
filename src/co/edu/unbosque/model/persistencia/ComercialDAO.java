package co.edu.unbosque.model.persistencia;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.Clasificable;

public class ComercialDAO  implements Clasificable{
	
	private ArrayList<ComercialDTO> comercial;
	private BinariosFile binario = new BinariosFile();
	private Propiedades propiedades;
	
	private String[] alimentos=new String[0];
	private String[] musica=new String[0];
	private String[] aseo=new String[0];
	private String[] higienePersonal=new String[0];
	private String[] productosFinacieros=new String[0];
	private String[] otros=new String[0];
	
	public ComercialDAO() {
		comercial= new ArrayList<ComercialDTO>();
		propiedades= new Propiedades();
	}
	
	public void agregarComercial(ComercialDTO lista) {
		if (!binario.verificar(3)) {
			comercial.add(lista);
			binario.escribirComercial(comercial);

		} else {

			comercial = binario.leerComercial();
			comercial.add(lista);
			binario.escribirComercial(comercial);

		}

	}

    public String leerComercial() {
		if (!binario.verificar(3)) {
			return "No hay canciones guardadas";

		} else {
			comercial = binario.leerComercial();
			return "Se leyo correctamente";
			

		}
    }

	public void modificarCancion(int indice, ComercialDTO can) {
		leerComercial();
		comercial.set(indice, can);
		binario.escribirComercial(comercial);
		

	}

	public void borrarCancion(int indice) {
		leerComercial();
		comercial.remove(indice);
		binario.escribirComercial(comercial);
	}
	
	public String buscarRuta(int indice) {
		leerComercial();
		String ruta= comercial.get(indice).getUrl();
		return ruta;
	}
	
	@Override
	public void clasificar() {
		boolean error= propiedades.leerPropiedades(3);
		int cantidad= propiedades.getLinea().length;
		if (error) {
			for(int i=0; i<cantidad;i++) {
				String[] genero= propiedades.getLinea();
				String clave=genero[i]; 
				String[] claveParte= clave.split(";");
				
				switch (claveParte[2].toUpperCase()) {
				case"ALIMENTOS":
					alimentos= Arrays.copyOf(alimentos, alimentos.length+1);
					alimentos[alimentos.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
				
				case"MUSICA":
					musica= Arrays.copyOf(musica, musica.length+1);
					musica[musica.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case"ASEO":
					aseo= Arrays.copyOf(aseo, aseo.length+1);
					aseo[aseo.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case"HIGIENEPERSONAL":
					higienePersonal= Arrays.copyOf(higienePersonal, higienePersonal.length+1);
					higienePersonal[higienePersonal.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case"PRODUCTOFINACIEROS":
					productosFinacieros= Arrays.copyOf(productosFinacieros, productosFinacieros.length+1);
					productosFinacieros[productosFinacieros.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				case"OTROS":
					otros= Arrays.copyOf(otros, otros.length+1);
					otros[otros.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
				
					
					
				}
		}
		}
		
	}

	public ArrayList<ComercialDTO> getComercial() {
		return comercial;
	}

	public void setComercial(ArrayList<ComercialDTO> comercial) {
		this.comercial = comercial;
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

	public String[] getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(String[] alimentos) {
		this.alimentos = alimentos;
	}

	public String[] getMusica() {
		return musica;
	}

	public void setMusica(String[] musica) {
		this.musica = musica;
	}

	public String[] getAseo() {
		return aseo;
	}

	public void setAseo(String[] aseo) {
		this.aseo = aseo;
	}

	public String[] getHigienePersonal() {
		return higienePersonal;
	}

	public void setHigienePersonal(String[] higienePersonal) {
		this.higienePersonal = higienePersonal;
	}

	public String[] getProductosFinacieros() {
		return productosFinacieros;
	}

	public void setProductosFinacieros(String[] productosFinacieros) {
		this.productosFinacieros = productosFinacieros;
	}

	public String[] getOtros() {
		return otros;
	}

	public void setOtros(String[] otros) {
		this.otros = otros;
	}

}
