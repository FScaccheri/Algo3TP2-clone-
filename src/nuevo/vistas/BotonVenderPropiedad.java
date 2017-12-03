package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AdministradorDeTurnos;
import modelo.AlgoPoly;
import modelo.Vista;

public class BotonVenderPropiedad extends Button implements Vista{
	
	public BotonVenderPropiedad() {		
		this.setText("Vender propiedad");
	}
	
	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
