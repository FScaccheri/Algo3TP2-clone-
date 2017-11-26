package vistas;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;
import modelo.Propiedad;
import modelo.Servicio;

public class VistaTablero {
	
	private LinkedList<VistaCasillero> casilleros;
	private GraphicsContext gc;
	
	public VistaTablero(GraphicsContext gc) {
		
		this.gc = gc;
		this.casilleros = new LinkedList<VistaCasillero>();
	}

	public void pintarTablero() {
		
		Propiedad BsAsSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Propiedad BsAsNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad CordobaSur = new Propiedad(18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Propiedad CordobaNorte = new Propiedad(20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Propiedad SantaFe = new Propiedad(15000, 1500, 3500, 4000);
		Propiedad SaltaNorte = new Propiedad(23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Propiedad SaltaSur = new Propiedad(23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Propiedad Neuquen = new Propiedad(17000, 1800, 3800, 4800);
		Propiedad Tucuman = new Propiedad(25000, 2500, 4500, 7000);
		
		Servicio EDESUR = new Servicio(35000, 500, 1000);
		Servicio SUBTE = new Servicio(40000, 600, 1100);
		Servicio AYSA = new Servicio(30000, 300, 500);
		Servicio TRENES = new Servicio(38000, 450, 800);
		
		EDESUR.asociar(AYSA);
		SUBTE.asociar(TRENES);
		
		casilleros.add(new VistaCasillero("SALIDA", 640, 640, gc));						//1
		casilleros.add(new VistaCasillero("QUINI 6", 520, 640, gc));					//2
		casilleros.add(new VistaCasillero("BS AS", "SUR", BsAsSur , 400, 640, gc));		//3
		casilleros.add(new VistaCasillero("EDESUR", EDESUR, 280, 640, gc));				//4
		casilleros.add(new VistaCasillero("BS AS", "NORTE", BsAsNorte, 160, 640, gc));		//5
		casilleros.add(new VistaCasillero("CARCEL", 40, 640, gc));						//6
		casilleros.add(new VistaCasillero("CORDOBA", "SUR", CordobaSur, 40, 520, gc));		//7
		casilleros.add(new VistaCasillero("ACANCE", "DINAMICO", 40, 400, gc));			//8
		casilleros.add(new VistaCasillero("SUBTE", SUBTE, 40, 280, gc));				//9
		casilleros.add(new VistaCasillero("CORDOBA", "NORTE", CordobaNorte, 40,160, gc));		//10
		casilleros.add(new VistaCasillero("IMPUESTO", "DE LUJO", 40, 40, gc));			//11
		casilleros.add(new VistaCasillero("SANTA FE", SantaFe, 160, 40, gc));				//12
		casilleros.add(new VistaCasillero("AYSA", AYSA, 280, 40, gc)); 				//13
		casilleros.add(new VistaCasillero("SALTA", "NORTE", SaltaNorte, 400, 40, gc));		//14
		casilleros.add(new VistaCasillero("SALTA", "SUR", SaltaSur, 520, 40, gc));			//15
		casilleros.add(new VistaCasillero("POLICIA", 640, 40, gc));						//16
		casilleros.add(new VistaCasillero("TRENES", TRENES, 640, 160, gc));				//17
		casilleros.add(new VistaCasillero("NEUQUEN", Neuquen, 640, 280, gc));				//18
		casilleros.add(new VistaCasillero("RETROCESO", "DINAMICO", 640, 400, gc));		//19
		casilleros.add(new VistaCasillero("TUCUMAN", Tucuman, 640, 520, gc));				//20	
		
		
	}

	public VistaCasillero getCasillero(int posicionRelativa) {
		
		return casilleros.get(posicionRelativa);
	}

}
