package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CancionTest {
	
	@Test
	public void queSePasenLosSegundosDeUnaCancionASegundos() {
		// set up
		
		// exercise
		Cancion cancion = new Cancion("MORE", "The Warning", 184, Genero.ROCK);
		
		// verify
		String duracionEnMinutosExpected = "3:04";
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
	
	@Test
	// Test Matii
	public void queUnaCancionDescargadaSeGuardeEnPerfilUsuario() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		usuario.setPremium(true);
		Cancion cancion = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		
		// Ejecución
		cancion.descargar(usuario);
		HashSet<Cancion> listadoCancionesDescargadas = usuario.getCancionesDescargadas();
		
		
		// Validación
		assertTrue(listadoCancionesDescargadas.contains(cancion));
	
	}

}
