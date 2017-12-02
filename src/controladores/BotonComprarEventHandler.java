package controladores;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import modelo.Jugador;
import modelo.casilleros.Activable;
import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;
import modelo.casilleros.adquiribles.Servicio;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private GraphicsContext gc;
	private Button botonComprar;
	private VistaJugador vistaJugador;
	private ContenedorJuego contenedorJuego;	
	private AudioClip audioClip;
	final URL resource = getClass().getResource("sonidos/registradora.wav");

	public BotonComprarEventHandler(ContenedorJuego contenedorJuego, GraphicsContext gc, Button botonComprar) {
		
		this.contenedorJuego = contenedorJuego;
		this.gc = gc;
		this.botonComprar = botonComprar;
		this.audioClip = new AudioClip(resource.toString());	
		this.audioClip.setVolume(0.1);	
	}

	@Override
	public void handle(ActionEvent event) {
		
		vistaJugador = contenedorJuego.getVistaJugadorActual();
		Jugador jugador = vistaJugador.getJugadorAsociado();
		jugador = contenedorJuego.getJugadorActual();
		Activable aAdquirir =  jugador.getPosicion().getCasillero().getEfecto();
		
		if ( (aAdquirir instanceof Adquirible) && ( ! ((Adquirible)aAdquirir).tienePropietario())) {
			
			if(aAdquirir instanceof Propiedad)
				jugador.adquirir((Propiedad) aAdquirir);
			
			if(aAdquirir instanceof Servicio)
				jugador.adquirir((Servicio) aAdquirir);
		
			int posX = vistaJugador.getPosX();
			int posY = vistaJugador.getPosY();
			Paint color = vistaJugador.getColor();
		
			gc.setFill(color);
			gc.fillRect(posX + 5, posY + 5, 110, 25);
		
			this.audioClip.play();
			
			
			botonComprar.setDisable(true);
			
		} else if (!(aAdquirir instanceof Adquirible)) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Compra no realizada");
			alerta.setContentText("No se puede comprar!");
			alerta.show();
			
		}
		
		else {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Compra no realizada");
			alerta.setContentText("La propiedad ya tiene duenio!");
			alerta.show();
		}

		contenedorJuego.setBordeJugadores(3);//HardCoded por el momento
	}

}
