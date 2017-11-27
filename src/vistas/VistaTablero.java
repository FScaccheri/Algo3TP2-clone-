package vistas;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;
import modelo.AvanceDinamico;
import modelo.Carcel;
import modelo.Casillero;
import modelo.ImpuestoAlLujo;
import modelo.Policia;
import modelo.Propiedad;
import modelo.Quini6;
import modelo.RetrocesoDinamico;
import modelo.Salida;
import modelo.Servicio;
import modelo.Tablero;

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
		vistasCasilleros.add(new VistaCasillero("BS AS", "SUR", tablero.getCasilleros().get(2), 400, 640, gc));					//3
		vistasCasilleros.add(new VistaCasillero("EDESUR", tablero.getCasilleros().get(3), 280, 640, gc));						//4
		vistasCasilleros.add(new VistaCasillero("BS AS", "NORTE", tablero.getCasilleros().get(4), 160, 640, gc));				//5
		vistasCasilleros.add(new VistaCasillero("CARCEL",tablero.getCasilleros().get(5), 40, 640, gc));							//6
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "SUR", tablero.getCasilleros().get(6), 40, 520, gc));				//7
		vistasCasilleros.add(new VistaCasillero("ACANCE", "DINAMICO", tablero.getCasilleros().get(7), 40, 400, gc));			//8
		vistasCasilleros.add(new VistaCasillero("SUBTE", tablero.getCasilleros().get(8), 40, 280, gc));							//9
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "NORTE", tablero.getCasilleros().get(9), 40,160, gc));				//10
		vistasCasilleros.add(new VistaCasillero("IMPUESTO", "DE LUJO",tablero.getCasilleros().get(10), 40, 40, gc));			//11
		vistasCasilleros.add(new VistaCasillero("SANTA FE", tablero.getCasilleros().get(11), 160, 40, gc));						//12
		vistasCasilleros.add(new VistaCasillero("AYSA", tablero.getCasilleros().get(12), 280, 40, gc)); 						//13
		vistasCasilleros.add(new VistaCasillero("SALTA", "NORTE", tablero.getCasilleros().get(13), 400, 40, gc));				//14
		vistasCasilleros.add(new VistaCasillero("SALTA", "SUR", tablero.getCasilleros().get(14), 520, 40, gc));					//15
		vistasCasilleros.add(new VistaCasillero("POLICIA",tablero.getCasilleros().get(15), 640, 40, gc));						//16
		vistasCasilleros.add(new VistaCasillero("TRENES", tablero.getCasilleros().get(16), 640, 160, gc));						//17
		vistasCasilleros.add(new VistaCasillero("NEUQUEN", tablero.getCasilleros().get(17), 640, 280, gc));						//18
		vistasCasilleros.add(new VistaCasillero("RETROCESO", "DINAMICO",tablero.getCasilleros().get(18), 640, 400, gc));		//19
		vistasCasilleros.add(new VistaCasillero("TUCUMAN", tablero.getCasilleros().get(19), 640, 520, gc));						//20	
		
		
	}

	public VistaCasillero getVistasCasillero(int posicionRelativa) {
		
		return vistasCasilleros.get(posicionRelativa);
	}

}
