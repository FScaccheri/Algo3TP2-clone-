package modelo;

public abstract class Adquirible implements Activable{

	private Jugador propietario;
	private double precio_venta;
		
	public Adquirible( double precio_venta) {
		this.precio_venta = precio_venta;
	}

	abstract public double getAlquiler(Jugador jugador);
	
	@Override
	public void activarEfecto(Jugador jugador) {
		if(tienePropietario() && !esPropietario(jugador)) {
			jugador.disminuirCapital(getAlquiler(jugador));
			getPropietario().aumentarCapital(getAlquiler(jugador));
		}
	}
	
	//Jugador guarda los Servicios y Propiedades en colecciones distintas, para distinguir entre
	//servicio y propiedad, tiene dos metodos, uno que recibe una Propiedad y uno que recibe un
	//Servicio, por lo tanto, Servicio y Propiedad sobreescriben adquirir y llaman al metodo
	//adquirir de Jugador REFACTOR URGENTE SOLO MEDIDA PROVISORIA PARA PROBAR FUNCIONALIDAD
	//@FrancoR
	public void adquirir(Jugador jugador) {
		jugador.disminuirCapital(precio_venta);
		propietario = jugador;
	}

	public void vender() {
		propietario.aumentarCapital(precio_venta/2);
		propietario = null;
	}
	
	public Jugador getPropietario() {
		return propietario;
	}

	public boolean tienePropietario() {
		return getPropietario() != null;
	}

	public boolean esPropietario(Jugador jugador) {
		return jugador == propietario;
	}
	
}