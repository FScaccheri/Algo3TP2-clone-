package nuevo.controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import nuevo.vistas.ContenedorJuego;
import modelo.AlgoPoly;
import modelo.Jugador;

public class VenderHastaPoderPagarEventHandler implements EventHandler<ActionEvent>{
	
	public VenderHastaPoderPagarEventHandler() {
		
	}
	public void handle(ActionEvent event) {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		Jugador jugador =  algoPoly.getJugadorActual();
		
		Stage ventana = new Stage();
		HBox contenedor = new HBox();
		Scene escena = new Scene(contenedor);
		// Cambiar el contenedor a un contenedor(root/ VBox) principal y agregar dos subcontenedores
		// (roots/ HBox) distintos. @FScaccheri
		contenedor.setPadding(new Insets(25));
		ventana.setScene(escena);
		ventana.setTitle("Sus propiedades");

		ventana.setOnCloseRequest(new EventoDeCerrado(jugador));
		
		if ((jugador.getAdquiridos().propiedades().isEmpty()) && (jugador.getAdquiridos().servicios().isEmpty())) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Perdio!");
			alerta.setContentText("No tiene propiedades para vender!");
			alerta.show();
			
			algoPoly.eliminarJugadorDelJuego(algoPoly.getJugadorActual());
		}
		
		else {
			
			for (Propiedad propiedad: jugador.getAdquiridos().propiedades()) {
			
				Button boton = new Button(propiedad.getNombre());
				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, jugador, propiedad));
				
				contenedor.getChildren().add(boton);
				ventana.show();
			
			}
		
			for (Servicio servicio: jugador.getAdquiridos().servicios()) {
			
				Button boton = new Button(servicio.getNombre());
				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, jugador, servicio));
				
				contenedor.getChildren().add(boton);
				ventana.show();
			
			}
		
		}
		
	}
}
