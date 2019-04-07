package isw.proyecto.modelo.decorators;

import isw.proyecto.modelo.builder.decorator.impl.pago.IPago;

public class Multa extends PagoDecorator{
	
	public Multa(IPago pago, String detalle, double monto) {
		super(pago);	
		this.setDetalle(detalle);
		this.setMonto(monto);
	}

	@Override
	public String obtenerDetalle() {
		return pago.obtenerDetalle() + "con una multa por " + this.getDetalle().toUpperCase();
	}

	@Override
	public double obtenerMonto() {		
		return pago.obtenerMonto() + this.getMonto();
	}

}
