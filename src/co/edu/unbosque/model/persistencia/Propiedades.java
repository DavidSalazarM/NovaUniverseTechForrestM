package co.edu.unbosque.model.persistencia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Propiedades {
	
	private Properties propiedades= new Properties();
	private String rutaCanciones=".\\data\\canciones.properties";
    private String rutaPodscast=".\\data\\podscasts.properties";
    private String rutaComercial=".\\data\\comerciales.properties";
    private String rutaPlaylist=".\\data\\playlist.properties";
	private String[] linea;
	private String[] lineaComercial;
	private String[] lineaLocucion;
	private String[] lineaPlaylist;
	
	
	

	
	public boolean escribirPropiedades(String clave,String nombre,String artista,String genero, int ruta) {
		
		try {
			 propiedades.setProperty(clave, nombre+"-"+artista+"-"+genero);
		        if (ruta == 1) {
		            propiedades.store(new FileOutputStream(rutaCanciones), null);
		        } else if (ruta == 2) {
		            propiedades.store(new FileOutputStream(rutaPodscast), null);
		        } else if (ruta == 3) {
		            propiedades.store(new FileOutputStream(rutaComercial), null);
		        }
			 

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean escribirPropiedadesPlaylist(String clave,String nombre,String artista,String genero){
        try {
        	propiedades.setProperty(clave, nombre+"-"+artista+"-"+genero);
			propiedades.store(new FileOutputStream(rutaPlaylist), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
        
	}
	public boolean leerPropiedadesPlaylist(){
		
		try {lineaPlaylist=new String[0];
		String archivo = rutaPlaylist;
			propiedades.load(new FileInputStream(archivo));
			List<String> listaValores = new ArrayList<>();
	        for (String clave : propiedades.stringPropertyNames()) {
	            String valor = propiedades.getProperty(clave);
	            listaValores.add(valor);}
	        propiedades.clear();
	        lineaPlaylist = listaValores.toArray(new String[0]);
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return true;
	}
	
	public boolean leerPropiedades(int ruta) {
		linea=new String[0];
		lineaComercial=new String[0];
		lineaLocucion=new String[0];
		
	    try {
	        String archivo;
	        switch (ruta) {
	            case 1:
	                archivo = rutaCanciones;
	                break;
	            case 2:
	                archivo = rutaPodscast;
	                break;
	            case 3:
	                archivo = rutaComercial;
	                
	                break;
	            default:
	                // Si la ruta no es válida, retornar false
	                return false;
	        }

	        propiedades.load(new FileInputStream(archivo));
	        
	        // Crear una lista para almacenar los valores
	        List<String> listaValores = new ArrayList<>();

	        // Recorrer las propiedades y almacenar los valores en la lista
	        for (String clave : propiedades.stringPropertyNames()) {
	            String valor = propiedades.getProperty(clave);
	            listaValores.add(valor);
	            
	            
	        }propiedades.clear();

	        // Convertir la lista a un array de cadenas
	        switch (ruta) {
	            case 1:
	                linea = listaValores.toArray(new String[0]);
	                break;
	            case 2:
	                lineaLocucion = listaValores.toArray(new String[0]);
	               
	                break;
	            case 3:
	                lineaComercial = listaValores.toArray(new String[0]);
	                break;
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	public String buscarClaveCancionPlaylist(String lista){
		 try {
			propiedades.load(new FileInputStream(rutaPlaylist));
	        for (String clave : propiedades.stringPropertyNames()) {
	            String valor = propiedades.getProperty(clave);
	            if (valor.toLowerCase().contains(lista.toLowerCase())) {
	                return clave; // devuelve clave 
	            }
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null; 
	}
	
	public String buscarClaveCancion(String cancion, int ruta) {
	    try {
	    	 if (ruta == 1) {
		            propiedades.load(new FileInputStream(rutaCanciones));
		        } else if (ruta == 2) {
		            propiedades.load(new FileInputStream(rutaPodscast));
		        } else if (ruta == 3) {
		            propiedades.load(new FileInputStream(rutaComercial));
		        } 


	        // Buscar la clave correspondiente a la canción
	        for (String clave : propiedades.stringPropertyNames()) {
	            String valor = propiedades.getProperty(clave);
	            if (valor.toLowerCase().contains(cancion.toLowerCase())) {
	                return clave; // devuelve clave 
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null; 
	}


	public String[] getLinea() {
		return linea;
	}

	public void setLinea(String[] linea) {
		this.linea = linea;
	}

	public Properties getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public String getRutaCanciones() {
		return rutaCanciones;
	}

	public void setRutaCanciones(String rutaCanciones) {
		this.rutaCanciones = rutaCanciones;
	}

	public String getRutaPodscast() {
		return rutaPodscast;
	}

	public void setRutaPodscast(String rutaPodscast) {
		this.rutaPodscast = rutaPodscast;
	}

	public String getRutaComercial() {
		return rutaComercial;
	}

	public void setRutaComercial(String rutaComercial) {
		this.rutaComercial = rutaComercial;
	}

	public String[] getLineaComercial() {
		return lineaComercial;
	}

	public void setLineaComercial(String[] lineaComercial) {
		this.lineaComercial = lineaComercial;
	}

	public String[] getLineaLocucion() {
		return lineaLocucion;
	}

	public void setLineaLocucion(String[] lineaLocucion) {
		this.lineaLocucion = lineaLocucion;
	}

	public String[] getLineaPlaylist() {
		return lineaPlaylist;
	}

	public void setLineaPlaylist(String[] lineaPlaylist) {
		this.lineaPlaylist = lineaPlaylist;
	}

	
	
}
