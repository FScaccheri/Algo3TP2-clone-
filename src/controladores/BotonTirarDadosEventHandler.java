package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import modelo.Tirada;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	public BotonTirarDadosEventHandler() {
		
	}
	@Override
	public void handle(ActionEvent event) {

		int tirada = Tirada.tirar();
		
	}

}
