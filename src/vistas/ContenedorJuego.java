package vistas;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane{
	
	public ContenedorJuego(Stage stage) {
		
		//Contenedor (VBox) de la pantalla de tablero
		VBox contenedorTablero = new VBox();
		
		//Contenedor de botones
		VBox contenedorBotones = new VBox();
	
		// Seteo de imagen de fondo (tablero)
		Image tablero = new Image("file:src/vistas/imagenes/monopoly board.jpg");
		BackgroundImage imagenTablero = new BackgroundImage(tablero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	
		// Seteo de imagenes de jugadores (sus piezas)
		Image imagenPieza = new Image("file:src/vistas/imagenes/monopoly racecar.jpg");
		ImageView vistaPieza = new ImageView(imagenPieza);
		contenedorTablero.setBackground(new Background(imagenTablero));
		contenedorTablero.getChildren().add(vistaPieza);
		
		//Seteo de botones
		Button botonTirarDados = new Button("Tirar dados");
		Button botonComprar = new Button("Comprar propiedad");
		Button botonVender = new Button("Vender propiedad");
		Button botonPagarFianza = new Button("Pagar fianza");
		Button botonTerminar = new Button ("Terminar turno");
		
		contenedorBotones.setSpacing(15);
		contenedorBotones.setPadding(new Insets(20));
		
		contenedorBotones.getChildren().addAll(botonTirarDados, botonComprar, botonVender, botonPagarFianza, botonTerminar);
		
		
		this.setCenter(contenedorTablero);
		this.setRight(contenedorBotones);
		
		
		
	}
	
}
