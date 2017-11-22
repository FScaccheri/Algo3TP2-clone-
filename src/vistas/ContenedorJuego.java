package vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane{
	
	public ContenedorJuego(Stage stage) {
		
		this.setBordeJugadores();
		this.setTableroDeJuego();
		this.setBotonera();

	}

	private void setBotonera() {
		
		
		
		//Seteo de botones
		Button botonTirarDados = new Button("Tirar dados");
		Button botonComprar = new Button("Comprar propiedad");
		Button botonVender = new Button("Vender propiedad");
		Button botonPagarFianza = new Button("Pagar fianza");
		Button botonTerminar = new Button ("Terminar turno");
		
		//Boton para testeo de sonidos
		BotonGanar ganar = new BotonGanar("Ganar");
		
		//Contenedor de botones
		VBox contenedorBotones = new VBox();
		contenedorBotones.setSpacing(20);
		contenedorBotones.setPadding(new Insets(20));
				
		contenedorBotones.getChildren().addAll(botonTirarDados, botonComprar, botonVender, botonPagarFianza, botonTerminar, ganar);
		
		this.setRight(contenedorBotones);
		
	}

	private void setTableroDeJuego() {
		
				
		// Seteo de imagen de tablero
				
		Image fondo = new Image("file:src/vistas/imagenes/bg2.jpg");
		BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		//Seteo del Canvas
		Canvas canvas = new Canvas(700,700);
		canvas.getGraphicsContext2D().setFill(Color.BISQUE);
		canvas.getGraphicsContext2D().fillRect(0, 0, 700, 700);
		
		//Contenedor (VBox) de la pantalla de tablero
		VBox contenedorTablero = new VBox();
		contenedorTablero.setAlignment(Pos.CENTER);
		contenedorTablero.setBackground(new Background(imagenFondo));
		contenedorTablero.getChildren().add(canvas);

		this.setCenter(contenedorTablero);
		
	}

	private void setBordeJugadores() {
		
		
		//Fuente de etiquetas
		Font fuente = Font.font("", FontWeight.BOLD, 20);
		
		// Seteo de imagenes de jugadores (sus piezas)
		Image imagenPieza1 = new Image("file:src/vistas/imagenes/racecar.jpg", 100, 100, true, false);
		ImageView vistaPieza1 = new ImageView(imagenPieza1);
		Label etiqueta1 = new Label ("Jugador 1");
		etiqueta1.setTextFill(Color.web("#DC143C"));
		etiqueta1.setFont(fuente);

		Image imagenPieza2 = new Image("file:src/vistas/imagenes/battleship.jpg", 100, 100, true, false);
		ImageView vistaPieza2 = new ImageView(imagenPieza2);
		Label etiqueta2 = new Label("Jugador 2");
		etiqueta2.setTextFill(Color.web("#0000CD"));
		etiqueta2.setFont(fuente);
		vistaPieza2.setTranslateY(200);
		etiqueta2.setTranslateY(200);
		
		Image imagenPieza3 = new Image("file:src/vistas/imagenes/tophat.jpg", 100, 100, true, false);
		ImageView vistaPieza3 = new ImageView(imagenPieza3);
		Label etiqueta3 = new Label("Jugador 3");
		etiqueta3.setTextFill(Color.web("#3D9140"));
		etiqueta3.setFont(fuente);
		vistaPieza3.setTranslateY(400);
		etiqueta3.setTranslateY(400);
		
		//Contenedor de jugadores (piezas)
		VBox contenedorImagenes = new VBox();
		contenedorImagenes.setAlignment(Pos.TOP_CENTER);
		contenedorImagenes.setSpacing(5);
		contenedorImagenes.setPadding(new Insets(20));
		contenedorImagenes.getChildren().addAll(vistaPieza1, etiqueta1, vistaPieza2, etiqueta2, vistaPieza3, etiqueta3);
		
		//Seteo de fondo del borde
		Image fondoIzq = new Image("file:src/vistas/imagenes/bg1.jpg");
		BackgroundImage imagenFondoIzq = new BackgroundImage(fondoIzq, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorImagenes.setBackground(new Background(imagenFondoIzq));
		
		this.setLeft(contenedorImagenes);
		
	}
	
}
