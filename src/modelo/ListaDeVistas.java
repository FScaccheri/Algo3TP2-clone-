package modelo;

import java.util.ArrayList;

public class ListaDeVistas implements Vista{
	ArrayList<Vista> vistas;
	
	public ListaDeVistas() {
		vistas = new ArrayList<Vista>();
	}
		
	@Override
	public void actualizar() {
		for(Vista vista:vistas)
			vista.actualizar();
	}
	
	public void agregar(Vista vista) {
		vistas.add(vista);
	}

	public ArrayList<Vista> getVistas() {
		return vistas;
	}

	public void eliminar(Vista vista) {
		vistas.remove(vista);
		
	}
}
