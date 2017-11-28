package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
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
				
				// ejemplo:
				Stage ventana = new Stage();
				Button boton = new Button("Boton");
				VBox contenedor = new VBox();
				contenedor.getChildren().add(boton);
				Scene escena = new Scene(contenedor);
				ventana.setScene(escena);
				ventana.show();
				
			}
		
		}
		
		
		
	}

}
