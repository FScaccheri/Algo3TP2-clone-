package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private GraphicsContext gc;
	private Button botonComprar;
	private VistaJugador vistaJugador;
	private ContenedorJuego contenedorJuego;

	public BotonComprarEventHandler(ContenedorJuego contenedorJuego, GraphicsContext gc, Button botonComprar) {
		
		this.contenedorJuego = contenedorJuego;
		this.gc = gc;
		this.botonComprar = botonComprar;
	}

	@Override
	public void handle(ActionEvent event) {
		
		vistaJugador = contenedorJuego.getVistaJugadorActual();
		
		int posX = vistaJugador.getPosX();
		int posY = vistaJugador.getPosY();
		Paint color = vistaJugador.getColor();
		
		gc.setFill(color);
		gc.fillRect(posX + 5, posY + 5, 110, 25);
		

		botonComprar.setDisable(true);
		
	}

}
