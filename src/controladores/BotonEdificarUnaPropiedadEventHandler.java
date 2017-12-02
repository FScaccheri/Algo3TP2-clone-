package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import modelo.casilleros.adquiribles.Propiedad;
import vistas.ContenedorJuego;

public class BotonEdificarUnaPropiedadEventHandler implements EventHandler<ActionEvent> {

	private Propiedad propiedad;
	private Button boton;
	private ContenedorJuego contenedorJuego;
	
	public BotonEdificarUnaPropiedadEventHandler (Button boton,Propiedad propiedad, ContenedorJuego contenedorJuego) {
		this.propiedad = propiedad;
		this.boton = boton;
		this.contenedorJuego = contenedorJuego;
	}
	@Override
	public void handle(ActionEvent event) {

		if(propiedad.puedeCostruirCasa())
			
			propiedad.construirCasa();
		
		else if(propiedad.puedeCostruirHotel()) {
			
			propiedad.construirHotel();
		}
		if (!propiedad.puedeCostruirCasa() && !propiedad.puedeCostruirHotel()) {boton.setDisable(true);}


		contenedorJuego.setBordeJugadores(3);//HardCoded por el momento
	}

}
