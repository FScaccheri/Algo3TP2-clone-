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
	private ContenedorJuego contenedorJuego;
	
	public BotonTirarDadosEventHandler(ContenedorJuego contenedorJuego, Button botonTirarDados, Button botonComprar, Button botonTerminar) {

		this.contenedorJuego = contenedorJuego;
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonComprar = botonComprar;
		this.botonTerminar = botonTerminar;
	}
	@Override
	public void handle(ActionEvent event) {

		VistaJugador vistaJugador = contenedorJuego.getVistaJugadorActual();

		Jugador jugador = contenedorJuego.getJugadorActual();
		
		int tirada = Tirada.tirar();
		if(huboDobles) {
			
			huboDobles = false;
			
		} else {

			huboDobles = Tirada.fueDoble();
		}
		
		jugador.avanzar(tirada);
		Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
		int posicionRelativa = jugador.getPosicionRelativa();
		vistaJugador.moverA(posicionRelativa);
		
		if(!huboDobles) {
			
			
			botonTirar.setDisable(true);
			botonComprar.setDisable(false);
			botonTerminar.setDisable(false);
		}
		
		
	}

}
