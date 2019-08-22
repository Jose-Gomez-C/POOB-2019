package Presentacion;

import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.Clip;

public class Sound {
	
	private Clip sonido;
	private int milisegundos;
	
	// Ejemplo de ruta src/resources/original.wav
	
    public Sound(String ruta, int milisegundos) { 
    	this.milisegundos = milisegundos;
        try {
            sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File(ruta)));
            //sonido.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    public void inicie() {
    	sonido.start();
    	//while (sonido.isRunning())
    	try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    public void pare() {
    	sonido.stop();
    }

}