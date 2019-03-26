package isw.proyecto.modelo;

import java.util.Date;

public class Propietario extends Residente{

	Propietario(String nombre, String apellido, String cedula, String telefono, Vivienda resideEn, Date resideDesde, EstadoPago estado, String tipo) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setResideEn(resideEn);
		this.setResideDesde(resideDesde);
		this.setEstado(estado);
		this.setTipo(tipo);
	}
	
}
