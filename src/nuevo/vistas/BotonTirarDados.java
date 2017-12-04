package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonTirarDadosEventHandler;

public class BotonTirarDados extends Button implements Vista{
	
	public BotonTirarDados() {		
		this.setText("Tirar dados");
		BotonTirarDadosEventHandler botonTirarDadosEventHandler = new BotonTirarDadosEventHandler();
		this.setOnAction(botonTirarDadosEventHandler);
	}

	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 		
	}

}
