package nuevo.controladores;

import java.net.URL;

import javafx.scene.media.AudioClip;

public class Player {
	
	private AudioClip clip;
	final URL RESOURCE = getClass().getResource("sonidos/ganador.mp3");
	
	public Player() {
		
		clip = new AudioClip(RESOURCE.toString());
		clip.setVolume(0.1);
	}
	
	public void play() {
		clip.play();
	}

}
