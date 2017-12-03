package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;

public class BotonTirarDados extends Button implements Vista{
	
	public BotonTirarDados() {		
		this.setText("Tirar dados");
	}

	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 		
	}

}
