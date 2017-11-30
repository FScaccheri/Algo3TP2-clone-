package controladores;

import java.net.URL;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Tirada;
import vistas.CanvasTablero;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private Button botonTirar;
	private Button botonVender;
	private Button botonEdificar;
	private Button botonComprar;
	private Button botonTerminar;
	private boolean huboDobles;
	private ContenedorJuego contenedorJuego;
	private AudioClip audioClip;
	final URL resource = getClass().getResource("sonidos/dados.wav");
	private CanvasTablero canvas;
	
	
	
	public BotonTirarDadosEventHandler(ContenedorJuego contenedorJuego, Button botonTirarDados, Button botonVender, Button botonEdificar, Button botonComprar, Button botonTerminar) {

		this.contenedorJuego = contenedorJuego;
		this.canvas = contenedorJuego.getCanvasTablero();
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonVender = botonVender;
		this.botonEdificar = botonEdificar;
		this.botonComprar = botonComprar;
		this.botonTerminar = botonTerminar;
		this.audioClip = new AudioClip(resource.toString());
		this.audioClip.setVolume(0.1);
	}
	@Override
	public void handle(ActionEvent event) {

		VistaJugador vistaJugador = contenedorJuego.getVistaJugadorActual();

		Jugador jugador = contenedorJuego.getJugadorActual();
		
		canvas.getGraphicsContext2D().setFill(Color.LIGHTSKYBLUE);
		canvas.getGraphicsContext2D().fillRect(280, 280, 240, 240);
		
		int tirada = Tirada.tirar();
		if(huboDobles) {
			
			huboDobles = false;
			
		} else {

			huboDobles = Tirada.fueDoble();
		}
		
		jugador.avanzar(tirada);
		Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
		
		vistaJugador.moverA(jugador.getPosicion());
		canvas.getGraphicsContext2D().setFont(new Font("", 30));
		canvas.getGraphicsContext2D().fillText("" + tirada, 340, 340);
		if (huboDobles) 
			
			canvas.getGraphicsContext2D().fillText("DOBLES!", 400, 400);
		
		audioClip.play();
		 
		
		if(!huboDobles) {
			
			
			botonTirar.setDisable(true);
			botonVender.setDisable(true);
			botonEdificar.setDisable(true);
			botonComprar.setDisable(false);
			botonTerminar.setDisable(false);
		}
		
		
	}

}
