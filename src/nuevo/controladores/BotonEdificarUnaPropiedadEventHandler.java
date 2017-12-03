package nuevo.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.AlgoPoly;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.excepciones.CapitalInsuficiente;

public class BotonEdificarUnaPropiedadEventHandler implements EventHandler<ActionEvent> {

	private Propiedad propiedad;
	
	public BotonEdificarUnaPropiedadEventHandler (Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	@Override
	public void handle(ActionEvent event) {
		try {
			if(propiedad.puedeCostruirCasa())			
				propiedad.construirCasa();
			else if(propiedad.puedeCostruirHotel()) {
				propiedad.construirHotel();
			}			
		} catch (CapitalInsuficiente e) {
			Alert ventana = new Alert(AlertType.WARNING);
			ventana.setHeaderText("Edificacion no realizada!");
			ventana.setContentText("No tiene capital suficiente para edificar");
			ventana.show();
		}
		
		AlgoPoly.getInstancia().actualizar();
	}

}
