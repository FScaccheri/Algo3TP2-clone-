package vistas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AplicacionAP extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("AlgoBay - Grupo 3(?)");
		
		Label mensaje = new Label("~~Algopoly~~");
		Button boton = new Button("Jugar");
		
		VBox contenedorBienvenida = new VBox();
		contenedorBienvenida.setAlignment(Pos.CENTER);
		contenedorBienvenida.setSpacing(50);
		contenedorBienvenida.getChildren().addAll(mensaje, boton);
		
		Scene escenaBienvenida=  new Scene(contenedorBienvenida , 700, 700);	
		
		stage.setScene(escenaBienvenida);
		
		
		
		stage.show();
		
	}
	
}