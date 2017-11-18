package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	private Stage stage;
	private Scene scene;

	public BotonJugarEventHandler(Stage newStage, Scene escenaPrincipal) {
		
		this.stage = newStage;
		this.scene = escenaPrincipal;
	}

	@Override
	public void handle(ActionEvent event) {
		
		this.stage.setScene(scene);
		
	}

}
