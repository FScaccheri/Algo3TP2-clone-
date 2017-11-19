package vistas;

import controladores.BotonJugarEventHandler;
import controladores.BotonSalidaEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AplicacionAP extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("AlgoPoly - Grupo 3(?)");
		
		// Seteo del contenedor (VBox) de la pantalla de bienvenida
		Button botonJugar = new Button("Jugar!");
		botonJugar.setAlignment(Pos.CENTER);
		botonJugar.setPrefSize(100, 50);
		botonJugar.setFont(Font.font("Arial", FontWeight.BOLD , 15));
		Button botonSalida = new Button("Salir");
		botonSalida.setAlignment(Pos.CENTER);
		
		VBox contenedorBienvenida = new VBox();
		contenedorBienvenida.setAlignment(Pos.BOTTOM_CENTER);
		contenedorBienvenida.setSpacing(30);
		contenedorBienvenida.setPadding(new Insets(100));
		contenedorBienvenida.getChildren().addAll(botonJugar, botonSalida);
		Image imagen = new Image("file:src/vistas/imagenes/logo1.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		contenedorBienvenida.setBackground(new Background(imagenDeFondo));
		
		Scene escenaBienvenida=  new Scene(contenedorBienvenida, 1000, 700);	
		
		
		
		// Contenedor (BorderPane) de la pantalla de juego
		BorderPane contenedorJuego = new BorderPane();
		Scene escenaPrincipal = new Scene(contenedorJuego , 1000, 700);
		//Contenedor (VBox) de la pantalla de tablero
		VBox contenedorTablero = new VBox();
		// Seteo de imagen de fondo (tablero)
		Image tablero = new Image("file:src/vistas/imagenes/monopoly board.jpg");
		BackgroundImage imagenTablero = new BackgroundImage(tablero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		// Seteo de imagenes de jugadores (sus piezas)
		Image imagenPieza = new Image("file:src/vistas/imagenes/monopoly racecar.jpg");
		ImageView vistaPieza = new ImageView();
		vistaPieza.setImage(imagenPieza);
		contenedorTablero.setBackground(new Background(imagenTablero));
		contenedorTablero.getChildren().add(vistaPieza);
		contenedorJuego.setCenter(contenedorTablero);
		
		
		// Seteo de Handlers
		BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, escenaPrincipal);
		botonJugar.setOnAction(botonJugarEventHandler);
		
		BotonSalidaEventHandler botonSalidaEventHandler = new BotonSalidaEventHandler();
		botonSalida.setOnAction(botonSalidaEventHandler);
		
	
		stage.setScene(escenaBienvenida);
		
		stage.show();
		
	}
	
}