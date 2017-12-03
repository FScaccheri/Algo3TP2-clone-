package nuevo.controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import nuevo.vistas.ContenedorJuego;
import nuevo.vistas.VistaCasillero;
import nuevo.vistas.VistaTablero;

public class BotonVenderUnAdquiribleEventHandler implements EventHandler<ActionEvent> {

	private Adquirible adquirible;
	private Button boton;
	private VistaTablero vistaTablero;
	private Jugador jugador;

	public BotonVenderUnAdquiribleEventHandler(Button boton, Jugador jugador, Adquirible adquirible) {

		this.boton = boton;
		this.jugador = jugador;
		this.adquirible = adquirible;
	}

	@Override
	public void handle(ActionEvent event) {
		
		if (adquirible instanceof Propiedad)
			jugador.vender((Propiedad) adquirible);
		else
			jugador.vender((Servicio) adquirible);
		boton.setDisable(true);
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.actualizar();
	}
	
	

}
