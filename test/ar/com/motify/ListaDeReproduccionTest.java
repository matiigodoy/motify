package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ListaDeReproduccionTest {

	@Test
	public void vDuracionTotalDeLaLista() {
		// set up

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");
		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);
		Cancion cancion2 = new Cancion("Call It Fate, Call It Karma", "The Strokes", 178, Genero.ROCK);
		playlist.agregarCanciones(cancion1);
		playlist.agregarCanciones(cancion2);
		
		
		// verify
		String duracionEnMinutosTotalDeLaListaExpected = "6:06";
		String duracionEnMinutosTotalDeLaListaActual = playlist.duracionDeLaLista();
		assertEquals(duracionEnMinutosTotalDeLaListaExpected, duracionEnMinutosTotalDeLaListaActual);
	}

	@Test
	public void vVerListaDeCanciones() {
		// set up

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");

		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion1);

		String expected = "Cancion [titulo=Toxicity, artista=System Of A Down, duracionEnSegundos=218, genero=NUMETAL]";
		String actual = playlist.verListadoDeCanciones();

		// verify
		assertEquals(expected, actual);
	}

	@Test
	public void vReproducirCancion() {
		// set up

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);

		String expected = "Toxicity se esta reproduciendo";
		String actual = playlist.reproducirCancion();

		// verify
		assertEquals(expected, actual);
	}

	@Test
	public void vEliminarCanciones() {
		// set up
		Integer cantCanciones = 0;

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");
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

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);

		// verify
		assertEquals(cantCanciones, playlist.cantidadDeCanciones());
	}

	@Test
	public void queNoSePuedaAgregarMasDe5Canciones() {
		// set up
		Integer cantCancionesExpected = 4;

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");

		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);
		Cancion cancion2 = new Cancion("Everlong", "Foo Fighters", 290, Genero.ROCK);
		Cancion cancion3 = new Cancion("Black", "Pearl Jam", 331, Genero.ROCK);
		Cancion cancion4 = new Cancion("Call It Fate, Call It Karma", "The Strokes", 178, Genero.ROCK);
		Cancion cancion5 = new Cancion("White Stains", "Messa", 693, Genero.NUMETAL);

		playlist.agregarCanciones(cancion1);
		playlist.agregarCanciones(cancion2);
		playlist.agregarCanciones(cancion3);
		playlist.agregarCanciones(cancion4);

		playlist.agregarCanciones(cancion5);

		// verify
		assertEquals(cantCancionesExpected, playlist.cantidadDeCanciones());
	}

	@Test
	public void instanciarListaDeReproduccion() {
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir", "");

		assertNotNull(playlist);
	}

	public void queSePuedaInstanciarListaDeReproduccion() {
		// Preparación
		ListaDeReproduccion lista;
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		final String NOMBRE_LISTA = "Hitazos";
		final String PROPIETARIO_ESPERADO = "Matii Godoy";
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 0;

		// Ejecución
		lista = new ListaDeReproduccion(NOMBRE_LISTA, usuario.getNombre());

		// Validación
		assertNotNull(lista);
		assertEquals(PROPIETARIO_ESPERADO, lista.getPropietario());
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}

	@Test
	public void queLaDuracionDeLaListaTengaFormatoMmSs() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Hitazos", usuario.getNombre());
		Cancion cancion1 = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		Cancion cancion2 = new Cancion("Médium", "Gustavo Cerati", 333, Genero.ROCK);
		final String DURACION_ESPERADA = "8:08";

		// Ejecución
		lista.agregarCanciones(cancion1);
		lista.agregarCanciones(cancion2);

		// Validación
		assertNotNull(lista);
		assertEquals(DURACION_ESPERADA, lista.duracionDeLaLista());
	}

}
