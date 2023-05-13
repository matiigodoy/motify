package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ListaDeReproduccionTest {

	@Test
	// ESTO ESTA MAL
	public void vVerListaDeCanciones() {
		// set up

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");
		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);
		Cancion cancion2 = new Cancion("White Stains", "Messa", 693, Genero.NUMETAL);
		Cancion cancion3 = new Cancion("Lonely day", "System Of A Down", 152, Genero.NUMETAL);

		playlist.agregarCanciones(cancion1);
		playlist.agregarCanciones(cancion2);
		playlist.agregarCanciones(cancion3);

		String expected = "Cancion [titulo=Toxicity, artista=System Of A Down, duracionEnSegundos=218, genero=NUMETAL]";
		String actual = playlist.verListadoDeCanciones();

		// verify
		assertEquals(expected, actual);
	}

	@Test
	public void vReproducirCancion() {
		// set up

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");
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
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");
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
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");
		Cancion cancion = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);

		playlist.agregarCanciones(cancion);

		// verify
		assertEquals(cantCanciones, playlist.cantidadDeCanciones());
	}

	@Test
	// falla
	public void queNoSePuedaAgregarMasDe5Canciones() {
		// set up
		Integer cantCancionesExpected = 5;

		// exercise
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");

		Cancion cancion1 = new Cancion("Toxicity", "System Of A Down", 218, Genero.NUMETAL);
		Cancion cancion2 = new Cancion("Everlong", "Foo Fighters", 290, Genero.ROCK);
		Cancion cancion3 = new Cancion("Black", "Pearl Jam", 331, Genero.ROCK);
		Cancion cancion4 = new Cancion("Call It Fate, Call It Karma", "The Strokes", 178, Genero.ROCK);
		Cancion cancion5 = new Cancion("White Stains", "Messa", 693, Genero.NUMETAL);
		Cancion cancion6 = new Cancion("Lonely day", "System Of A Down", 152, Genero.NUMETAL);

		playlist.agregarCanciones(cancion1);
		playlist.agregarCanciones(cancion2);
		playlist.agregarCanciones(cancion3);
		playlist.agregarCanciones(cancion4);
		playlist.agregarCanciones(cancion5);

		playlist.agregarCanciones(cancion6);

		// verify
		assertEquals(cantCancionesExpected, playlist.cantidadDeCanciones());
	}

	@Test
	public void instanciarListaDeReproduccion() {
		ListaDeReproduccion playlist = new ListaDeReproduccion("Musica para dormir");

		assertNotNull(playlist);
	}
}