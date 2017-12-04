package nuevo.controladores;

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
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Tirada;
import modelo.casilleros.Carcel;
import modelo.excepciones.CapitalInsuficiente;
import nuevo.vistas.CanvasTablero;
import nuevo.vistas.ContenedorJuego;
import nuevo.vistas.VistaJugador;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private AudioClip audioClip;
	final URL RESOURCE = getClass().getResource("sonidos/dados.wav");
	
	public BotonTirarDadosEventHandler() {
		this.audioClip = new AudioClip(RESOURCE.toString());
		this.audioClip.setVolume(0.1);
	}
		
	@Override
	public void handle(ActionEvent event) {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.lanzarDados();
		audioClip.play();
		try {
			algoPoly.avanzarJugadorActual();
		} catch (CapitalInsuficiente e) {

			Button botonVentaHastaPagar = new Button();
			botonVentaHastaPagar.setOnAction(new VenderHastaPoderPagarEventHandler());
			botonVentaHastaPagar.fire();
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("No tiene dinero para pagar el alquiler!");
			alerta.setContentText("Venda alguna de sus propiedades");
			alerta.show();
		}
		algoPoly.actualizar();
		

	}

}
