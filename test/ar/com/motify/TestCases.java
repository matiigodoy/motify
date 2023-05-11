package ar.com.motify;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
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

}
