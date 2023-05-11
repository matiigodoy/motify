package ar.com.motify;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistribuidoraTest {

	@Test
	public void queSePuedaInstanciarUnaDistribuidora() {
		// Preparación
		Distribuidora distribuidora;
		final String USUARIO = "30123456789";
		final String NOMBRE = "Music Distr";
		final String EMAIL = "upload@musicdistr.com";
		final String CONTRASEÑA = "pass123456";
				
		// Ejecución
		distribuidora = new Distribuidora(USUARIO, NOMBRE, EMAIL, CONTRASEÑA);
				
		// Validación
		assertNotNull(distribuidora);
		assertEquals(USUARIO, distribuidora.getUsuario());
	}
	
	
	@Test
	public void queUnaDistribuidoraPuedaSubirUnaCancion() {
		// Preparación
		BaseDeDatos bbdd = new BaseDeDatos();
		Distribuidora distribuidora = new Distribuidora("301234567892", "Music Distr", "upload@musicdistr.com", "pass123456");
		Cancion cancion;
		cancion = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 1;
				
		// Ejecución
		distribuidora.subirCancion(bbdd,cancion);
				
		// Validación
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, bbdd.getCantidadDeCanciones());
	}

}
