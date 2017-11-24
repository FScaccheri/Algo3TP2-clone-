package vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AplicacionAP extends Application{
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("AlgoPoly - Grupo 3(?)");
		
	
		ContenedorJuego contenedorJuego = new ContenedorJuego(stage, 3);
		Scene escenaPrincipal = new Scene(contenedorJuego , 1200, 900);
		
		ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, escenaPrincipal);
		Scene escenaBienvenida =  new Scene(contenedorBienvenida, 1200, 900);	
		
		stage.setScene(escenaBienvenida);
		
		stage.show();
		
	}
	
}