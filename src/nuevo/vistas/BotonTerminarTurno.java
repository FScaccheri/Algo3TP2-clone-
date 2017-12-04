package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;

public class BotonTerminarTurno extends Button implements Vista{
	
	public BotonTerminarTurno() {
		this.setText("Terminar turno");
	}
	
	@Override
	public void actualizar() {
		this.setDisable(!AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
