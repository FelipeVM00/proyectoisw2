package isw.proyecto.modelo;

import java.util.Date;

public class Residente extends Persona{
	
	private Vivienda resideEn;
	private Date resideDesde;
	private EstadoPago estado;
	private String tipo;
	
	public Residente() {
	}
	
	private Residente(String nombre, String apellido, String cedula, String telefono, Vivienda resideEn, Date resideDesde, EstadoPago estado, String tipo) {
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
	
	public Vivienda getResideEn() {
		return resideEn;
	}
	
	public void setResideEn(Vivienda resideEn) {
		this.resideEn = resideEn;
	}
	
	public Date getResideDesde() {
		return resideDesde;
	}
	
	public void setResideDesde(Date resideDesde) {
		this.resideDesde = resideDesde;
	}
	
	public EstadoPago getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPago estado) {
		this.estado = estado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static class ResidenteBuilder extends PersonaBuilder{
		
		private Vivienda resideEn;
		private Date resideDesde;
		private EstadoPago estado;
		private String tipo;
		
		public ResidenteBuilder setResideEn(Vivienda vivienda) {
			this.resideEn = vivienda;
			return this;
		}
		
		public ResidenteBuilder setResideDesde(Date resideDesde) {
			this.resideDesde = resideDesde;
			return this;
		}
		
		public ResidenteBuilder setRol(EstadoPago estado) {
			this.estado = estado;
			return this;
		}
		
		public ResidenteBuilder setTipo(String tipo) {
			this.tipo = tipo;
			return this;
		}
		
		@Override
		public Residente build() {
			
			if(this.tipo == "Arrendatario") {
				return new Arrendatario(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.resideEn, this.resideDesde, this.estado, this.tipo);
			}
			else if(this.tipo == "Propietario"){
				return new Propietario(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.resideEn, this.resideDesde, this.estado, this.tipo);
			}
			else {
				return new Residente(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.resideEn, this.resideDesde, this.estado, this.tipo);
			}
		}
	}
	
	
	
	
	
}
