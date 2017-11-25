package vistas;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;

public class VistaTablero {
	
	private ArrayList<VistaCasillero> casilleros;
	private GraphicsContext gc;
	
	public VistaTablero(GraphicsContext gc) {
		
		this.gc = gc;
		this.casilleros = new ArrayList<VistaCasillero>();
	}

	public void pintarTablero() {

		casilleros.add(new VistaCasillero("SALIDA", 640, 640, gc));						//1
		casilleros.add(new VistaCasillero("QUINI 6", 520, 640, gc));					//2
		casilleros.add(new VistaCasillero("BS AS", "SUR", 20000 , 400, 640, gc));		//3
		casilleros.add(new VistaCasillero("EDESUR", 35000, 280, 640, gc));				//4
		casilleros.add(new VistaCasillero("BS AS", "NORTE", 25000, 160, 640, gc));		//5
		casilleros.add(new VistaCasillero("CARCEL", 40, 640, gc));						//6
		casilleros.add(new VistaCasillero("CORDOBA", "SUR", 18000, 40, 520, gc));		//7
		casilleros.add(new VistaCasillero("ACANCE", "DINAMICO", 40, 400, gc));			//8
		casilleros.add(new VistaCasillero("SUBTE", 40000, 40, 280, gc));				//9
		casilleros.add(new VistaCasillero("CORDOBA", "NORTE", 20000, 40,160, gc));		//10
		casilleros.add(new VistaCasillero("IMPUESTO", "DE LUJO", 40, 40, gc));			//11
		casilleros.add(new VistaCasillero("SANTA FE", 15000, 160, 40, gc));				//12
		casilleros.add(new VistaCasillero("AYSA", 30000, 280, 40, gc)); 				//13
		casilleros.add(new VistaCasillero("SALTA", "NORTE", 23000, 400, 40, gc));		//14
		casilleros.add(new VistaCasillero("SALTA", "SUR", 23000, 520, 40, gc));			//15
		casilleros.add(new VistaCasillero("POLICIA", 640, 40, gc));						//16
		casilleros.add(new VistaCasillero("TREN", 38000, 640, 160, gc));				//17
		casilleros.add(new VistaCasillero("NEUQUEN", 17000, 640, 280, gc));				//18
		casilleros.add(new VistaCasillero("RETROCESO", "DINAMICO", 640, 400, gc));		//19
		casilleros.add(new VistaCasillero("TUCUMAN", 25000, 640, 520, gc));				//20	
		
	}

	public VistaCasillero getCasillero(int posicionRelativa) {
		
		return casilleros.get(posicionRelativa);
	}

}
