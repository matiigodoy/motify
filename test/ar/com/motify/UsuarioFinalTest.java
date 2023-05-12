package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UsuarioFinalTest {

	@Test
	public void queSePuedaInstanciarUnUsuarioFinal() {
		// Preparación
		UsuarioFinal usuarioFinal;
		final String USUARIO = "Mora555";
		final String NOMBRE = "Mora";
		final String EMAIL = "mora@gmail.com";
		final String PASSWORD = "*****";

		// Ejecución
		usuarioFinal = new UsuarioFinal(USUARIO, NOMBRE, EMAIL, PASSWORD);

		// Validación
		assertNotNull(usuarioFinal);
		assertEquals(USUARIO, usuarioFinal.getUsuario());
	}

}
