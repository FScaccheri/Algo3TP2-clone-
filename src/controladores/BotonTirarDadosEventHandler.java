package controladores;

import java.net.URL;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import modelo.Jugador;
import modelo.Posicion;
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
	private AudioClip audioClip;
	final URL resource = getClass().getResource("sonidos/dados.wav");
	
	public BotonTirarDadosEventHandler(ContenedorJuego contenedorJuego, Button botonTirarDados, Button botonComprar, Button botonTerminar) {

		this.contenedorJuego = contenedorJuego;
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonComprar = botonComprar;
		this.botonTerminar = botonTerminar;
		this.audioClip = new AudioClip(resource.toString());
		this.audioClip.setVolume(0.1);
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
		
		vistaJugador.moverA(jugador.getPosicion());
		audioClip.play();
		 
		
		if(!huboDobles) {
			
			
			botonTirar.setDisable(true);
			botonComprar.setDisable(false);
			botonTerminar.setDisable(false);
		}
		
		
	}

}
