package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class UsuarioFinalTest {

	@Test
	public void queSePuedaInstanciarUnUsuarioFinal() {
		// Preparación
		UsuarioFinal usuarioFinal;
		final String NOMBRE = "Mora";
		final String EMAIL = "mora@gmail.com";
		final String PASSWORD = "*****";

		// Ejecución
		usuarioFinal = new UsuarioFinal(NOMBRE, EMAIL, PASSWORD);

		// Validación
		assertNotNull(usuarioFinal);
		assertEquals(EMAIL, usuarioFinal.getEmail());
	}

	@Test
	public void queUnUsuarioFinalPuedaDescargarUnaCancionDeLaLista() {
		// set up
		String email = "mora@hotmail.com";
		String password = "****";

		// exercise
		UsuarioFinal usuarioFinal = new UsuarioFinal("mora", email, password);
		Cancion cancion = new Cancion("Chop suey!", "System Of A Down", 210, Genero.NUMETAL);
		ListaDeReproduccion playlist = new ListaDeReproduccion("Rock mix");

		usuarioFinal.login(email, password);
		Boolean descargaExpected = playlist.descargarCancion(cancion, usuarioFinal);

		// verify
		assertTrue(descargaExpected);
	}

}
