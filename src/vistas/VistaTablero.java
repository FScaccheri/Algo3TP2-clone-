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
import modelo.Servicio;
import modelo.Tablero;

public class VistaTablero {
	
	private LinkedList<VistaCasillero> vistasCasilleros;
	private LinkedList<Casillero> casilleros;
	private GraphicsContext gc;
	private Tablero tablero;
	
	public VistaTablero(GraphicsContext gc) {
		
		this.gc = gc;
		this.vistasCasilleros = new LinkedList<VistaCasillero>();
		this.casilleros = new LinkedList<Casillero>();
		this.tablero = Tablero.getInstancia();
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
																		// Casillero numero:
		casilleros.add(new Casillero(new Quini6()));									//2
		casilleros.add(new Casillero(BsAsSur));											//3
		casilleros.add(new Casillero(EDESUR));											//4
		casilleros.add(new Casillero(BsAsNorte));										//5
		casilleros.add(new Casillero(new Carcel()));									//6
		casilleros.add(new Casillero(CordobaSur));										//7
		casilleros.add(new Casillero(new AvanceDinamico()));							//8
		casilleros.add(new Casillero(SUBTE));											//9
		casilleros.add(new Casillero(CordobaNorte));									//10
		casilleros.add(new Casillero(new ImpuestoAlLujo()));							//11
		casilleros.add(new Casillero(SantaFe));											//12
		casilleros.add(new Casillero(AYSA));											//13
		casilleros.add(new Casillero(SaltaNorte));										//14
		casilleros.add(new Casillero(SaltaSur));										//15
		casilleros.add(new Casillero(new Policia(casilleros.get(5).getPosicion())));	//16
		casilleros.add(new Casillero(TRENES));											//17
		casilleros.add(new Casillero(Neuquen));											//18
		casilleros.add(new Casillero(new RetrocesoDinamico()));							//19
		casilleros.add(new Casillero(Tucuman));											//20
		
		for (int i = 0; i < 19; i++) {
			
			tablero.agregar(casilleros.get(i));
		}
		
		vistasCasilleros.add(new VistaCasillero("SALIDA", 640, 640, gc));						//1
		vistasCasilleros.add(new VistaCasillero("QUINI 6", 520, 640, gc));						//2
		vistasCasilleros.add(new VistaCasillero("BS AS", "SUR", BsAsSur , 400, 640, gc));		//3
		vistasCasilleros.add(new VistaCasillero("EDESUR", EDESUR, 280, 640, gc));				//4
		vistasCasilleros.add(new VistaCasillero("BS AS", "NORTE", BsAsNorte, 160, 640, gc));	//5
		vistasCasilleros.add(new VistaCasillero("CARCEL", 40, 640, gc));						//6
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "SUR", CordobaSur, 40, 520, gc));	//7
		vistasCasilleros.add(new VistaCasillero("ACANCE", "DINAMICO", 40, 400, gc));			//8
		vistasCasilleros.add(new VistaCasillero("SUBTE", SUBTE, 40, 280, gc));					//9
		vistasCasilleros.add(new VistaCasillero("CORDOBA", "NORTE", CordobaNorte, 40,160, gc));	//10
		vistasCasilleros.add(new VistaCasillero("IMPUESTO", "DE LUJO", 40, 40, gc));			//11
		vistasCasilleros.add(new VistaCasillero("SANTA FE", SantaFe, 160, 40, gc));				//12
		vistasCasilleros.add(new VistaCasillero("AYSA", AYSA, 280, 40, gc)); 					//13
		vistasCasilleros.add(new VistaCasillero("SALTA", "NORTE", SaltaNorte, 400, 40, gc));	//14
		vistasCasilleros.add(new VistaCasillero("SALTA", "SUR", SaltaSur, 520, 40, gc));		//15
		vistasCasilleros.add(new VistaCasillero("POLICIA", 640, 40, gc));						//16
		vistasCasilleros.add(new VistaCasillero("TRENES", TRENES, 640, 160, gc));				//17
		vistasCasilleros.add(new VistaCasillero("NEUQUEN", Neuquen, 640, 280, gc));				//18
		vistasCasilleros.add(new VistaCasillero("RETROCESO", "DINAMICO", 640, 400, gc));		//19
		vistasCasilleros.add(new VistaCasillero("TUCUMAN", Tucuman, 640, 520, gc));				//20	
		
		
	}

	public VistaCasillero getVistasCasillero(int posicionRelativa) {
		
		return vistasCasilleros.get(posicionRelativa);
	}

}
