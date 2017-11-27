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

		Alert ventana = new Alert(AlertType.CONFIRMATION);
		ventana.setTitle("Edificacion");
		ventana.setHeaderText("Elija en que propiedades desea edificar");
		
		LinkedList<Propiedad> propiedades = jugadorActual.getAdquiridos().propiedades();
		
		for(int i = 0; i < propiedades.size(); i++) {
			
			if (propiedades.get(i).puedeCostruirCasa() || propiedades.get(i).puedeCostruirHotel()) {
			
				Propiedad unaPropiedad = propiedades.get(i);
				String nombre = tablero.getCasilleros().get(unaPropiedad.getPosicionRelativa()).getNombre();
				ventana.setGraphic(new Button(nombre));
			}
		}
		
		
		
		ventana.setGraphic(new Button("boton"));
		ventana.showAndWait();
		
	}

}
