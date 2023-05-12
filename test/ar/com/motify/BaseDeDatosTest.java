package ar.com.motify;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseDeDatosTest {

	@Test
	public void queSePuedaInstanciarUnaBaseDeDatos() {
		// Preparación
		BaseDeDatos bbdd;
		final Integer CANTIDAD_DISTRIBUIDORAS_ESPERADAS = 0;
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 0;

		// Ejecución
		bbdd = new BaseDeDatos();

		// Validación
		assertNotNull(bbdd);
		assertEquals(CANTIDAD_DISTRIBUIDORAS_ESPERADAS, bbdd.getCantidadDeDistribuidoras());
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, bbdd.getCantidadDeCanciones());
	}

	@Test
	public void queSePuedaAgregarUnaDistribuidoraABaseDeDatos() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora;
		distribuidora = new Distribuidora("301234567892", "Music Distr", "upload@musicdistr.com", "pass123456");
		final Integer CANTIDAD_DISTRIBUIDORAS_ESPERADAS = 1;

		// Ejecución
		bbdd.agregarDistribuidora(distribuidora);

		// Validación
		assertEquals(CANTIDAD_DISTRIBUIDORAS_ESPERADAS, bbdd.getCantidadDeDistribuidoras());
	}

	@Test
	public void queSePuedaAgregarUnUsuarioFinalABaseDeDatos() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		UsuarioFinal usuarioFinal;
		usuarioFinal = new UsuarioFinal("mora55", "Mora", "mora@gmail.com", "****");

		final Integer CANTIDAD_USUARIOS_ESPERADOS = 1;

		// Ejecución
		bbdd.agregarUsuarioFinal(usuarioFinal);

		// Validación
		assertEquals(CANTIDAD_USUARIOS_ESPERADOS, bbdd.getCantidadDeUsuariosFinales());
	}
}
