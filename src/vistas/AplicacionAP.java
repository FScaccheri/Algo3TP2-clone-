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
		
		// Contenedor (BorderPane) de la pantalla de juego
		BorderPane contenedorJuego = new BorderPane();
		Scene escenaPrincipal = new Scene(contenedorJuego , 1000, 700);
		
		
		ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, escenaPrincipal);
		Scene escenaBienvenida =  new Scene(contenedorBienvenida, 1000, 700);	
		
		
		
		
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
		
		
		
	
		stage.setScene(escenaBienvenida);
		
		stage.show();
		
	}
	
}