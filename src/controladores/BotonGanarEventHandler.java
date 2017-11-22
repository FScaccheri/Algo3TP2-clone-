package controladores;

import java.io.File;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;


public class BotonGanarEventHandler implements EventHandler<ActionEvent>{

	private AudioClip audioClip;
	
	final URL resource = getClass().getResource("sonidos/ganador.mp3");
	
	public BotonGanarEventHandler() {
		
		this.audioClip = new AudioClip(resource.toString());
		
		this.audioClip.setVolume(0.1);
	}
	
	@Override
	public void handle(ActionEvent event) {

		this.audioClip.play();
	}

}
