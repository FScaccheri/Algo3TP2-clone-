package nuevo.controladores;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.excepciones.CapitalInsuficiente;

public class BotonEdificarUnaPropiedadEventHandler implements EventHandler<ActionEvent> {

	private Propiedad propiedad;
	private AudioClip audioClip;
	final URL RESOURCE = getClass().getResource("sonidos/construccion.wav");
	
	public BotonEdificarUnaPropiedadEventHandler (Propiedad propiedad) {
		this.propiedad = propiedad;
		this.audioClip = new AudioClip(RESOURCE.toString());
		audioClip.setVolume(0.1);
	}
	
	@Override
	public void handle(ActionEvent event) {
		try {
			if(propiedad.puedeCostruirCasa()) {			
				propiedad.construirCasa();
				audioClip.play();
			}
			
			else if(propiedad.puedeCostruirHotel()) {
				propiedad.construirHotel();
				audioClip.play();
			}			
		} catch (CapitalInsuficiente e) {
			Alert ventana = new Alert(AlertType.WARNING);
			ventana.setHeaderText("Edificacion no realizada!");
			ventana.setContentText("No tiene capital suficiente para edificar");
			ventana.show();
		}
		
		AlgoPoly.getInstancia().actualizar();
	}

}
