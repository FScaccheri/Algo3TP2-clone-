package nuevo.controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.casilleros.adquiribles.Propiedad;
import nuevo.vistas.BotonEdificarPropiedadEspecifica;

public class BotonEdificarEventHandler implements EventHandler<ActionEvent>{
	
	@Override
	public void handle(ActionEvent event) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		Jugador jugador = algoPoly.getJugadorActual();
		LinkedList<Propiedad> propiedades = algoPoly.getPropiedadesDeJugador(jugador);

		if (propiedades.isEmpty()) {			
			Alert alerta1 = new Alert(AlertType.WARNING);
			alerta1.setHeaderText("Edificacion no realizada");
			alerta1.setContentText("No tiene propiedades para edificar!");
			alerta1.show();
			
		}else {
			Stage ventana = new Stage();
			VBox contenedor = new VBox();
			Scene escena = new Scene(contenedor, 400, 200);
			
			VBox subcontenedor1 = new VBox();
			subcontenedor1.setAlignment(Pos.CENTER);
			Label etiqueta = new Label("Elija que propiedades desea edificar:");
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
			ventana.setTitle("Sus propiedades edificables");
			
			for(Propiedad propiedad:propiedades) {
				if((propiedad.puedeCostruirCasa()) || (propiedad.puedeCostruirHotel())){
					BotonEdificarPropiedadEspecifica boton = new BotonEdificarPropiedadEspecifica(propiedad);
				boton.setOnAction(new BotonEdificarUnaPropiedadEventHandler(propiedad));
				algoPoly.agregarAListaDeVistas(boton);
				
				subcontenedor2.getChildren().add(boton);
				ventana.show();
				}
			}
			if(contenedor.getChildren().isEmpty()) {
				
				Alert alerta2 = new Alert(AlertType.WARNING);
				alerta2.setHeaderText("Edificacion no realizada");
				alerta2.setContentText("No tiene propiedades para edificar!");
				alerta2.show();
			}
			
			algoPoly.actualizar();
		}
	}

}
