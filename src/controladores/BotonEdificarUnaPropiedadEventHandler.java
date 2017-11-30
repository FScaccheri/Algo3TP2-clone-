package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import modelo.casilleros.adquiribles.Propiedad;

public class BotonEdificarUnaPropiedadEventHandler implements EventHandler<ActionEvent> {

	private Propiedad propiedad;
	private Button boton;
	
	public BotonEdificarUnaPropiedadEventHandler (Button boton,Propiedad propiedad) {
		this.propiedad = propiedad;
		this.boton = boton;
	}
	@Override
	public void handle(ActionEvent event) {

		if(propiedad.puedeCostruirCasa())
			
			propiedad.construirCasa();
		
		else if(propiedad.puedeCostruirHotel())
			
			propiedad.construirHotel();
		
		else {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Edificacion");
			alerta.setContentText("No se puede edificar mas!");
			alerta.show();
		}

	}

}
