package nuevo.controladores;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.excepciones.CapitalInsuficiente;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private AudioClip audioClip;
	final URL RESOURCE = getClass().getResource("sonidos/registradora.wav");

	public BotonComprarEventHandler() {
		this.audioClip = new AudioClip(RESOURCE.toString());
		this.audioClip.setVolume(0.1);
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		try {
			algoPoly.comprarRentableActual();
			audioClip.play();
		} catch (CapitalInsuficiente e) {
			Alert ventana = new Alert(AlertType.ERROR);
			ventana.setHeaderText("Capital Insuficiente!");
			ventana.setContentText("No tiene sufiente capital para realizar la compra");
			ventana.show();
		}
		algoPoly.actualizar();
		
	}

}
