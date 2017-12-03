package nuevo.controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;
import nuevo.vistas.ContenedorJuego;

public class BotonEdificarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugadorActual;
	private LinkedList<Propiedad> edificables;
	private Tablero tablero;
	private ContenedorJuego contenedorJuego;
	
	public BotonEdificarEventHandler() {
		
		this.contenedorJuego = contenedorJuego;
		this.tablero = tablero;
		this.edificables = new LinkedList<Propiedad>();
	}
	@Override
	public void handle(ActionEvent event) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		Jugador jugador = algoPoly.getJugadorActual();
		LinkedList<Propiedad> propiedades = algoPoly.getPropiedadesDeJugador(jugador);

		if (propiedades.isEmpty()) {
			
			Alert ventana = new Alert(AlertType.WARNING);
			ventana.setHeaderText("Edificacion no realizada");
			ventana.setContentText("No tiene propiedades para edificar!");
			ventana.show();
			
		}
		
		Stage ventana = new Stage();
		HBox contenedor = new HBox();
		Scene escena = new Scene(contenedor);
		// Cambiar el contenedor a un contenedor(root/ VBox) principal y agregar dos subcontenedores
		// (roots/ HBox) distintos. @FScaccheri
		contenedor.setPadding(new Insets(25));
		ventana.setScene(escena);
		ventana.setTitle("Sus propiedades edificables");
		
		for(Propiedad propiedad:propiedades) {
			if (propiedad.puedeCostruirCasa() || propiedad.puedeCostruirHotel()) {
				
				
				Button boton = new Button(propiedad.getNombre());
				boton.setOnAction(new BotonEdificarUnaPropiedadEventHandler(boton, propiedad, contenedorJuego));
				
				contenedor.getChildren().add(boton);
				ventana.show();
				
			}			
		}
	}

}
