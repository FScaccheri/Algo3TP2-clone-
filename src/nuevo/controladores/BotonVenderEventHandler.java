package nuevo.controladores;


import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import nuevo.vistas.ContenedorJuego;

public class BotonVenderEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private ContenedorJuego contenedorJuego;

	public BotonVenderEventHandler() {
		this.contenedorJuego = contenedorJuego;
	}
	
	@Override
	public void handle(ActionEvent event) {
//
//		jugador = contenedorJuego.getJugadorActual();
//		Stage ventana = new Stage();
//		HBox contenedor = new HBox();
//		Scene escena = new Scene(contenedor);
//		// Cambiar el contenedor a un contenedor(root/ VBox) principal y agregar dos subcontenedores
//		// (roots/ HBox) distintos. @FScaccheri
//		contenedor.setPadding(new Insets(25));
//		ventana.setScene(escena);
//		ventana.setTitle("Sus propiedades");
//		
//		if ((jugador.getAdquiridos().propiedades().isEmpty()) && (jugador.getAdquiridos().servicios().isEmpty())) {
//			
//			Alert alerta = new Alert(AlertType.WARNING);
//			alerta.setHeaderText("Venta no realizada");
//			alerta.setContentText("No tiene propiedades para vender!");
//			alerta.show();
//		}
//		
//		else {
//			
//			for(int i = 0; i < jugador.getAdquiridos().propiedades().size(); i++) {
//		
//
//				LinkedList<Propiedad> propiedades = jugador.getAdquiridos().propiedades();
//			
//				Propiedad unaPropiedad = propiedades.get(i);
//			
//				Button boton = new Button(unaPropiedad.getNombre());
//				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, unaPropiedad, contenedorJuego.getCanvasTablero().getVistaTablero(),contenedorJuego));
//				
//				contenedor.getChildren().add(boton);
//				ventana.show();
//			
//			}
//		
//			for(int i = 0; i < jugador.getAdquiridos().servicios().size(); i++) {
//
//				LinkedList<Servicio> servicios = jugador.getAdquiridos().servicios();
//			
//				Servicio unServicio = servicios.get(i);
//			
//				Button boton = new Button(unServicio.getNombre());
//				boton.setOnAction(new BotonVenderUnAdquiribleEventHandler(boton, unServicio, contenedorJuego.getCanvasTablero().getVistaTablero(),contenedorJuego));
//				
//				contenedor.getChildren().add(boton);
//				ventana.show();
//			
//			}
//		
//		}
	}

}
