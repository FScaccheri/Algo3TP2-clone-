package controladores;

import javafx.event.ActionEvent;
import modelo.Jugador;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private GraphicsContext gc;
	private Button botonComprar;
	private Jugador jugador;
	private ContenedorJuego contenedorJuego;

	public BotonComprarEventHandler(ContenedorJuego contenedorJuego, GraphicsContext gc, Button botonComprar) {
		
		this.contenedorJuego = contenedorJuego;
		this.gc = gc;
		this.botonComprar = botonComprar;
	}

	@Override
	public void handle(ActionEvent event) {
		
		jugador = contenedorJuego.getJugadorActual();
		
		int posX = jugador.getVista().getPosX();
		int posY = jugador.getVista().getPosY();
		Paint color = jugador.getVista().getColor();
		
		gc.setFill(color);
		gc.fillRect(posX + 5, posY + 5, 110, 25);
		

		botonComprar.setDisable(true);
		
	}

}
