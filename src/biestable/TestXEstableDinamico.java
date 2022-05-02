package biestable;

import org.junit.jupiter.api.*;

class TestXEstableDinamico {

	private XEstableDinamico b;

	@BeforeEach
	void init() {
		b = new XEstableDinamico();
	}

	//TEST DE COMPORTAMIENTO DINAMICO
	@Test
	void pruebaCambioDeEstados() {
		Assertions.assertEquals("Cerrado", b.estado());
		b.cambio();
		Assertions.assertEquals("Cerrado", b.estado());
		b.abrir();
		Assertions.assertEquals("Precaucion", b.estado());
		b.cambio();
		Assertions.assertEquals("Cerrado", b.estado());
		b.abrir();
		b.cambio();
		Assertions.assertEquals("Abierto", b.estado());
		b.cambio();
		Assertions.assertEquals("Abierto", b.estado());
		
	}
	
	// TESTS DE COMPORTAMIENTO BIESTABLE
	@Test
	void pruebaInicializacionCorrectaBiestable() {
		b.cambio();
		Assertions.assertEquals("Cerrado", b.estado());
	}

	@Test
	void pruebaCambioEstado() {
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
	}

	@Test
	void pruebaCerrarEstadoEstandoCerradoBiestable() {
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
		b.cerrar();
		b.cerrar();
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
	}

	@Test
	void pruebaAbrirEstadoEstandoAbiertoBiestable() {
		b.abrir();
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
		b.abrir();
		b.abrir();
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
	}

	@Test
	void pruebaCambiosMultiplesBiestable() {
		b.abrir();
		b.cerrar();
		b.cerrar();
		b.abrir();
		b.abrir();
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
	}

	
	// TESTS DE COMPORTAMIENTO TRIESTABLE
	@Test
	void pruebaInicializacionCorrectaTriestable() {
		b.cambio();
		Assertions.assertEquals("Cerrado", b.estado());
	}

	@Test
	void pruebaCambioAmarillo() {
		b.cambio();
		b.abrir();
		Assertions.assertEquals("Precaucion", b.estado());
	}

	@Test
	void pruebaCambioVerde() {
		b.cambio();
		b.abrir();
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
	}

	@Test
	void pruebaCerrarEstadoEstandoCerradoTriestable() {
		b.cambio();
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
		b.cerrar();
		b.cerrar();
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
	}

	@Test
	void pruebaAbrirEstadoEstandoAbiertoTriestable() {
		b.cambio();
		b.abrir();
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
		b.abrir();
		b.abrir();
		b.abrir();
		Assertions.assertEquals("Abierto", b.estado());
	}

	@Test
	void pruebaCambiosMultiplesTriestable() {
		b.cambio();
		b.abrir();
		b.cerrar();
		b.cerrar();
		b.abrir();
		b.abrir();
		b.cerrar();
		Assertions.assertEquals("Precaucion", b.estado());
	}

	@Test
	void pruebaCierreTriestable() {
		b.cambio();
		b.abrir();
		b.abrir();
		b.cerrar();
		b.cerrar();
		Assertions.assertEquals("Cerrado", b.estado());
	}
}
