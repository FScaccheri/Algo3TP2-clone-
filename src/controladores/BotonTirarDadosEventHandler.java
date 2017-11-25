package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import modelo.Tirada;
import vistas.VistaJugador;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private VistaJugador vistaJugador;
	
	public BotonTirarDadosEventHandler(VistaJugador vista) {
		
		this.vistaJugador = vista;
	}
	@Override
	public void handle(ActionEvent event) {

		int tirada = Tirada.tirar();
		
		vistaJugador.avanzar(tirada);
		
		
	}

}
