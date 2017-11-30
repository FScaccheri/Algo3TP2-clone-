package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import modelo.casilleros.adquiribles.Adquirible;
import vistas.ContenedorJuego;

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
		//Falta que "despinte" el casillero que se vendio. @FScaccheri
		boton.setDisable(true);

	}

}
