package controladores;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;


public class BotonGanarEventHandler implements EventHandler<ActionEvent>{

	private AudioClip audioClip;

	public BotonGanarEventHandler() {
		
		//audioClip tiene un filepath local, hay que refactorizar. @FScaccheri
		this.audioClip = new AudioClip(new File("C:\\Users\\Franco\\git\\Algo3TP2\\Algo3TP2\\src\\controladores\\sonidos\\ganador.mp3").toURI().toString());
		
		this.audioClip.setVolume(0.1);
	}
	
	@Override
	public void handle(ActionEvent event) {

		this.audioClip.play();
	}

}
