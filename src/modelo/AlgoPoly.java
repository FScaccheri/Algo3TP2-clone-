package modelo;

import java.util.ArrayList;

import modelo.casilleros.Activable;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.ImpuestoAlLujo;
import modelo.casilleros.Policia;
import modelo.casilleros.Quini6;
import modelo.casilleros.Salida;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;
import modelo.casilleros.adquiribles.Servicio;
import modelo.casilleros.movimiento.AvanceDinamico;
import modelo.casilleros.movimiento.RetrocesoDinamico;

public class AlgoPoly {
	
	private static AlgoPoly algoPoly;
	
	public static AlgoPoly getInstancia() {
		if(algoPoly == null)
			algoPoly = new AlgoPoly();
		return algoPoly;
	}

	private AdministradorDeTurnos admin;
	private Tablero tablero;
	private ListaDeVistas lista;

	private AlgoPoly() {
		tablero = Tablero.getInstancia();
		admin = new AdministradorDeTurnos();
		lista = new ListaDeVistas();
		
		crearTablero();
		
		for (int j = 0; j < 3; j++) {
			Jugador jugador = new Jugador();
			jugador.setPosicion(tablero.getCasilleros().get(0).getPosicion());
			admin.agregarJugador(jugador);
		}
		
	}
	
	private void crearTablero() {
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
		
		BsAsSur.asociar(BsAsNorte);
		CordobaSur.asociar(CordobaNorte);
		SaltaNorte.asociar(SaltaSur);
		EDESUR.asociar(AYSA);
		SUBTE.asociar(TRENES);
																					// Casillero numero:
		tablero.agregar(new Casillero("Salida", new Salida()));												//1
		tablero.agregar(new Casillero("Quini6", new Quini6()));												//2
		tablero.agregar(new Casillero("BsAs Sur", BsAsSur));													//3
		tablero.agregar(new Casillero("EDESUR", EDESUR));														//4
		tablero.agregar(new Casillero("BsAs Norte", BsAsNorte));													//5
		tablero.agregar(new Casillero("Carcel", new Carcel()));												//6
		tablero.agregar(new Casillero("Cordoba Sur", CordobaSur));													//7
		tablero.agregar(new Casillero("Avance dinamico", new AvanceDinamico()));										//8
		tablero.agregar(new Casillero("SUBTE", SUBTE));														//9
		tablero.agregar(new Casillero("Cordoba Norte", CordobaNorte));												//10
		tablero.agregar(new Casillero("Impuesto de Lujo", new ImpuestoAlLujo()));										//11
		tablero.agregar(new Casillero("Santa Fe", SantaFe));													//12
		tablero.agregar(new Casillero("AYSA", AYSA));														//13
		tablero.agregar(new Casillero("Salta Norte", SaltaNorte));													//14
		tablero.agregar(new Casillero("Salta Sur", SaltaSur));													//15
		tablero.agregar(new Casillero("Policia", new Policia(tablero.getCasilleros().get(5).getPosicion())));	//16
		tablero.agregar(new Casillero("TRENES", TRENES));														//17
		tablero.agregar(new Casillero("Neuquen", Neuquen));													//18
		tablero.agregar(new Casillero("Retroceso dinamico", new RetrocesoDinamico()));									//19
		tablero.agregar(new Casillero("Tucuman", Tucuman));													//20	
	}

	public ArrayList<Jugador> getJugadores() {
		return admin.getJugadores();
	}
		
	public void agregarAListaDeVistas(Vista vista) {
		lista.agregar(vista);
	}

	public void actualizar() {
		lista.actualizar();
	}

	public boolean lanzoLosDados() {
		return admin.lanzoLosDados();
	}

	public void lanzarDados() {
		admin.lanzarDados();
	}

	public void finalizarTurno() {
		admin.finalizarTurno();
	}

	private Jugador getJugadorActual() {
		return admin.getJugadorActual();
	}
	
	public void avanzarJugadorActual() {
		Jugador jugador = getJugadorActual();
		jugador.avanzar(getUltimaTirada());
		tablero.getCasillero(jugador.getPosicion()).caeEn(jugador);
	}
	
	public int getUltimaTirada() {
		return Tirada.getUltimaTirada();
	}

	public boolean salieronDobles() {
		return Tirada.fueDoble();
	}
	
	
	private Activable getActivableActual() {
		return getJugadorActual().getPosicion().getCasillero().getEfecto();
	}
	
	public boolean casilleroActualALaVenta() {
		try {
			Rentable rentable = ((Rentable) getActivableActual());
			return !rentable.tienePropietario();
		} catch (ClassCastException e) {
			return false;
		}
	}

	public void comprarRentableActal() {
		Rentable rentable = ((Rentable) getActivableActual());
		getJugadorActual().adquirir(rentable);
	}

}
