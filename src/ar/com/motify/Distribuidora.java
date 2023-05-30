package ar.com.motify;

public class Distribuidora extends Usuario{

	
	public Distribuidora(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
	}


	@Override
	public String mostrarInformacion() {
	    return "-Nombre: " + getNombre() + "\n-Email: " + getEmail();
	}
	
	@Override
	public String login(String email, String contraseña) {
		String respuesta = "";
		if(email.equals(getEmail()) && contraseña.equals(getContraseña())) {
			respuesta = "¡Inicio de sesión correcto! \n Bienvenido" + getNombre();
		} else {
			respuesta = "Datos incorrectos. Intente nuevamente.";
		}
		return respuesta;
	}


	public void subirCancion(BaseDeDatos bbdd, Cancion cancion) {
		bbdd.agregarCancion(cancion);
	}

}
