package controladores;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.Jugador;
import modelo.Tablero;
import modelo.Tirada;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private Button botonTirar;
	private Button botonComprar;
	private Button botonTerminar;
	private boolean huboDobles;
	private VistaJugador vistaJugador;
	private ContenedorJuego contenedorJuego;
	
	public BotonTirarDadosEventHandler(ContenedorJuego contenedorJuego, LinkedList<VistaJugador> jugadores, VistaJugador vistaJugadorActual, Button botonTirarDados, Button botonComprar, Button botonTerminar) {

		this.contenedorJuego = contenedorJuego;
		this.vistaJugador = vistaJugadorActual;
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonComprar = botonComprar;
		this.botonTerminar = botonTerminar;
	}
	@Override
	public void handle(ActionEvent event) {

		vistaJugador = contenedorJuego.getVistaJugadorActual();
		
		int tirada = Tirada.tirar();
		
		if(huboDobles) {
			
			huboDobles = false;
			
		} else {

			huboDobles = Tirada.fueDoble();
		}
		
		vistaJugador.avanzar(tirada);
		Jugador jugador = vistaJugador.getJugadorAsociado();
		vistaJugador.getJugadorAsociado().avanzar(tirada);
		Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
		
		
		if(!huboDobles) {
			
			botonTirar.setDisable(true);
			botonComprar.setDisable(false);
			botonTerminar.setDisable(false);
		
		}
	}

}
