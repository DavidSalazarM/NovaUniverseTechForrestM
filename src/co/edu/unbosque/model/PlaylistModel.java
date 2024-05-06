package co.edu.unbosque.model;

import co.edu.unbosque.controller.Reproductor;

public class PlaylistModel {


	private Reproductor reproductor;
	private String[] listaSong;
	private Thread reproduccionThread;

	public boolean gru =false;
	
	public PlaylistModel(){}
	
	public PlaylistModel(Reproductor reproductor,String[] listaSong){
		this.reproductor = reproductor;
		this.listaSong = listaSong;
	}
	
	public void reproducir(){
		if(reproductor.isCancionStatus()==false) {
		reproduccionThread = new Thread(){
			public void run(){
				
				for (String cancion : listaSong){
					if(reproductor.isCancionTerminada()==true){
						
						gru = false;
						reproductor.setFilename(cancion);
						reproductor.play();
						
					} while (!gru && !reproductor.isCancionTerminada()) {
	                    try {
	                        Thread.sleep(100); 
	                    } catch (InterruptedException e) {
	                       
	                        return;
	                    } 
	                }
	            }}
		};reproduccionThread.start();
	}};
	
	public void detener(){
        if (reproduccionThread != null) {
        	reproductor.close();
            reproduccionThread.interrupt();
            reproduccionThread=null;
        }
	}

	
	public void siguiente() {
		try {
		if(reproductor.isCancionStatus()==true){
			
			reproductor.close();
			reproductor.setCancionTerminada(true);
			this.gru=true;
		}}catch (NullPointerException e) {
			// TODO: handle exception
		}
	}

	public boolean isGru() {
		return gru;
	}

	public void setGru(boolean gru) {
		try {		reproductor.close();
		this.gru = gru;
		} catch (NullPointerException e) {
			return;
		}

	}
	
	public Reproductor getReproductor() {
		return reproductor;
	}

	public void setReproductor(Reproductor reproductor) {
		this.reproductor = reproductor;
	}

	public String[] getListaSong() {
		return listaSong;
	}

	public void setListaSong(String[] listaSong) {
		this.listaSong = listaSong;
	}

	public Thread getReproduccionThread() {
		return reproduccionThread;
	}

	public void setReproduccionThread(Thread reproduccionThread) {
		this.reproduccionThread = reproduccionThread;
	}

}