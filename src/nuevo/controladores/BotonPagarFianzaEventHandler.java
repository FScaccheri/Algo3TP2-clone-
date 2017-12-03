package nuevo.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.AlgoPoly;
import modelo.excepciones.CapitalInsuficiente;
import modelo.excepciones.LiberacionInvalida;

public class BotonPagarFianzaEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		try {
			algoPoly.liberarJugadorActualPorFianza();			
		} catch (LiberacionInvalida e) {
			Alert ventana = new Alert(AlertType.ERROR);
			ventana.setHeaderText("Liberacion Invalida!");
			ventana.setContentText("No puede salir de la carcel en el primer turno");
			ventana.show();
		} catch (CapitalInsuficiente e) {
			Alert ventana = new Alert(AlertType.ERROR);
			ventana.setHeaderText("Capital Insuficiente!");
			ventana.setContentText("No tiene sufiente capital para salir de la carcel");
			ventana.show();
		}
		algoPoly.actualizar();
	}

}
