package ar.com.motify;

public class Distribuidora extends Usuario{

	
	public Distribuidora(String usuario, String nombre, String email, String contraseña) {
		super(usuario, nombre, email, contraseña);
	}


	@Override
	public String mostrarInformacion() {
	    return "-CUIT: " + getUsuario() + "\n-Nombre: " + getNombre() + "\n-Email: " + getEmail();
	}
	
	@Override
	public Boolean login(String usuario, String contraseña) {
		if(usuario.equals(getUsuario()) && contraseña.equals(getContraseña())) {
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
