package nuevo.controladores;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;

public class BotonVenderUnAdquiribleEventHandler implements EventHandler<ActionEvent> {

	private Adquirible adquirible;
	private Button boton;
	private Jugador jugador;
	private AudioClip clip;
	final URL RESOURCE = getClass().getResource("sonidos/registradora2.mp3");

	public BotonVenderUnAdquiribleEventHandler(Button boton, Jugador jugador, Adquirible adquirible) {

		this.boton = boton;
		this.jugador = jugador;
		this.adquirible = adquirible;
		this.clip = new AudioClip(RESOURCE.toString());
		clip.setVolume(0.1);
	}

	@Override
	public void handle(ActionEvent event) {
		
		if (adquirible instanceof Propiedad)
			jugador.vender((Propiedad) adquirible);
		else
			jugador.vender((Servicio) adquirible);
		boton.setDisable(true);
		clip.play();
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.actualizar();
	}
	
	

}
