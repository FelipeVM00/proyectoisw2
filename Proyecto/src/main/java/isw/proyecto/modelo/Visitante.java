package isw.proyecto.modelo;

import java.util.Date;

public class Visitante extends Persona{
	
	private Date fechaEntrada;
	private Date fechaSalida;
	private Parqueadero parqueaderoOcupado;
	private Vivienda viviendaVisitada;
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public Parqueadero getParqueaderoOcupado() {
		return parqueaderoOcupado;
	}
	
	public void setParqueaderoOcupado(Parqueadero parqueaderoOcupado) {
		this.parqueaderoOcupado = parqueaderoOcupado;
	}
	
	public Vivienda getViviendaVisitada() {
		return viviendaVisitada;
	}
	
	public void setViviendaOcupada(Vivienda viviendaVisitada) {
		this.viviendaVisitada = viviendaVisitada;
	}
	
	private Visitante(String nombre, String apellido, String cedula, String telefono, Date fechaEntrada, Date fechaSalida, Parqueadero parqueaderoOcupado, Vivienda viviendaVisitada) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setFechaEntrada(fechaEntrada);
		this.setFechaSalida(fechaSalida);
		this.setParqueaderoOcupado(parqueaderoOcupado);
		this.setViviendaOcupada(viviendaVisitada);
	}
	
public static class VisitanteBuilder extends PersonaBuilder{
		
		private Date fechaEntrada;
		private Date fechaSalida;
		private Parqueadero parqueaderoOcupado;
		private Vivienda viviendaVisitada;
		
		public VisitanteBuilder setFechaEntrada(Date fecha) {
			this.fechaEntrada = fecha;
			return this;
		}
		
		public VisitanteBuilder setFechaSalida(Date fecha) {
			this.fechaSalida = fecha;
			return this;
		}
		
		public VisitanteBuilder setParqueaderoOcupado(Parqueadero parqueadero) {
			this.parqueaderoOcupado = parqueadero;
			return this;
		}
		
		public VisitanteBuilder setViviendaVisitada(Vivienda vivienda) {
			this.viviendaVisitada = vivienda;
			return this;
		}
		
		@Override
		public Visitante build() {
			return new Visitante(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.fechaEntrada, this.fechaSalida, this.parqueaderoOcupado, this.viviendaVisitada);
		}
	}
}
