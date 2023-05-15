package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CancionTest {
	
	@Test
	public void queSePasenLosSegundosDeUnaCancionASegundos() {
		// set up
		
		// exercise
		Cancion cancion = new Cancion("MORE", "The Warning", 184, Genero.ROCK);
		
		// verify
		String duracionEnMinutosExpected = "3:03";
		String duracionEnMinutosActual = cancion.getDuracionEnMinutosYSegundos();
		
		assertEquals(duracionEnMinutosExpected, duracionEnMinutosActual);
	}

	
	@Test
	// Test Matii
	public void queSePuedaInstanciarUnaCancion() {
		// Preparación
		Cancion cancion;
		final String TITULO = "Té para tres";
		final String ARTISTA = "Soda stereo";
		final Integer DURACION_EN_SEGUNDOS = 184;
		final Genero GENERO = Genero.ROCK;
		
		// Ejecución
		cancion = new Cancion(TITULO, ARTISTA, DURACION_EN_SEGUNDOS, GENERO);
		
		// Validación
		assertNotNull(cancion);
		assertEquals(TITULO, cancion.getTitulo());
	
	}
	
	@Test
	// Test Matii
	public void queSePuedaReproducirUnaCancion() {
		// Preparación
		Cancion cancion;
		final String TITULO = "Té Para Tres";
		final String ARTISTA = "Soda Stereo";
		final Integer DURACION_EN_SEGUNDOS = 184;
		final Genero GENERO = Genero.ROCK;
		final String VISUALIZACION = "Reproduciendo... Té Para Tres - Soda Stereo";
		
		// Ejecución
		cancion = new Cancion(TITULO, ARTISTA, DURACION_EN_SEGUNDOS, GENERO);
		
		// Validación
		assertEquals(VISUALIZACION, cancion.reproducir());
	
	}

}
