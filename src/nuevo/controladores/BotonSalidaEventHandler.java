package nuevo.controladores;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class BotonSalidaEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {

		Alert alerta = new Alert(AlertType.CONFIRMATION);
		alerta.setTitle("Salir");
		alerta.setHeaderText("Esta seguro que desea salir del juego?");
		alerta.setContentText("Se interrumpira y finalizara esta partida");
		
		Optional<ButtonType> result = alerta.showAndWait();
		if (result.get() == ButtonType.OK) {
			Alert alerta2 = new Alert(AlertType.INFORMATION);
			alerta2.setTitle("Empate!");
			alerta2.setHeaderText("Fin del juego");
			alerta2.setContentText("Gracias por jugar!");
			alerta2.showAndWait();
			
			System.exit(0);
		}
		
		
	}

}
