package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.casilleros.adquiribles.Propiedad;

public class BotonEdificarUnaPropiedadEventHandler implements EventHandler<ActionEvent> {

	private Propiedad propiedad;
	
	public BotonEdificarUnaPropiedadEventHandler (Propiedad propiedad) {
		
		this.propiedad = propiedad;
	}
	@Override
	public void handle(ActionEvent event) {

		if(propiedad.puedeCostruirCasa())
			
			propiedad.construirCasa();
		
		else if(propiedad.puedeCostruirHotel())
			
			propiedad.construirHotel();
		
		else {
			
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Edificacion");
			alerta.setHeaderText("No se puede edificar mas!");
			alerta.show();
		}

	}

}
