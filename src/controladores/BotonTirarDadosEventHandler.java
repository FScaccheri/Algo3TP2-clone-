package controladores;

import java.net.URL;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Tirada;
import modelo.casilleros.Carcel;
import modelo.excepciones.CapitalInsuficiente;
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
		try {
			if(!((Carcel)(jugador.getPosicion().getCasillero().getEfecto())).estaPreso(jugador)) {
				if(huboDobles) {
					
					huboDobles = false;
					
				} else {
					
					huboDobles = Tirada.fueDoble();
					
				}
			}
		}catch(ClassCastException e) {}
		
		jugador.avanzar(tirada);
		try {
			Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
		} catch (CapitalInsuficiente e) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("No tiene dinero para pagar el alquiler!");
			alerta.setContentText("Venda alguna de sus propiedades");
			alerta.show();
			
			/* Ciclo que obliga al jugador a vender propiedades hasta que le alcance la plata.
			 * Si vendio todo y aun no le alcanza, pierde y se lo elimina de la lista de jugadores.
			while ((!jugador.getAdquiridos().propiedades().isEmpty()) && (!jugador.getAdquiridos().servicios().isEmpty()))
				botonVender.fire();
				*/
		}
		
		vistaJugador.moverA(jugador.getPosicion());
		canvas.getGraphicsContext2D().setFont(new Font("", 30));
		canvas.getGraphicsContext2D().fillText("" + tirada, 350, 340);
		if (huboDobles) 
			
			canvas.getGraphicsContext2D().fillText("DOBLES!", 350, 400);
		
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
