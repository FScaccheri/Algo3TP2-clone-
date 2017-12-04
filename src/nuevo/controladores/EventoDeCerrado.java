package nuevo.controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.WindowEvent;
import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.CapitalInsuficiente;

public class EventoDeCerrado implements EventHandler<WindowEvent>{
	
	private Jugador jugador;
	
	public EventoDeCerrado(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void handle(WindowEvent event) {
		try {
			Tablero.getInstancia().getCasillero(jugador.getPosicion()).caeEn(jugador);
			
		} catch (CapitalInsuficiente e) {
			Button boton = new Button();
			boton.setOnAction(new VenderHastaPoderPagarEventHandler());
			boton.fire();
		}
	}

}
