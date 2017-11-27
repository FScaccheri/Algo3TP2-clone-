package vistas;

import java.util.LinkedList;
import controladores.BotonComprarEventHandler;
import controladores.BotonEdificarEventHandler;
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
import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.ImpuestoAlLujo;
import modelo.casilleros.Policia;
import modelo.casilleros.Quini6;
import modelo.casilleros.RetrocesoDinamico;
import modelo.casilleros.Salida;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import modelo.casilleros.movimiento.AvanceDinamico;

public class ContenedorJuego extends BorderPane{
	
	private VBox contenedorBotones;
	private CanvasTablero canvasTablero;
	private CajaJugadores contenedorJugadores;
	private LinkedList<VistaJugador> vistasJugadores;
	private LinkedList<Jugador> jugadores;
	private VistaJugador vistaJugadorActual;
	private Jugador jugadorActual;
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
		tablero.agregar(new Casillero("Salida", new Salida()));												//1
		tablero.agregar(new Casillero("Quini6", new Quini6()));												//2
		tablero.agregar(new Casillero("BsAs Sur", BsAsSur, 2));													//3
		tablero.agregar(new Casillero("EDESUR", EDESUR));														//4
		tablero.agregar(new Casillero("BsAs Norte", BsAsNorte, 4));													//5
		tablero.agregar(new Casillero("Carcel", new Carcel()));												//6
		tablero.agregar(new Casillero("Cordoba Sur", CordobaSur, 6));													//7
		tablero.agregar(new Casillero("Avance dinamico", new AvanceDinamico()));										//8
		tablero.agregar(new Casillero("SUBTE", SUBTE));														//9
		tablero.agregar(new Casillero("Cordoba Norte", CordobaNorte, 9));												//10
		tablero.agregar(new Casillero("Impuesto de Lujo", new ImpuestoAlLujo()));										//11
		tablero.agregar(new Casillero("Santa Fe", SantaFe, 11));													//12
		tablero.agregar(new Casillero("AYSA", AYSA));														//13
		tablero.agregar(new Casillero("Salta Norte", SaltaNorte, 13));													//14
		tablero.agregar(new Casillero("Salta Sur", SaltaSur, 14));													//15
		tablero.agregar(new Casillero("Policia", new Policia(tablero.getCasilleros().get(5).getPosicion())));	//16
		tablero.agregar(new Casillero("TRENES", TRENES));														//17
		tablero.agregar(new Casillero("Neuquen", Neuquen, 17));													//18
		tablero.agregar(new Casillero("Retroceso dinamico", new RetrocesoDinamico()));									//19
		tablero.agregar(new Casillero("Tucuman", Tucuman, 18));													//20
		
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
		
		jugadorActual = jugadores.get(0);
		
	}

	private void setBotonera(VistaJugador vistaJugadorActual) {
		
		//Seteo de botones
		BotonTirarDados botonTirarDados = new BotonTirarDados();
		Button botonVender = new Button("Vender propiedad");
		Button botonEdificar = new Button("Edificar");
		Button botonComprar = new Button("Comprar propiedad");
		Button botonPagarFianza = new Button("Pagar fianza");
		Button botonTerminar = new Button ("Terminar turno");
		BotonGanar ganar = new BotonGanar();
		botonPagarFianza.setDisable(true);
		botonTerminar.setDisable(true);
		
		GraphicsContext gc = canvasTablero.getGraphicsContext2D();
		
		BotonComprarEventHandler botonComprarEventHandler = new BotonComprarEventHandler(this, gc, botonComprar);
		botonComprar.setOnAction(botonComprarEventHandler);
		
		BotonEdificarEventHandler botonEdificarEventHandler = new BotonEdificarEventHandler(this, tablero);
		botonEdificar.setOnAction(botonEdificarEventHandler);
		
		BotonTerminarEventHandler botonTerminarEventHandler = new BotonTerminarEventHandler(this, vistasJugadores, botonTirarDados, botonTerminar);
		botonTerminar.setOnAction(botonTerminarEventHandler);
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler(this, vistaJugadorActual, botonTirarDados, botonComprar, botonTerminar);
		botonTirarDados.setOnAction(botonTirarDadosEventHandler);
		
		//Contenedor de botones
		contenedorBotones = new VBox();
		contenedorBotones.setSpacing(20);
		contenedorBotones.setPadding(new Insets(20));
		contenedorBotones.getChildren().addAll(botonTirarDados, botonVender, botonEdificar, botonComprar, botonPagarFianza, botonTerminar, ganar);
		
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
	
	public void setJugadorActual(Jugador jugador) {
		
		jugadorActual = jugador;
	}
	
	public Jugador getJugadorActual() {
		
		return jugadorActual;
	}
}
