package vistas;

import controladores.BotonTirarDadosEventHandler;
import javafx.scene.control.Button;

public class BotonTirarDados extends Button{
	
	public BotonTirarDados() {
		
		this.setText("Tirar dados");
		
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler();
		this.setOnAction(botonTirarDadosEventHandler);
	}

}
