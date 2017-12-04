package nuevo.controladores;

import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;

public class EventoDeFinalizacion implements EventHandler<DialogEvent> {

	@Override
	public void handle(DialogEvent event) {
		
		System.exit(0);

	}

}
