package co.edu.unbosque.controller;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.player.Player;

public class Reproductor {

	
	private String filename;
    private Player player;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private Thread playerThread;
    private long pauseLocation = 0; 
    private boolean cancionStatus = false;
    private boolean cancionTerminada = true;
    

    public Reproductor(String filename) {
        this.filename = filename;
    }

    public Reproductor() {
		// TODO Auto-generated constructor stub
	}

	public void close() {
        if (player != null) {
            player.close();
            playerThread.isInterrupted();
            setCancionStatus(false);
            setCancionTerminada(true);
        }
        setCancionStatus(true);
    }

    public void play() {
        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            playerThread = new Thread(){
            	public void run() {
                try {
                    player.play();
                    player.close();
                    setCancionStatus(false);
                    setCancionTerminada(true);
                } catch (Exception e) {
                    System.out.println("Problem playing file " + filename);
                    System.out.println(e);
                }
            }
        };
            playerThread.start();
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
            setCancionStatus(false);
        }
        setCancionStatus(true);
        setCancionTerminada(false);
    }
    
    public void playContiniue() {
        try {
            playerThread = new Thread(){
            	public void run() {
                try {
                    player.play();
                    player.close();
                    setCancionStatus(false);
                    setCancionTerminada(true);
                } catch (Exception e) {
                    System.out.println("Problem playing file " + filename);
                    System.out.println(e);
                }
            }
        };
            playerThread.start();
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
            setCancionStatus(false);
        }
        setCancionStatus(true);
        setCancionTerminada(false);
    }

    public void pause() {
        if (player != null && playerThread != null) {
           
            try {
				pauseLocation = bis.available();
				player.close();
				playerThread.isInterrupted();
				setCancionStatus(false);
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
            ;
        }
        
    }

    public void resume() {
        if (pauseLocation != 0) {
            try {
                fis = new FileInputStream(filename);
                bis = new BufferedInputStream(fis);
                bis.skip(bis.available() - pauseLocation); 
                player = new Player(bis);
                playContiniue();
                pauseLocation = 0;
                setCancionStatus(true);
            } catch (Exception e) {
                System.out.println("Problem resuming file " + filename);
                System.out.println(e);
                
            }
        }
    }

	public boolean isCancionStatus() {
		return cancionStatus;
	}

	public void setCancionStatus(boolean cancionStatus) {
		this.cancionStatus = cancionStatus;
	}

	public boolean isCancionTerminada() {
		return cancionTerminada;
	}

	public void setCancionTerminada(boolean cancionTerminada) {
		this.cancionTerminada = cancionTerminada;
	}
	
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
