package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AdministradorDeTurnos;
import modelo.AlgoPoly;
import modelo.Vista;

public class BotonEdificar extends Button implements Vista{
	
	public BotonEdificar() {		
		this.setText("Edificar");
	}
	
	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
