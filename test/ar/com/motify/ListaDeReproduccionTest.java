package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ListaDeReproduccionTest {

	@Test
	public void vDuracionTotalDeLaLista() {
		// set up
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("User Test", "user@test.com", "pass1234");
		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", usuario);
		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);
		Cancion cancion2 = new Cancion("Call It Fate, Call It Karma", "The Strokes", 178, Genero.ROCK);
		playlist.agregarCanciones(cancion1);
		playlist.agregarCanciones(cancion2);
		
		
		// verify
		String duracionEnMinutosTotalDeLaListaExpected = "6:36";
		String duracionEnMinutosTotalDeLaListaActual = playlist.duracionDeLaLista();
		assertEquals(duracionEnMinutosTotalDeLaListaExpected, duracionEnMinutosTotalDeLaListaActual);
	}

	@Test
	public void vVerListaDeCanciones() {
		// set up
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("User Test", "user@test.com", "pass1234");
		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", usuario);

		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion1);

		String expected = "Cancion [titulo=Toxicity, artista=System Of A Down, duracionEnSegundos=218, genero=NUMETAL]";
		String actual = playlist.verListadoDeCanciones();

		// verify
		assertEquals(expected, actual);
	}

	@Test
	public void vReproducirLista() {
		// set up
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("User Test", "user@test.com", "pass1234");
		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", usuario);
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);

		String expected = "Reproduciendo lista";
		String actual = playlist.reproducirCancion();

		// verify
		assertEquals(expected, actual);
	}

	@Test
	public void vEliminarCanciones() {
		// set up
		Integer cantCanciones = 0;
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("User Test", "user@test.com", "pass1234");
		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", usuario);
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);
		playlist.eliminarCancion(cancion);

		// verify
		assertEquals(cantCanciones, playlist.cantidadDeCanciones());
	}

	@Test
	public void vAgregarCancion() {
		// set up
		Integer cantCanciones = 1;
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("User Test", "user@test.com", "pass1234");
		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", usuario);
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);

		// verify
		assertEquals(cantCanciones, playlist.cantidadDeCanciones());
	}

	@Test
	// Test Matii
	public void queSePuedaInstanciarListaDeReproduccion() {
		// Preparación
		ListaDeReproduccion lista;
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		final String NOMBRE_LISTA = "Hitazos";
		final UsuarioFinal PROPIETARIO_ESPERADO = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 0;

		// Ejecución
		lista = new ListaDeReproduccion(NOMBRE_LISTA, usuario);

		// Validación
		assertNotNull(lista);
		assertEquals(PROPIETARIO_ESPERADO, lista.getPropietario());
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}

	@Test
	// Test Matii
	public void queLaDuracionDeLaListaTengaFormatoMmSs() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Hitazos", usuario);
		Cancion cancion1 = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		Cancion cancion2 = new Cancion("Médium", "Gustavo Cerati", 333, Genero.ROCK);
		final String DURACION_ESPERADA = "8:37";

		// Ejecución
		lista.agregarCancion(cancion1, usuario.getPremium());
		lista.agregarCancion(cancion2, usuario.getPremium());

		// Validación
		assertNotNull(lista);
		assertEquals(DURACION_ESPERADA, lista.duracionDeLaLista());
	}
	
	@Test
	// Test Matii
	public void queUsuarioFreeNoPuedaSubirMasDe10Canciones() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Lista Free", usuario);
		Cancion cancion1 = new Cancion("Cancion1", "Artista", 123, Genero.ROCK);
		Cancion cancion2 = new Cancion("Cancion2", "Artista", 123, Genero.ROCK);
		Cancion cancion3 = new Cancion("Cancion3", "Artista", 123, Genero.ROCK);
		Cancion cancion4 = new Cancion("Cancion4", "Artista", 123, Genero.ROCK);
		Cancion cancion5 = new Cancion("Cancion5", "Artista", 123, Genero.ROCK);
		Cancion cancion6 = new Cancion("Cancion6", "Artista", 123, Genero.ROCK);
		Cancion cancion7 = new Cancion("Cancion7", "Artista", 123, Genero.ROCK);
		Cancion cancion8 = new Cancion("Cancion8", "Artista", 123, Genero.ROCK);
		Cancion cancion9 = new Cancion("Cancion9", "Artista", 123, Genero.ROCK);
		Cancion cancion10 = new Cancion("Cancion10", "Artista", 123, Genero.ROCK);
		Cancion cancion11 = new Cancion("Cancion11", "Artista", 123, Genero.ROCK);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 10;
		
		// Ejecución
		lista.agregarCancion(cancion1, usuario.getPremium());
		lista.agregarCancion(cancion2, usuario.getPremium());
		lista.agregarCancion(cancion3, usuario.getPremium());
		lista.agregarCancion(cancion4, usuario.getPremium());
		lista.agregarCancion(cancion5, usuario.getPremium());
		lista.agregarCancion(cancion6, usuario.getPremium());
		lista.agregarCancion(cancion7, usuario.getPremium());
		lista.agregarCancion(cancion8, usuario.getPremium());
		lista.agregarCancion(cancion9, usuario.getPremium());
		lista.agregarCancion(cancion10, usuario.getPremium());
		lista.agregarCancion(cancion11, usuario.getPremium());
		
		// Validación
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}
	
	@Test
	// Test Matii
	public void queUsuarioPremiumPuedaSubirMasDe10Canciones() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		usuario.setPremium(true);
		ListaDeReproduccion lista = new ListaDeReproduccion("Lista Free", usuario);
		Cancion cancion1 = new Cancion("Cancion1", "Artista", 123, Genero.ROCK);
		Cancion cancion2 = new Cancion("Cancion2", "Artista", 123, Genero.ROCK);
		Cancion cancion3 = new Cancion("Cancion3", "Artista", 123, Genero.ROCK);
		Cancion cancion4 = new Cancion("Cancion4", "Artista", 123, Genero.ROCK);
		Cancion cancion5 = new Cancion("Cancion5", "Artista", 123, Genero.ROCK);
		Cancion cancion6 = new Cancion("Cancion6", "Artista", 123, Genero.ROCK);
		Cancion cancion7 = new Cancion("Cancion7", "Artista", 123, Genero.ROCK);
		Cancion cancion8 = new Cancion("Cancion8", "Artista", 123, Genero.ROCK);
		Cancion cancion9 = new Cancion("Cancion9", "Artista", 123, Genero.ROCK);
		Cancion cancion10 = new Cancion("Cancion10", "Artista", 123, Genero.ROCK);
		Cancion cancion11 = new Cancion("Cancion11", "Artista", 123, Genero.ROCK);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 11;
		
		// Ejecución
		lista.agregarCancion(cancion1, usuario.getPremium());
		lista.agregarCancion(cancion2, usuario.getPremium());
		lista.agregarCancion(cancion3, usuario.getPremium());
		lista.agregarCancion(cancion4, usuario.getPremium());
		lista.agregarCancion(cancion5, usuario.getPremium());
		lista.agregarCancion(cancion6, usuario.getPremium());
		lista.agregarCancion(cancion7, usuario.getPremium());
		lista.agregarCancion(cancion8, usuario.getPremium());
		lista.agregarCancion(cancion9, usuario.getPremium());
		lista.agregarCancion(cancion10, usuario.getPremium());
		lista.agregarCancion(cancion11, usuario.getPremium());
		
		// Validación
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}
	
	@Test
	// Test Matii
	public void queUnaListaDeReproduccionPuedaTenerCancionesRepetidas() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Lista Repetida", usuario);
		Cancion cancion1 = new Cancion("Cancion1", "Artista", 123, Genero.ROCK);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 2;
		
		// Ejecución
		lista.agregarCancion(cancion1, usuario.getPremium());
		lista.agregarCancion(cancion1, usuario.getPremium());
		
		// Validación
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}

}
