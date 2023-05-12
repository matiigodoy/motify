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
	public Boolean login(String email, String contraseña) {
		if(email.equals(getEmail()) && contraseña.equals(getContraseña())) {
			System.out.println("¡Inicio de sesión correcto!");
			System.out.println("Bienvenido " + getNombre());
			return true;
		} else {
			System.out.println("Datos incorrectos. Intente nuevamente.");
			return false;
		}
	}


	public void subirCancion(BaseDeDatos bbdd, Cancion cancion) {
		bbdd.agregarCancion(cancion);
	}

}
