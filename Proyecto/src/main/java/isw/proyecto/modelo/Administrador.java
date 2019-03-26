package isw.proyecto.modelo;

public class Administrador extends Usuario{
	
	Administrador(String nombre, String apellido, String cedula, String telefono, Cuenta cuenta, TipoUsuario rol) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCuenta(cuenta);
		this.setRol(rol);
	}
	
}
