package vistas;

import controladores.BotonTirarDadosEventHandler;
import javafx.scene.control.Button;

public class BotonTirarDados extends Button{
	
	public BotonTirarDados(VistaJugador vista) {
		
		this.setText("Tirar dados");
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler(vista);
		this.setOnAction(botonTirarDadosEventHandler);
	}

}
