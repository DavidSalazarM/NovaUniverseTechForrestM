package co.edu.unbosque.model.persistencia;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BinariosFile {
	
	private String ruta="./data/cancion.out";
	private String rutaPodscast="./data/podscast.out";
	private String rutaComercial="./data/comercial.out";
	private String rutaPlaylist="./data/playlist.out";
	private String carpetaCanciones="./Canciones";
	private String carpetaComercial="./Comerciales";
	private String carpetaLocucion="./Locuciones";
	private String rutaFinal;
	
	private ArrayList<CancionDTO> listaCancion;
	private ArrayList<LocucionDTO>listaLocucion;
	private ArrayList<ComercialDTO>listaComercial;
	private ArrayList<PlaylistDTO> listaPlaylist;

	
	public BinariosFile() {
		listaCancion= new ArrayList<CancionDTO>();
		listaLocucion= new ArrayList<LocucionDTO>();
		listaComercial= new ArrayList<ComercialDTO>();
		listaPlaylist= new ArrayList<PlaylistDTO>();
		
		}
	
	public boolean escribirCancion(ArrayList<CancionDTO> listaCancion) {
		ObjectOutputStream escritor;
		try { 
			File archivo=new  File(ruta);
			if(archivo.exists()) {
				FileOutputStream fileOutpu= new FileOutputStream(archivo);
				escritor= new ObjectOutputStream(fileOutpu);
				escritor.writeObject(listaCancion);
				escritor.close();
			}

			
		}catch (IOException e) {
			return false;
		}
		return true;
	}
	public boolean escribirPodscast(ArrayList<LocucionDTO> listaPodscast) {
		ObjectOutputStream escritor;
		try { 
			File archivo=new  File(rutaPodscast);
			if(archivo.exists()) {
				FileOutputStream fileOutpu= new FileOutputStream(archivo);
				escritor= new ObjectOutputStream(fileOutpu);
				escritor.writeObject(listaPodscast);
				escritor.close();
			}

			
		}catch (IOException e) {
			return false;
		}
		return true;
	}
	public boolean escribirComercial(ArrayList<ComercialDTO> listaComercial) {
		ObjectOutputStream escritor;
		try { 
			File archivo=new  File(rutaComercial);
			if(archivo.exists()) {
				FileOutputStream fileOutpu= new FileOutputStream(archivo);
				escritor= new ObjectOutputStream(fileOutpu);
				escritor.writeObject(listaComercial);
				escritor.close();
			}

			
		}catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean escribirPlaylist(ArrayList<PlaylistDTO> listaPlaylist) {
		ObjectOutputStream escritor;
		try { 
			File archivo=new  File(rutaPlaylist);
			if(archivo.exists()) {
				FileOutputStream fileOutpu= new FileOutputStream(archivo);
				escritor= new ObjectOutputStream(fileOutpu);
				escritor.writeObject(listaPlaylist);
				escritor.close();
			}

			
		}catch (IOException e) {
			return false;
		}
		return true;
	}
	

	public boolean verificar(int ruta){
		BufferedReader br = null;
		try {
			if(ruta==1) {
				br = new BufferedReader(new FileReader(this.ruta));
			}
			if(ruta==2) {
				br = new BufferedReader(new FileReader(this.rutaPodscast));
			}
			if(ruta==3) {
				br = new BufferedReader(new FileReader(this.rutaComercial));
			}
			if(ruta==4) {
				br = new BufferedReader(new FileReader(this.rutaPlaylist));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		try {
			if (br.readLine() == null) {
				return false;
			    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
				}

	
	public ArrayList<CancionDTO> leerCancion() {
	    ObjectInputStream object = null;

	    try {
	        object = new ObjectInputStream(new FileInputStream(ruta));
	        

	        while (true) {
	            try {
	                listaCancion = (ArrayList<CancionDTO>) object.readObject();
	            } catch (EOFException e) {
	                break;
	            }
	        }
	        object.close();
	    } catch (Exception  e) {
	        e.printStackTrace();
	        
	    }

	    return listaCancion;
	}
	
	public ArrayList<LocucionDTO> leerPodscast() {
	    ObjectInputStream object = null;

	    try {
	        object = new ObjectInputStream(new FileInputStream(rutaPodscast));
	        

	        while (true) {
	            try {
	            	listaLocucion = (ArrayList<LocucionDTO>) object.readObject();
	            } catch (EOFException e) {
	                break;
	            }
	        }
	        object.close();
	    } catch (Exception  e) {
	        e.printStackTrace();
	        
	    }

	    return listaLocucion;
	}
	
	public ArrayList<ComercialDTO> leerComercial() {
	    ObjectInputStream object = null;

	    try {
	        object = new ObjectInputStream(new FileInputStream(rutaComercial));
	        

	        while (true) {
	            try {
	                listaComercial = (ArrayList<ComercialDTO>) object.readObject();
	            } catch (EOFException e) {
	                break;
	            }
	        }
	        object.close();
	    } catch (Exception  e) {
	        e.printStackTrace();
	        
	    }

	    return listaComercial;
	}
	
	
	public ArrayList<PlaylistDTO> leerPlaylist() {
	    ObjectInputStream object = null;

	    try {
	        object = new ObjectInputStream(new FileInputStream(rutaPlaylist));
	        

	        while (true) {
	            try {
	                listaPlaylist = (ArrayList<PlaylistDTO>) object.readObject();
	            } catch (EOFException e) {
	                break;
	            }
	        }
	        object.close();
	    } catch (Exception  e) {
	        e.printStackTrace();
	        
	    }
	   
	    return listaPlaylist;
	}


	public String guardaAudios(File mp3, int carpeta) {
		String ruta="";
		//verificar existencia de carpeta
		
		switch (carpeta) {
		case 0: 
			ruta= carpetaCanciones;
			break;
		case 1:
			ruta= carpetaComercial;
			break;
		case 2: 
			ruta= carpetaLocucion;
			break;
		}
		
		File carpetica= new File(ruta);
		if(!carpetica.exists()) {
			carpetica.mkdir();
		}
		
		// nombre del archivo mp3
		String nombreMP3= mp3.getName();
		// creamos la nueva ruta que tendra mp3
		
		rutaFinal= ruta+"/"+nombreMP3;
		
		// copia el mp3 a la carpeta
		
		File archivoDestino = new File(rutaFinal);
		int contador = 2;
		
		 while (archivoDestino.exists()) {
		        String nombreSinExtension = nombreMP3.substring(0, nombreMP3.lastIndexOf('.'));
		        String extension = nombreMP3.substring(nombreMP3.lastIndexOf('.'));
		        String nombreNuevo = nombreSinExtension + "_" + contador + extension;
		        rutaFinal = ruta + "/" + nombreNuevo;
		        archivoDestino = new File(rutaFinal);
		        contador++;
		    }
		
		try {
			FileInputStream fis= new FileInputStream(mp3);
			FileOutputStream fos = new FileOutputStream(rutaFinal);
			byte[] by= new byte[1024];
			int tamaño;
			while((tamaño= fis.read(by))>0) {
				fos.write(by,0,tamaño);
				
			}
			fos.close();
		}catch (Exception e) {
			return e.getMessage();
		}
		
		
		
		return "ok";
	}

public boolean eliminarAudio(String rutaArchivo) {
    try {
        // Obtener un objeto Path para la ruta del archivo
        Path archivoPath = Paths.get(rutaArchivo);

        // Borrar el archivo
        Files.delete(archivoPath);

        // Imprimir mensaje de éxito
        System.out.println("Archivo borrado exitosamente: " + rutaArchivo);

        return true; // Archivo borrado exitosamente
    } catch (IOException e) {
        e.printStackTrace();
        return false; // Ocurrió un error al intentar borrar el archivo
    }
}
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public ArrayList<CancionDTO> getListaCancion() {
		return listaCancion;
	}

	public void setListaCancion(ArrayList<CancionDTO> listaCancion) {
		this.listaCancion = listaCancion;
	}

	public String getRutaPodscast() {
		return rutaPodscast;
	}

	public void setRutaPodscast(String rutaPodscast) {
		this.rutaPodscast = rutaPodscast;
	}





	public ArrayList<LocucionDTO> getListaLocucion() {
		return listaLocucion;
	}

	public void setListaLocucion(ArrayList<LocucionDTO> listaLocucion) {
		this.listaLocucion = listaLocucion;
	}

	public String getRutaComercial() {
		return rutaComercial;
	}

	public void setRutaComercial(String rutaComercial) {
		this.rutaComercial = rutaComercial;
	}

	public ArrayList<ComercialDTO> getListaComercial() {
		return listaComercial;
	}

	public void setListaComercial(ArrayList<ComercialDTO> listaComercial) {
		this.listaComercial = listaComercial;
	}

	public String getRutaFinal() {
		return rutaFinal;
	}

	public void setRutaFinal(String rutaFinal) {
		this.rutaFinal = rutaFinal;
	}

	public String getCarpetaCanciones() {
		return carpetaCanciones;
	}

	public void setCarpetaCanciones(String carpetaCanciones) {
		this.carpetaCanciones = carpetaCanciones;
	}

	public String getCarpetaComercial() {
		return carpetaComercial;
	}

	public void setCarpetaComercial(String carpetaComercial) {
		this.carpetaComercial = carpetaComercial;
	}

	public String getCarpetaLocucion() {
		return carpetaLocucion;
	}

	public void setCarpetaLocucion(String carpetaLocucion) {
		this.carpetaLocucion = carpetaLocucion;
	}

	public ArrayList<PlaylistDTO> getListaPlaylist() {
		return listaPlaylist;
	}

	public void setListaPlaylist(ArrayList<PlaylistDTO> listaPlaylist) {
		this.listaPlaylist = listaPlaylist;
	}

	public String getRutaPlaylist() {
		return rutaPlaylist;
	}

	public void setRutaPlaylist(String rutaPlaylist) {
		this.rutaPlaylist = rutaPlaylist;
	}
	
	
	

}