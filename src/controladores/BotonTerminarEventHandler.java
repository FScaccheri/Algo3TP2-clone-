package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vistas.BotonTirarDados;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonTerminarEventHandler implements EventHandler<ActionEvent>{

	private BotonTirarDados botonTirar;
	private Button botonTerminar;
	private LinkedList<VistaJugador> jugadores;
	private int numeroJugador;
	private ContenedorJuego contenedorJuego;

	public BotonTerminarEventHandler(ContenedorJuego contenedorJuego, LinkedList<VistaJugador> jugadores, BotonTirarDados botonTirarDados, Button botonTerminar) {

		this.botonTirar = botonTirarDados;
		this.botonTerminar = botonTerminar;
		this.jugadores = jugadores;
		this.contenedorJuego = contenedorJuego;
	}

	@Override
	public void handle(ActionEvent event) {
		
		VistaJugador jugador = contenedorJuego.getVistaJugadorActual();
		numeroJugador = jugadores.indexOf(jugador);
		numeroJugador++;
		
		if(numeroJugador > 2)
		
			numeroJugador = 0;
		
		jugador = jugadores.get(numeroJugador);
		contenedorJuego.setVistaJugadorActual(jugador);
		
		botonTerminar.setDisable(true);
		botonTirar.setDisable(false);
		
		
		
	}

}
