package nuevo.controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.casilleros.Carcel;
import nuevo.vistas.BotonTirarDados;
import nuevo.vistas.ContenedorJuego;
import nuevo.vistas.VistaJugador;

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
	
	

	@Override
	public void handle(ActionEvent event) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.finalizarTurno();
		algoPoly.actualizar();
//		
//		VistaJugador vistaJugador = contenedorJuego.getVistaJugadorActual();
//		Jugador jugador = contenedorJuego.getJugadorActual();
//		
//		numeroJugador = jugadores.indexOf(jugador);
//		numeroJugador++;
//		if(numeroJugador > 2)
//		
//			numeroJugador = 0;
//		
//		
//		vistaJugador = vistasJugadores.get(numeroJugador);
//		contenedorJuego.setVistaJugadorActual(vistaJugador);
//		jugador = jugadores.get(numeroJugador);
//		contenedorJuego.setJugadorActual(jugador);
//		
//		botonTerminar.setDisable(true);
//		botonVender.setDisable(false);
//		botonEdificar.setDisable(false);
//		botonTirar.setDisable(false);
//		try {
//		Carcel carcelPotencial = (Carcel) jugador.getPosicion().getCasillero().getEfecto();
//		if( carcelPotencial.estaPreso(jugador) && (carcelPotencial.getTurnosPreso(jugador) > 0) ){
//			botonPagarFianza.setDisable(false);
//		}
//		} catch (ClassCastException e) {
//			botonPagarFianza.setDisable(true);
//		}
	}
}
