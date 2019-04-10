package isw.proyecto.modelo.decorators;

import isw.proyecto.modelo.decorator.impl.pago.IPago;

public class RecargoEspecial extends PagoDecorator{

	public RecargoEspecial(IPago pago, String detalle, double monto) {
		super(pago);	
		this.setDetalle(detalle);
		this.setMonto(monto);
	}

	@Override
	public String obtenerDetalle() {
		return pago.obtenerDetalle() + "con un recargo especial por " + this.getDetalle().toUpperCase();
	}

	@Override
	public double obtenerMonto() {		
		return pago.obtenerMonto() + this.getMonto();
	}
	
}
