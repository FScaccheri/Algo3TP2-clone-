package nuevo.vistas;

import java.util.ArrayList;
import java.util.LinkedList;
import nuevo.controladores.BotonComprarEventHandler;
import nuevo.controladores.BotonEdificarEventHandler;
import nuevo.controladores.BotonPagarFianzaEventHandler;
import nuevo.controladores.BotonTerminarEventHandler;
import nuevo.controladores.BotonTirarDadosEventHandler;
import nuevo.controladores.BotonVenderEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
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
import modelo.AlgoPoly;
import modelo.Jugador;

public class ContenedorJuego extends BorderPane{
	
	private VBox contenedorBotones;
	private CanvasTablero canvasTablero;
	private CajaJugadores contenedorJugadores;
	private LinkedList<VistaJugador> vistasJugadores;
	private VistaJugador vistaJugadorActual;

	public ContenedorJuego(Stage stage, int cantidadJugadores) {
	
		this.vistasJugadores = new LinkedList<VistaJugador>();
		this.setBordeJugadores(cantidadJugadores);
		this.setTableroDeJuego();
		this.setBotonera(vistaJugadorActual);

	}

	private void setBotonera(VistaJugador vistaJugadorActual) {
		
		//Seteo de botones
		BotonTirarDados botonTirarDados = new BotonTirarDados();
		BotonVenderPropiedad botonVender = new BotonVenderPropiedad();
		BotonEdificar botonEdificar = new BotonEdificar();
		BotonComprarPropiedad botonComprar = new BotonComprarPropiedad();
		BotonPagarFianza botonPagarFianza = new BotonPagarFianza();
		BotonTerminarTurno botonTerminar = new BotonTerminarTurno();
		BotonGanar botonGanar = new BotonGanar();
				
		//GraphicsContext gc = canvasTablero.getGraphicsContext2D();
		
		BotonComprarEventHandler botonComprarEventHandler = new BotonComprarEventHandler();
		botonComprar.setOnAction(botonComprarEventHandler);
		
		BotonVenderEventHandler botonVenderEventHandler = new BotonVenderEventHandler();
		botonVender.setOnAction(botonVenderEventHandler);
		
		BotonEdificarEventHandler botonEdificarEventHandler = new BotonEdificarEventHandler();
		botonEdificar.setOnAction(botonEdificarEventHandler);
		
		BotonPagarFianzaEventHandler botonPagarFianzaEventHandler = new BotonPagarFianzaEventHandler();
		botonPagarFianza.setOnAction(botonPagarFianzaEventHandler);
		
		BotonTerminarEventHandler botonTerminarEventHandler = new BotonTerminarEventHandler();
		botonTerminar.setOnAction(botonTerminarEventHandler);
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler();
		botonTirarDados.setOnAction(botonTirarDadosEventHandler);
		
		//Contenedor de botones
		contenedorBotones = new VBox();
		contenedorBotones.setSpacing(20);
		contenedorBotones.setPadding(new Insets(20));
		contenedorBotones.getChildren().addAll(botonTirarDados, botonVender, botonEdificar, botonComprar, botonPagarFianza, botonTerminar, botonGanar);
		
		this.setRight(contenedorBotones);
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.agregarAListaDeVistas(botonTirarDados);
		algoPoly.agregarAListaDeVistas(botonVender);
		algoPoly.agregarAListaDeVistas(botonEdificar);
		algoPoly.agregarAListaDeVistas(botonComprar);
		algoPoly.agregarAListaDeVistas(botonPagarFianza);
		algoPoly.agregarAListaDeVistas(botonTerminar);
		algoPoly.agregarAListaDeVistas(botonGanar);
	}

	private void setTableroDeJuego() {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		
		// Seteo de imagen de tablero
				
		Image fondo = new Image("file:src/nuevo/vistas/imagenes/bg2.jpg");
		BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		//Seteo del Canvas
		canvasTablero = new CanvasTablero(800,800);
		GraphicsContext gc = canvasTablero.getGraphicsContext2D();
		
		VistaTablero vistaTablero = new VistaTablero(gc);
		vistaTablero.pintarTablero();

		algoPoly.agregarAListaDeVistas(canvasTablero);
		algoPoly.agregarAListaDeVistas(vistaTablero);
		
		ArrayList<Jugador> jugadores = algoPoly.getJugadores();
		IteradorDeColores colores = new IteradorDeColores();
		
		for(Jugador jugador:jugadores) {
			VistaJugador vistaJugador = new VistaJugador(gc, jugador, vistaTablero, colores.getSiguienteColor());
			vistasJugadores.add(vistaJugador);
			vistaTablero.agregarVistaJugador(vistaJugador);
			algoPoly.agregarAListaDeVistas(vistaJugador);			
		}

		setVistaJugadorActual(vistasJugadores.get(0));
		
		vistasJugadores.get(0).dibujar();
		vistasJugadores.get(1).dibujar();
		vistasJugadores.get(2).dibujar();

		
		//Contenedor (VBox) de la pantalla de tablero
		VBox contenedorTablero = new VBox();
		contenedorTablero.setAlignment(Pos.CENTER);
		contenedorTablero.setBackground(new Background(imagenFondo));
		contenedorTablero.getChildren().add(canvasTablero);

		this.setCenter(contenedorTablero);
		
	}

	public void setBordeJugadores(int cantidadJugadores) {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		CajaJugadores cajaJugadores = new CajaJugadores(algoPoly.getJugadores());
		algoPoly.agregarAListaDeVistas(cajaJugadores);
		
		//Contenedor de jugadores (piezas)
		this.contenedorJugadores = cajaJugadores;
		
		//Seteo de fondo del borde
		Image fondoIzq = new Image("file:src/nuevo/vistas/imagenes/bg1.jpg");
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
	
	
	public CanvasTablero getCanvasTablero() {
		
		return canvasTablero;
	}
	
	private class IteradorDeColores{
		private ArrayList<Color> colores;
		private int colorActual;
		
		public IteradorDeColores() {
			colorActual = -1;
			colores = new ArrayList<Color>();
			colores.add(Color.RED);
			colores.add(Color.BLUE);
			colores.add(Color.GREEN);
			colores.add(Color.YELLOW);
		}
		
		public Color getSiguienteColor() {
			colorActual++;
			return colores.get(colorActual);
		}
		
	}
}

