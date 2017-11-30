package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import modelo.Jugador;
import modelo.casilleros.Carcel;
import vistas.BotonTirarDados;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonTerminarEventHandler implements EventHandler<ActionEvent>{

	private BotonTirarDados botonTirar;
	private Button botonVender;
	private Button botonEdificar;
	private Button botonPagarFianza;
	private Button botonTerminar;
	private LinkedList<VistaJugador> vistasJugadores;
	private LinkedList<Jugador> jugadores;
	private int numeroJugador;
	private ContenedorJuego contenedorJuego;
	
	

	public BotonTerminarEventHandler(ContenedorJuego contenedorJuego, LinkedList<Jugador> jugadores, LinkedList<VistaJugador> vistasJugadores, BotonTirarDados botonTirarDados, Button botonVender, Button botonEdificar, Button botonPagarFianza, Button botonTerminar) {

		this.botonTirar = botonTirarDados;
		this.botonVender = botonVender;
		this.botonEdificar = botonEdificar;
		this.botonPagarFianza = botonPagarFianza;
		this.botonTerminar = botonTerminar;
		this.vistasJugadores = vistasJugadores;
		this.jugadores = jugadores;
		this.contenedorJuego = contenedorJuego;
	}

	@Override
	public void handle(ActionEvent event) {
		
		VistaJugador vistaJugador = contenedorJuego.getVistaJugadorActual();
		Jugador jugador = contenedorJuego.getJugadorActual();
		
		numeroJugador = jugadores.indexOf(jugador);
		numeroJugador++;
		if(numeroJugador > 2)
		
			numeroJugador = 0;
		
		
		vistaJugador = vistasJugadores.get(numeroJugador);
		contenedorJuego.setVistaJugadorActual(vistaJugador);
		jugador = jugadores.get(numeroJugador);
		contenedorJuego.setJugadorActual(jugador);
		
		botonTerminar.setDisable(true);
		botonVender.setDisable(false);
		botonEdificar.setDisable(false);
		botonTirar.setDisable(false);
		try {
		Carcel carcelPotencial = (Carcel) jugador.getPosicion().getCasillero().getEfecto();
		if( carcelPotencial.estaPreso(jugador) && (carcelPotencial.getTurnosPreso(jugador) > 0) ){
			botonPagarFianza.setDisable(false);
		}
		} catch (ClassCastException e) {
			botonPagarFianza.setDisable(true);
		}
	}
}
