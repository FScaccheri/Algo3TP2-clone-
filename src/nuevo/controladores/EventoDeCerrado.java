package nuevo.controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.WindowEvent;
import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.CapitalInsuficiente;
import nuevo.vistas.ContenedorJuego;

public class EventoDeCerrado implements EventHandler<WindowEvent>{
	
	private Jugador jugador;
	private ContenedorJuego contenedor;
	
	public EventoDeCerrado(Jugador jugador, ContenedorJuego contenedor) {
		this.jugador = jugador;
	}
	
	@Override
	public void handle(WindowEvent event) {
		try {Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
		} catch (CapitalInsuficiente e) {
			Button boton = new Button();
			boton.setOnAction(new ComprarHastaPoderPagarEventHandler(contenedor));
			boton.fire();
		}
	}

}
