package isw.proyecto.modelo;

public class Administrador extends Usuario implements FuncionesAdmin{
	
	Administrador(String nombre, String apellido, String cedula, String telefono, Cuenta cuenta, TipoUsuario rol) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCuenta(cuenta);
		this.setRol(rol);
	}

	@Override
	public void generarReporte() {
		
	}

	@Override
	public void recibirPagoAdmin() {
			
	}

	@Override
	public void asignarParqueadero() {
				
	}

	@Override
	public void controlarVisitantes() {
		
	}

	@Override
	public void controlarEmpleados() {
				
	}
	
}
