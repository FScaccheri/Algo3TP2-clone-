package vistas;

import controladores.BotonJugarEventHandler;
import controladores.BotonSalidaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox{
	
	private Button botonJugar;
	private Button botonSalida;

	public ContenedorBienvenida(Stage stage, Scene escenaPrincipal) {
		
		// Seteo de botones del VBox
		this.botonJugar = new Button("Jugar!");
		botonJugar.setAlignment(Pos.CENTER);
		botonJugar.setPrefSize(100, 50);
		botonJugar.setFont(Font.font("Arial", FontWeight.BOLD , 15));
		
		this.botonSalida = new Button("Salir");
		botonSalida.setAlignment(Pos.CENTER);
		
		// Seteo de Handlers
		BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, escenaPrincipal);
		botonJugar.setOnAction(botonJugarEventHandler);
				
		BotonSalidaEventHandler botonSalidaEventHandler = new BotonSalidaEventHandler();
		botonSalida.setOnAction(botonSalidaEventHandler);
	
		// Seteo del VBox (posicion e imagen de fondo)
		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(30);
		this.setPadding(new Insets(100));
		this.getChildren().addAll(botonJugar, botonSalida);
		Image imagen = new Image("file:src/vistas/imagenes/logo1.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));

	}
}