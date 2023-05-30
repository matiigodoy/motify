package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DistribuidoraTest {
	
	@Test
	public void queSePuedaLoguearUnaDistribuidora() {
		// set up
		String email = "zannieEntretent@gmail.com";
		String password = "***";
		
		// exercise
		Distribuidora distribuidora = new Distribuidora("Zannie", email, password);
		String loginCorrecto = distribuidora.login(email, password);
		
		// verify
		assertEquals(loginCorrecto, "¡Inicio de sesión correcto! \n Bienvenido" + distribuidora.getNombre());
	}

	@Test
	public void queSePuedaInstanciarUnaDistribuidora() {
		// Preparación
		Distribuidora distribuidora;
		final String NOMBRE = "Music Distr";
		final String EMAIL = "upload@musicdistr.com";
		final String CONTRASEÑA = "pass123456";

		// Ejecución
		distribuidora = new Distribuidora(NOMBRE, EMAIL, CONTRASEÑA);

		// Validación
		assertNotNull(distribuidora);
		assertEquals(EMAIL, distribuidora.getEmail());
	}

	@Test
	public void queUnaDistribuidoraPuedaSubirUnaCancion() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora = new Distribuidora("Music Distr", "upload@musicdistr.com","pass123456");
		Cancion cancion;
		cancion = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 1;

		// Ejecución
		distribuidora.subirCancion(bbdd, cancion);

		// Validación
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, bbdd.getCantidadDeCanciones());
	}

	@Test
	public void queUnaDistribuidoraNoPuedaSubirCancionConTituloYNombreExistentes() {
		// preparacion
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora = new Distribuidora("Music Distr", "upload@musicdistr.com","pass123456");
		Distribuidora distribuidora2 = new Distribuidora("DistriMusic", "support@distrimusic.com","pass123456");
		Cancion cancion1 = new Cancion("Té Para Tres", "Soda Stereo", 184, Genero.ROCK);
		Cancion cancion2 = new Cancion("Té Para Tres", "Soda Stereo", 180, Genero.CUMBIA);
		
		// ejecucion
		distribuidora.subirCancion(bbdd,cancion1);
		distribuidora2.subirCancion(bbdd,cancion2);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 1;
		
		// validacion
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, bbdd.getCantidadDeCanciones());
	}

}
