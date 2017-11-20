package vistas;

import javafx.application.Application;
import javafx.scene.Scene;
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

public class AplicacionAP extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("AlgoPoly - Grupo 3(?)");
		
	
		ContenedorJuego contenedorJuego = new ContenedorJuego(stage);
		Scene escenaPrincipal = new Scene(contenedorJuego , 1000, 700);
		
		ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, escenaPrincipal);
		Scene escenaBienvenida =  new Scene(contenedorBienvenida, 1000, 700);	
		
		stage.setScene(escenaBienvenida);
		
		stage.show();
		
	}
	
}