package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ColeccionDeRentables;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;

public class ColeccionDeRentablesTest {

	@Test
	public void AlCrearUnaColeccionDeRentablesNoTienePropiedades() {
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		assertEquals(coleccion.propiedades().size(), 0);
	}
	
	@Test
	public void AlAgregarUnaPropiedadPropiedadesAumentaEnUno() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(propiedad);
		
		assertEquals(coleccion.propiedades().size(), 1);
	}

	@Test
	public void AlCrearUnaColeccionDeRentablesNoTieneServicios() {
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		assertEquals(coleccion.servicios().size(), 0);
	}
	
	@Test
	public void AlAgregarUnServicioServiciosAumentaEnUno() {
		Servicio servicio = new Servicio(0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(servicio);
		
		assertEquals(coleccion.servicios().size(), 1);
	}
	
	@Test
	public void AlAgregarUnServicioPropiedadesNoAumenta() {
		Servicio servicio = new Servicio(0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(servicio);
		
		assertEquals(coleccion.propiedades().size(), 0);
	}
	
	@Test
	public void AlAgregarUnaPropiedadServiciosNoAumenta() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(propiedad);
		
		assertEquals(coleccion.servicios().size(), 0);
	}

	@Test
	public void AlQuitarUnaPropiedadLaCantidadDePropiedadesDisminuye() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(propiedad);
		coleccion.eliminar(propiedad);
		
		assertEquals(coleccion.propiedades().size(), 0);
	}

	@Test
	public void AlQuitarUnServicioLaCantidadDeServiciosAumenta() {
		Servicio servicio = new Servicio(0, 0, 0);
		ColeccionDeRentables coleccion = new ColeccionDeRentables();
		coleccion.agregar(servicio);
		coleccion.eliminar(servicio);
		
		assertEquals(coleccion.servicios().size(), 0);
	}
}
