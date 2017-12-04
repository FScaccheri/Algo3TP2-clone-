package nuevo.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;

public class BotonVenderEventHandler implements EventHandler<ActionEvent>{

	
	@Override
	public void handle(ActionEvent event) {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		Jugador jugador = algoPoly.getJugadorActual();
		
		if ((jugador.getAdquiridos().propiedades().isEmpty()) && (jugador.getAdquiridos().servicios().isEmpty())) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("Venta no realizada");
			alerta.setContentText("No tiene propiedades para vender!");
			alerta.show();
		}
		
		else {
			
			Stage ventana = new Stage();
			VBox contenedor = new VBox();
			Scene escena = new Scene(contenedor, 400, 200);
			
			VBox subcontenedor1 = new VBox();
			subcontenedor1.setAlignment(Pos.CENTER);
			Label etiqueta = new Label("Elija que propiedades desea vender:");
			etiqueta.setFont(new Font(16));
			subcontenedor1.getChildren().add(etiqueta);
			
			HBox subcontenedor2 = new HBox();
			subcontenedor2 = new HBox();
			subcontenedor2.setAlignment(Pos.CENTER);
			subcontenedor2.setSpacing(10);
			
			
			contenedor.setPadding(new Insets(25));
			contenedor.setSpacing(25);
			contenedor.getChildren().addAll(subcontenedor1, subcontenedor2);
			ventana.setScene(escena);
			ventana.setTitle("Sus propiedades");
			
			for(Propiedad propiedad: jugador.getAdquiridos().propiedades()) {
				
				Button boton = new Button(propiedad.getNombre());
				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, jugador, propiedad));
				subcontenedor2.getChildren().add(boton);
			}
			
			for(Servicio servicio: jugador.getAdquiridos().servicios()) {
				
				Button boton = new Button(servicio.getNombre());
				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, jugador, servicio));
				subcontenedor2.getChildren().add(boton);
			}
			
			ventana.show();
		}
		

	}

}
