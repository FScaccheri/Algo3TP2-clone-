package vistas;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.ImpuestoAlLujo;
import modelo.casilleros.Policia;
import modelo.casilleros.Quini6;
import modelo.casilleros.Salida;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import modelo.casilleros.movimiento.AvanceDinamico;
import modelo.casilleros.movimiento.RetrocesoDinamico;

public class VistaTablero {
	
	private LinkedList<VistaCasillero> vistasCasilleros;
	private GraphicsContext gc;
	private Tablero tablero;
	
	public VistaTablero(GraphicsContext gc) {
		
		this.gc = gc;
		this.vistasCasilleros = new LinkedList<VistaCasillero>();
		this.tablero = Tablero.getInstancia();
	}

	public void pintarTablero() {
		
		vistasCasilleros.add(new VistaCasillero("SALIDA", tablero.getCasilleros().get(0), 640, 640, gc));						//1
		vistasCasilleros.add(new VistaCasillero("QUINI 6", tablero.getCasilleros().get(1), 520, 640, gc));						//2
		vistasCasilleros.add(new VistaCasillero("BS AS", "SUR", 20000, tablero.getCasilleros().get(2), 400, 640, gc));					//3
		vistasCasilleros.add(new VistaCasillero("EDESUR", 35000, tablero.getCasilleros().get(3), 280, 640, gc));						//4
		vistasCasilleros.add(new VistaCasillero("BS AS", "NORTE", 25000, tablero.getCasilleros().get(4), 160, 640, gc));				//5
		vistasCasilleros.add(new VistaCasillero("CARCEL",tablero.getCasilleros().get(5), 40, 640, gc));							//6
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "SUR", 18000, tablero.getCasilleros().get(6), 40, 520, gc));				//7
		vistasCasilleros.add(new VistaCasillero("ACANCE", "DINAMICO", tablero.getCasilleros().get(7), 40, 400, gc));			//8
		vistasCasilleros.add(new VistaCasillero("SUBTE", 40000, tablero.getCasilleros().get(8), 40, 280, gc));							//9
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "NORTE", 20000, tablero.getCasilleros().get(9), 40,160, gc));				//10
		vistasCasilleros.add(new VistaCasillero("IMPUESTO", "DE LUJO",tablero.getCasilleros().get(10), 40, 40, gc));			//11
		vistasCasilleros.add(new VistaCasillero("SANTA FE", 15000, tablero.getCasilleros().get(11), 160, 40, gc));						//12
		vistasCasilleros.add(new VistaCasillero("AYSA", 30000, tablero.getCasilleros().get(12), 280, 40, gc)); 						//13
		vistasCasilleros.add(new VistaCasillero("SALTA", "NORTE", 23000, tablero.getCasilleros().get(13), 400, 40, gc));				//14
		vistasCasilleros.add(new VistaCasillero("SALTA", "SUR", 23000, tablero.getCasilleros().get(14), 520, 40, gc));					//15
		vistasCasilleros.add(new VistaCasillero("POLICIA",tablero.getCasilleros().get(15), 640, 40, gc));						//16
		vistasCasilleros.add(new VistaCasillero("TRENES", 38000, tablero.getCasilleros().get(16), 640, 160, gc));						//17
		vistasCasilleros.add(new VistaCasillero("NEUQUEN", 17000, tablero.getCasilleros().get(17), 640, 280, gc));						//18
		vistasCasilleros.add(new VistaCasillero("RETROCESO", "DINAMICO",tablero.getCasilleros().get(18), 640, 400, gc));		//19
		vistasCasilleros.add(new VistaCasillero("TUCUMAN", 25000, tablero.getCasilleros().get(19), 640, 520, gc));						//20	
		
		
	}

	public VistaCasillero getVistasCasillero(int posicionRelativa) {
		
		return vistasCasilleros.get(posicionRelativa);
	}

}
