package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import vistas.VistaJugador;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private GraphicsContext gc;
	private Button botonComprar;
	private LinkedList<VistaJugador> jugadores;
	private VistaJugador vistaJugador;

	public BotonComprarEventHandler(GraphicsContext gc, LinkedList<VistaJugador> jugadores, VistaJugador vistaJugadorActual, Button botonComprar) {
		
		this.gc = gc;
		this.botonComprar = botonComprar;
		this.jugadores = jugadores;
		this.vistaJugador = vistaJugadorActual;
	}

	@Override
	public void handle(ActionEvent event) {

		System.out.println(""+ vistaJugador);
		int posX = vistaJugador.getPosX();
		int posY = vistaJugador.getPosY();
		botonComprar.setDisable(true);
		Paint color = vistaJugador.getColor();
		
		gc.setFill(color);
		gc.fillRect(posX + 5, posY + 5, 110, 25);
		
	}

}
