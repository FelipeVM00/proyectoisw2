package isw.proyecto.modelo.builder.decorator.impl.pago;

public class PagoAdministracion extends Pago{

	public PagoAdministracion(double valor, String fecha, String mes) {
		this.setValorPago(valor);
		this.setFechaPago(fecha);
		this.setMesAPagar(mes);
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
