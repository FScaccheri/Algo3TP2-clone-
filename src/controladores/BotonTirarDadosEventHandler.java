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
	private Button botonTerminar;
	private int jugadorActual;
	private boolean huboDobles;
	
	public BotonTirarDadosEventHandler(LinkedList<VistaJugador> jugadores, Button botonTirarDados, Button botonTerminar) {
		
		
		this.jugadores = jugadores;
		this.jugadorActual = 0;
		this.huboDobles = false;
		this.botonTirar = botonTirarDados;
		this.botonTerminar = botonTerminar;
	}
	@Override
	public void handle(ActionEvent event) {

		int tirada = Tirada.tirar();
		
		if(huboDobles) {
			
			huboDobles = false;
			
		} else {

			huboDobles = Tirada.fueDoble();
		}
		
		jugadores.get(jugadorActual).avanzar(tirada);
		
		
		if(!huboDobles) {
			
			jugadorActual++;
			
			if(jugadorActual > 2)
			
				jugadorActual = 0;
		
			botonTirar.setDisable(true);
			botonTerminar.setDisable(false);
		
		}
	}

}
