package vistas;

import java.util.ArrayList;
import java.util.LinkedList;

import controladores.BotonTerminarEventHandler;
import controladores.BotonTirarDadosEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorJuego extends BorderPane{
	
	private VBox contenedorBotones;
	private CanvasTablero canvasTablero;
	private CajaJugadores contenedorJugadores;
	private LinkedList<VistaJugador> jugadores;
	private int numeroJugadorActual;
	private VistaJugador vistaJugadorActual;

	public ContenedorJuego(Stage stage, int cantidadJugadores) {
	
		this.jugadores = new LinkedList<VistaJugador>();
		this.numeroJugadorActual = 0;
		this.setBordeJugadores(cantidadJugadores);
		this.setTableroDeJuego();
		this.setBotonera();

	}

	private void setBotonera() {
		
		//Seteo de botones
		BotonTirarDados botonTirarDados = new BotonTirarDados();
		Button botonVender = new Button("Vender propiedad");
		Button botonComprar = new Button("Comprar propiedad");
		Button botonPagarFianza = new Button("Pagar fianza");
		Button botonTerminar = new Button ("Terminar turno");
		BotonGanar ganar = new BotonGanar();
		botonTerminar.setDisable(true);
		
		BotonTerminarEventHandler botonTerminarEventHandler = new BotonTerminarEventHandler(botonTirarDados, botonTerminar);
		botonTerminar.setOnAction(botonTerminarEventHandler);
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler(jugadores, botonTirarDados, botonTerminar);
		botonTirarDados.setOnAction(botonTirarDadosEventHandler);
		
		//Contenedor de botones
		contenedorBotones = new VBox();
		contenedorBotones.setSpacing(20);
		contenedorBotones.setPadding(new Insets(20));
		contenedorBotones.getChildren().addAll(botonTirarDados, botonVender, botonComprar, botonPagarFianza, botonTerminar, ganar);
		
		this.setRight(contenedorBotones);
		
	}

	private void setTableroDeJuego() {
		
				
		// Seteo de imagen de tablero
				
		Image fondo = new Image("file:src/vistas/imagenes/bg2.jpg");
		BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		//Seteo del Canvas
		this.canvasTablero = new CanvasTablero(800,800);
		GraphicsContext gc = canvasTablero.getGraphicsContext2D();
		VistaTablero vistaTablero = canvasTablero.getVistaTablero();
		
		jugadores.add(new VistaJugador(gc, vistaTablero, Color.RED, 1));
		jugadores.add(new VistaJugador(gc, vistaTablero, Color.BLUE, 2));
		jugadores.add(new VistaJugador(gc,vistaTablero, Color.GREEN, 3));

		vistaJugadorActual = jugadores.get(0);
		
		jugadores.get(0).dibujar();
		jugadores.get(1).dibujar();
		jugadores.get(2).dibujar();
		
		
		
		//Contenedor (VBox) de la pantalla de tablero
		VBox contenedorTablero = new VBox();
		contenedorTablero.setAlignment(Pos.CENTER);
		contenedorTablero.setBackground(new Background(imagenFondo));
		contenedorTablero.getChildren().add(canvasTablero);

		this.setCenter(contenedorTablero);
		
	}

	private void setBordeJugadores(int cantidadJugadores) {
		
		//Contenedor de jugadores (piezas)
		this.contenedorJugadores = new CajaJugadores(cantidadJugadores);
		
		//Seteo de fondo del borde
		Image fondoIzq = new Image("file:src/vistas/imagenes/bg1.jpg");
		BackgroundImage imagenFondoIzq = new BackgroundImage(fondoIzq, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorJugadores.setBackground(new Background(imagenFondoIzq));
		
		this.setLeft(contenedorJugadores);
		
	}

	public void setVistaJugadorActual(VistaJugador vistaJugador) {

		vistaJugadorActual = vistaJugador;
		
	}

	public VistaJugador getVistaJugadorActual() {

		return vistaJugadorActual;
	}
	
}
