package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.casilleros.adquiribles.Adquirible;

public class BotonVenderUnAdquiribleEventHandler implements EventHandler<ActionEvent> {

	private Adquirible adquirible;
	private Button boton;

	public BotonVenderUnAdquiribleEventHandler(Button boton, Adquirible adquirible) {

		this.boton = boton;
		this.adquirible = adquirible;
	}

	@Override
	public void handle(ActionEvent event) {
		
		adquirible.vender();
		boton.setDisable(true);

	}

}
