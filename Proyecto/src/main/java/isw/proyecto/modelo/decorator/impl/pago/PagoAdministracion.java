package isw.proyecto.modelo.decorator.impl.pago;

import isw.proyecto.modelo.Residente;

public class PagoAdministracion extends Pago{

	public PagoAdministracion() {
		
	}
	
	public PagoAdministracion(int id, double valor, String fecha, String mes, Residente residente) {
		this.setId(id);
		this.setValorPago(valor);
		this.setFechaPago(fecha);
		this.setMesAPagar(mes);
		this.setResidente(residente);
	}
	
	@Override
	public String obtenerDetalle() {
		return "Este pago es de ADMINISTRACION ";
	}

	@Override
	public double obtenerMonto() {
		return this.getValorPago();
	}

}
