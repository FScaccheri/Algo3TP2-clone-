package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vistas.BotonTirarDados;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonTerminarEventHandler implements EventHandler<ActionEvent>{

	private BotonTirarDados botonTirar;
	private Button botonTerminar;

	public BotonTerminarEventHandler(BotonTirarDados botonTirarDados, Button botonTerminar) {

		this.botonTirar = botonTirarDados;
		this.botonTerminar = botonTerminar;
	}

	@Override
	public void handle(ActionEvent event) {
		
		botonTerminar.setDisable(true);
		botonTirar.setDisable(false);
		
		
		
	}

}
