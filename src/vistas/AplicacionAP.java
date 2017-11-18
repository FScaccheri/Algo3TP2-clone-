package vistas;

import controladores.BotonJugarEventHandler;
import controladores.BotonSalidaEventHandler;
import javafx.application.Application;
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

public class AplicacionAP extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("AlgoBay - Grupo 3(?)");
		
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
		
		stage.setScene(escenaBienvenida);
		
		
		VBox contenedorPrincipal = new VBox();
		Scene escenaPrincipal = new Scene(contenedorPrincipal , 1000, 700);
		
		BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, escenaPrincipal);
		botonJugar.setOnAction(botonJugarEventHandler);
		
		BotonSalidaEventHandler botonSalidaEventHandler = new BotonSalidaEventHandler();
		botonSalida.setOnAction(botonSalidaEventHandler);
		
	
		
		
		stage.show();
		
	}
	
}