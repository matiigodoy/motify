package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BaseDeDatosTest {

	@Test
	// Test Matii
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
	// Test Matii
	public void queSePuedaAgregarUnaDistribuidoraABaseDeDatos() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora;
		distribuidora = new Distribuidora("Music Distr", "upload@musicdistr.com", "pass123456");
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
		usuarioFinal = new UsuarioFinal("Mora", "mora@gmail.com", "****");

		final Integer CANTIDAD_USUARIOS_ESPERADOS = 1;

		// Ejecución
		bbdd.agregarUsuarioFinal(usuarioFinal);

		// Validación
		assertEquals(CANTIDAD_USUARIOS_ESPERADOS, bbdd.getCantidadDeUsuariosFinales());
	}
	
	@Test
	public void queNoHayaDosUsuariosConMismoEmail() {
		// preparacion
		BaseDeDatos bbdd = new BaseDeDatos();
		UsuarioFinal usuario = new UsuarioFinal("Mora", "mora@gmail.com", "***");
		UsuarioFinal usuario2 = new UsuarioFinal("Pepe", "mora@gmail.com", "***");
		
		// ejecucion
		bbdd.agregarUsuarioFinal(usuario);
		bbdd.agregarUsuarioFinal(usuario2);
		final Integer CANTIDAD_USUARIOS_FINALES = 1;
		
		// validacion
		assertEquals(CANTIDAD_USUARIOS_FINALES, bbdd.getCantidadDeUsuariosFinales());
	}
	@Test
	// Test Matii
	public void queNoHayaDosDistribuidorasConMismoEmail() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora1 = new Distribuidora("Music Distr", "upload@musicdistr.com", "pass123456");
		Distribuidora distribuidora2 = new Distribuidora("DistriMusic", "upload@musicdistr.com", "pass123456");
		
		// Ejecución
		bbdd.agregarDistribuidora(distribuidora1);
		bbdd.agregarDistribuidora(distribuidora2);
		final Integer CANTIDAD_ESPERADA_DISTRIBUIDORAS = 1;
		
		// Validación
		assertEquals(CANTIDAD_ESPERADA_DISTRIBUIDORAS, bbdd.getCantidadDeDistribuidoras());
	}
	@Test
	// Test Matii
	public void queSePuedaGuardarListaDeReproduccion() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Hitazos", usuario);
		Cancion cancion1 = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		Cancion cancion2 = new Cancion("Médium", "Gustavo Cerati", 333, Genero.ROCK);
		lista.agregarCanciones(cancion1);
		lista.agregarCanciones(cancion2);
		
		// Ejecución
		bbdd.agregarListaDeReproduccion(lista);
		final Integer CANTIDAD_ESPERADA_LISTAS = 1;
		
		// Validación
		assertEquals(CANTIDAD_ESPERADA_LISTAS, bbdd.getCantidadDeListasDeReproduccion());
	}
	
	@Test
	// Test Matii
	public void queNoSePuedaGuardarListaDeReproduccionConMismoNombreYPropietario() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista1 = new ListaDeReproduccion("Hitazos", usuario);
		ListaDeReproduccion lista2 = new ListaDeReproduccion("Hitazos", usuario);
		
		// Ejecución
		bbdd.agregarListaDeReproduccion(lista1);
		bbdd.agregarListaDeReproduccion(lista2);
		final Integer CANTIDAD_ESPERADA_LISTAS = 1;
		
		// Validación
		assertEquals(CANTIDAD_ESPERADA_LISTAS, bbdd.getCantidadDeListasDeReproduccion());
	}
	
	@Test
	// Test Matii
	public void queSePuedaGuardarListaDeReproduccionConMismoNombrePeroDistintoPropietario() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		UsuarioFinal usuario2 = new UsuarioFinal("José Pérez", "josep@gmail.com", "1234pass");
		ListaDeReproduccion lista1 = new ListaDeReproduccion("Hitazos", usuario);
		ListaDeReproduccion lista2 = new ListaDeReproduccion("Hitazos", usuario2);
		
		// Ejecución
		bbdd.agregarListaDeReproduccion(lista1);
		bbdd.agregarListaDeReproduccion(lista2);
		final Integer CANTIDAD_ESPERADA_LISTAS = 2;
		
		// Validación
		assertEquals(CANTIDAD_ESPERADA_LISTAS, bbdd.getCantidadDeListasDeReproduccion());
	}
}
