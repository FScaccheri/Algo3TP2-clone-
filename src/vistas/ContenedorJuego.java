package vistas;

import java.util.LinkedList;
import controladores.BotonComprarEventHandler;
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
import modelo.AvanceDinamico;
import modelo.Carcel;
import modelo.Casillero;
import modelo.ImpuestoAlLujo;
import modelo.Jugador;
import modelo.Policia;
import modelo.Propiedad;
import modelo.Quini6;
import modelo.RetrocesoDinamico;
import modelo.Salida;
import modelo.Servicio;
import modelo.Tablero;

public class ContenedorJuego extends BorderPane{
	
	private VBox contenedorBotones;
	private CanvasTablero canvasTablero;
	private CajaJugadores contenedorJugadores;
	private LinkedList<VistaJugador> vistasJugadores;
	private LinkedList<Jugador> jugadores;
	private VistaJugador vistaJugadorActual;
	private Tablero tablero;

	public ContenedorJuego(Stage stage, int cantidadJugadores) {
	
		this.vistasJugadores = new LinkedList<VistaJugador>();
		this.jugadores = new LinkedList<Jugador>();
		this.tablero = Tablero.getInstancia();
		this.crearTablero();
		this.crearListaDeJugadores();
		this.setBordeJugadores(cantidadJugadores);
		this.setTableroDeJuego();
		this.setBotonera(vistaJugadorActual);

	}

	private void crearTablero() {
		
		Propiedad BsAsSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Propiedad BsAsNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad CordobaSur = new Propiedad(18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Propiedad CordobaNorte = new Propiedad(20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Propiedad SantaFe = new Propiedad(15000, 1500, 3500, 4000);
		Propiedad SaltaNorte = new Propiedad(23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Propiedad SaltaSur = new Propiedad(23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Propiedad Neuquen = new Propiedad(17000, 1800, 3800, 4800);
		Propiedad Tucuman = new Propiedad(25000, 2500, 4500, 7000);
		
		Servicio EDESUR = new Servicio(35000, 500, 1000);
		Servicio SUBTE = new Servicio(40000, 600, 1100);
		Servicio AYSA = new Servicio(30000, 300, 500);
		Servicio TRENES = new Servicio(38000, 450, 800);
		
		EDESUR.asociar(AYSA);
		SUBTE.asociar(TRENES);
																					// Casillero numero:
		tablero.agregar(new Casillero(new Salida()));												//1
		tablero.agregar(new Casillero(new Quini6()));												//2
		tablero.agregar(new Casillero(BsAsSur));													//3
		tablero.agregar(new Casillero(EDESUR));														//4
		tablero.agregar(new Casillero(BsAsNorte));													//5
		tablero.agregar(new Casillero(new Carcel()));												//6
		tablero.agregar(new Casillero(CordobaSur));													//7
		tablero.agregar(new Casillero(new AvanceDinamico()));										//8
		tablero.agregar(new Casillero(SUBTE));														//9
		tablero.agregar(new Casillero(CordobaNorte));												//10
		tablero.agregar(new Casillero(new ImpuestoAlLujo()));										//11
		tablero.agregar(new Casillero(SantaFe));													//12
		tablero.agregar(new Casillero(AYSA));														//13
		tablero.agregar(new Casillero(SaltaNorte));													//14
		tablero.agregar(new Casillero(SaltaSur));													//15
		tablero.agregar(new Casillero(new Policia(tablero.getCasilleros().get(5).getPosicion())));	//16
		tablero.agregar(new Casillero(TRENES));														//17
		tablero.agregar(new Casillero(Neuquen));													//18
		tablero.agregar(new Casillero(new RetrocesoDinamico()));									//19
		tablero.agregar(new Casillero(Tucuman));													//20
		
		for (int i = 0; i < 20; i++) {
			
			tablero.agregar(tablero.getCasilleros().get(i));
		}
		
		
	}

	private void crearListaDeJugadores() {
		
		for (int i = 0; i < 3; i++) {

			Jugador unJugador = new Jugador();
			unJugador.setPosicion(tablero.getCasilleros().get(0).getPosicion());
			jugadores.add(unJugador);
			
		}
		
	}

	private void setBotonera(VistaJugador vistaJugadorActual) {
		
		//Seteo de botones
		BotonTirarDados botonTirarDados = new BotonTirarDados();
		Button botonVender = new Button("Vender propiedad");
		Button botonComprar = new Button("Comprar propiedad");
		Button botonPagarFianza = new Button("Pagar fianza");
		Button botonTerminar = new Button ("Terminar turno");
		BotonGanar ganar = new BotonGanar();
		botonPagarFianza.setDisable(true);
		botonTerminar.setDisable(true);
		
		GraphicsContext gc = canvasTablero.getGraphicsContext2D();
		BotonComprarEventHandler botonComprarEventHandler = new BotonComprarEventHandler(this, gc, botonComprar);
		botonComprar.setOnAction(botonComprarEventHandler);
		
		BotonTerminarEventHandler botonTerminarEventHandler = new BotonTerminarEventHandler(this, vistasJugadores, botonTirarDados, botonTerminar);
		botonTerminar.setOnAction(botonTerminarEventHandler);
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler(this, vistaJugadorActual, botonTirarDados, botonComprar, botonTerminar);
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
		
		vistasJugadores.add(new VistaJugador(gc, jugadores, vistaTablero, Color.RED, 1));
		vistasJugadores.add(new VistaJugador(gc, jugadores, vistaTablero, Color.BLUE, 2));
		vistasJugadores.add(new VistaJugador(gc, jugadores, vistaTablero, Color.GREEN, 3));

		vistaJugadorActual = vistasJugadores.get(0);
		
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
