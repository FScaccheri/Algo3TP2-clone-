package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.adquiribles.Propiedad;
import vistas.ContenedorJuego;

public class BotonEdificarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugadorActual;
	private LinkedList<Propiedad> edificables;
	private Tablero tablero;
	
	public BotonEdificarEventHandler(ContenedorJuego contenedorJuego, Tablero tablero) {
		
		this.jugadorActual = contenedorJuego.getJugadorActual();
		this.tablero = tablero;
		this.edificables = new LinkedList<Propiedad>();
	}
	@Override
	public void handle(ActionEvent event) {

		
		
		LinkedList<Propiedad> propiedades = jugadorActual.getAdquiridos().propiedades();
		
		if (propiedades.isEmpty()) {
			
			Alert ventana = new Alert(AlertType.ERROR);
			ventana.setTitle("Edificacion");
			ventana.setHeaderText("No hay propiedades para edificar!");
			ventana.show();
			
		}
		
		for(int i = 0; i < propiedades.size(); i++) {
			
			if (propiedades.get(i).puedeCostruirCasa() || propiedades.get(i).puedeCostruirHotel()) {
				Alert ventana = new Alert(AlertType.CONFIRMATION);
				ventana.setTitle("Edificacion");
				ventana.setHeaderText("Desea edificar esta propiedad?");
				Propiedad unaPropiedad = propiedades.get(i);
				String nombre = tablero.getCasilleros().get(unaPropiedad.getPosicionRelativa()).getNombre();
				Button unBoton = new Button(nombre);
				unBoton.setOnAction(new BotonEdificarUnaPropiedadEventHandler(unaPropiedad));
				ventana.setGraphic(unBoton);
				//ventana.setGraphic(new Button("boton"));
				//ventana.setGraphic(new Button("boton2"));
				ventana.showAndWait();
				
			}
		}
		
		
		
		
	}

}
