package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonSalidaEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {

		System.exit(0);
		
	}

}
