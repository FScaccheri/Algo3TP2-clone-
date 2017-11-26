package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import modelo.Tirada;
import vistas.VistaJugador;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private LinkedList<VistaJugador> jugadores;
	private Button botonTirar;
	private Button botonComprar;
	private Button botonTerminar;
	private boolean huboDobles;
	private VistaJugador jugador;
	private int numeroJugador;
	
	public BotonTirarDadosEventHandler(LinkedList<VistaJugador> jugadores, VistaJugador vistaJugadorActual, Button botonTirarDados, Button botonComprar, Button botonTerminar) {
		
		
		this.jugadores = jugadores;
		this.jugador = vistaJugadorActual;
		this.numeroJugador = 0;
		//this.numeroJugador = jugadores.indexOf(vistaJugadorActual);
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonComprar = botonComprar;
		this.botonTerminar = botonTerminar;
	}
	@Override
	public void handle(ActionEvent event) {

		System.out.println("" + jugador);
		int tirada = Tirada.tirar();
		
		if(huboDobles) {
			
			huboDobles = false;
			
		} else {

			huboDobles = Tirada.fueDoble();
		}
		
		//jugadores.get(jugadorActual).avanzar(tirada);
		jugador.avanzar(tirada);
		
		
		if(!huboDobles) {
			
			numeroJugador++;
			
			if(numeroJugador > 2)
			
				numeroJugador = 0;
			
			jugador = jugadores.get(numeroJugador);
			
			botonTirar.setDisable(true);
			botonComprar.setDisable(false);
			botonTerminar.setDisable(false);
		
		}
	}

}
