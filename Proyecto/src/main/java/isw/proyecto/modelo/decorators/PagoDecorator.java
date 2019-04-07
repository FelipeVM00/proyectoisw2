package isw.proyecto.modelo.decorators;

import isw.proyecto.modelo.builder.decorator.impl.pago.IPago;

public abstract class PagoDecorator implements IPago{

	protected IPago pago;
	private String detalle;
	private double monto;
	
	public PagoDecorator(IPago pago) {
		this.pago = pago;
	}
	
	public void modificarValor(double monto, String detalle) {
		
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
}
