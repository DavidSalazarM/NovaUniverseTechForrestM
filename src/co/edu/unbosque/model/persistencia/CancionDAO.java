package co.edu.unbosque.model.persistencia;


import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.Clasificable;


public class CancionDAO implements Clasificable  {

	private ArrayList<CancionDTO> cancion;
	private BinariosFile binario = new BinariosFile();
	private Propiedades prop;
	private String[] pop=new String[0];
	private String[] bachata=new String[0];
	private String[] balada=new String[0];
	private String[] regueton=new String[0];
	private String[] vallenato=new String[0];
	private String[] rock=new String[0];
	private String[] danceElectro=new String[0];
	private String[] clasica=new String[0];
	private String[] salsa=new String[0];
	private String[] otros=new String[0];

	public CancionDAO() {

		cancion = new ArrayList<CancionDTO>();
		prop= new Propiedades();

	}

	public void agregarCancion(CancionDTO lista) {
		if (!binario.verificar(1)) {
			cancion.add(lista);
			binario.escribirCancion(cancion);

		} else {

			cancion = binario.leerCancion();
			cancion.add(lista);
			binario.escribirCancion(cancion);

		}

	}

    public String leerCancions() {
		if (!binario.verificar(1)) {
			return "No hay canciones guardadas";

		} else {
			cancion = binario.leerCancion();
			return "Se leyo correctamente";
			

		}
    }

	public void modificarCancion(int indice, CancionDTO can) {
		leerCancions();
		cancion.set(indice, can);
		binario.escribirCancion(cancion);
		

	}
	
public String buscarRuta(int indice) {
	leerCancions();
	String ruta= cancion.get(indice).getUrl();
	return ruta;
}

	public void borrarCancion(int indice) {
		leerCancions();
		cancion.remove(indice);
		binario.escribirCancion(cancion);
	}

	
	@Override
	public void clasificar() {
		boolean error= prop.leerPropiedades(1);
		int cantidad= prop.getLinea().length;
		if (error) {
			for(int i=0; i<cantidad;i++) {
				String[] genero= prop.getLinea();
				String clave=genero[i]; 
				String[] claveParte= clave.split("-");
				
				switch (claveParte[2].toUpperCase()) {
				case "POP": {
					pop= Arrays.copyOf(pop, pop.length+1);
					pop[pop.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
			   }
				case "BACHATA":{
					bachata= Arrays.copyOf(bachata, bachata.length+1);
					bachata[bachata.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "BALADA":{
					balada= Arrays.copyOf(balada, balada.length+1);
					balada[balada.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "REGUETON":{
					regueton= Arrays.copyOf(regueton, regueton.length+1);
					regueton[regueton.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "CLASICA":{
					clasica= Arrays.copyOf(clasica, clasica.length+1);
					clasica[clasica.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "VALLENATO":{
					vallenato= Arrays.copyOf(vallenato, vallenato.length+1);
					vallenato[vallenato.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "ROCK":{
					rock= Arrays.copyOf(rock, rock.length+1);
					rock[rock.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "SALSA":{
					salsa= Arrays.copyOf(salsa, salsa.length+1);
					salsa[salsa.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "DANCE/ELECTRO":{
					danceElectro= Arrays.copyOf(danceElectro, danceElectro.length+1);
					danceElectro[danceElectro.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				case "OTROS":{
					otros= Arrays.copyOf(otros, otros.length+1);
					otros[otros.length-1]=claveParte[0]+"-"+claveParte[1];
					break;
					
				}
				

			}
			}
		}
		
		
	
		
		
	}
	
	
	public ArrayList<CancionDTO> getCancion() {
		return cancion;
	}

	public void setCancion(ArrayList<CancionDTO> cancion) {
		this.cancion = cancion;
	}

	public BinariosFile getBinario() {
		return binario;
	}

	public void setBinario(BinariosFile binario) {
		this.binario = binario;
	}

	public Propiedades getProp() {
		return prop;
	}

	public void setProp(Propiedades prop) {
		this.prop = prop;
	}

	public String[] getPop() {
		return pop;
	}

	public void setPop(String[] pop) {
		this.pop = pop;
	}

	public String[] getBachata() {
		return bachata;
	}

	public void setBachata(String[] bachata) {
		this.bachata = bachata;
	}

	public String[] getBalada() {
		return balada;
	}

	public void setBalada(String[] balada) {
		this.balada = balada;
	}

	public String[] getRegueton() {
		return regueton;
	}

	public void setRegueton(String[] regueton) {
		this.regueton = regueton;
	}

	public String[] getVallenato() {
		return vallenato;
	}

	public void setVallenato(String[] vallenato) {
		this.vallenato = vallenato;
	}

	public String[] getRock() {
		return rock;
	}

	public void setRock(String[] rock) {
		this.rock = rock;
	}

	public String[] getDanceElectro() {
		return danceElectro;
	}

	public void setDanceElectro(String[] danceElectro) {
		this.danceElectro = danceElectro;
	}

	public String[] getClasica() {
		return clasica;
	}

	public void setClasica(String[] clasica) {
		this.clasica = clasica;
	}



	public String[] getSalsa() {
		return salsa;
	}

	public void setSalsa(String[] salsa) {
		this.salsa = salsa;
	}

	public String[] getOtros() {
		return otros;
	}

	public void setOtros(String[] otros) {
		this.otros = otros;
	}

	





}
