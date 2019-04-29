package isw.proyecto.modelo.decorator.impl.pago;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import isw.proyecto.modelo.Residente;
import javafx.beans.property.SimpleStringProperty;

/*
 * Esta clase es la abstraccion de un pago.
 */
public abstract class Pago implements IPago{
	
	/*
	 * Identificación del pago.
	 */
	private int id;
	
	/*
	 * Valor del pago.
	 */
	private double valorPago;
	
	/*
	 * Fecha del pago.
	 */
	private LocalDate fechaPago;
	
	/*
	 * Mes del pago.
	 */
	private String mesAPagar;
	
	/*
	 * Residente que realizó el pago.
	 */
	private Residente residente;
	
	/*
	 * Constructor por defecto sin parametros.
	 */
	public Pago() {
	}
	
	/*
	 * Constructor principal con todos los datos del pago.
	 */
	public Pago(int id, double valor, String fecha, String mes, Residente residente) {
		this.setId(0);
		this.valorPago = valor;
		this.setFechaPago(fecha);
		this.mesAPagar = mes;
		this.residente = residente;
	}
	
	/*
	 * Devuelve la identificación del pago.
	 * @return id del pago.
	 */
	public int getId() {
		return id;
	}

	/*
	 * Establece la identificación del pago.
	 * @param id id del pago.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Devuelve el residente que realizó el pago.
	 * @return residente residente del pago.
	 */
	public Residente getResidente() {
		return residente;
	}

	/*
	 * Establece el residente que realizó el pago.
	 * @param residente residente del pago.
	 */
	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	/*
	 * Devuelve el valor del pago.
	 * @return valor del pago.
	 */
	public double getValorPago() {
		return valorPago;
	}

	/*
	 * Establece el valor del pago.
	 * @param valorPago valor del pago.
	 */
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	/*
	 * Devuelve la fecha del pago.
	 * @return fecha del pago.
	 */
	public LocalDate getFechaPago() {
		return fechaPago;
	}

	/*
	 * Establece la fecha del pago (La convierte de tipo String a LocalDate).
	 * @param fechaPago fecha del pago.
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = LocalDate.parse(fechaPago, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	/*
	 * Devuelve el mes del pago.
	 * @return mes del pago.
	 */
	public String getMesAPagar() {
		return mesAPagar;
	}

	/*
	 * Establece el mes del pago.
	 * @param mesAPagar mes del pago.
	 */
	public void setMesAPagar(String mesAPagar) {
		this.mesAPagar = mesAPagar;
	}
	
	/*
	 * Devuelve la id del pago despues de convertirla a tipo SimpleStringProperty.
	 * @return id del pago.
	 */
	public SimpleStringProperty idProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Integer.toString(id));
		return str;
	}
	
	/*
	 * Devuelve el valor del pago despues de convertirla a tipo SimpleStringProperty.
	 * @return valor del pago.
	 */
	public SimpleStringProperty valorPagoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Double.toString(valorPago));
		return str;
	}
	
	/*
	 * Devuelve la fecha del pago despues de convertirla a tipo SimpleStringProperty.
	 * @return fecha del pago.
	 */
	public SimpleStringProperty fechaPagoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaPago.toString());
		return str;
	}
	
	/*
	 * Devuelve el mes del pago despues de convertirla a tipo SimpleStringProperty.
	 * @return mes del pago.
	 */
	public SimpleStringProperty mesAPagarProperty() {
		SimpleStringProperty str = new SimpleStringProperty(mesAPagar);
		return str;
	}
	
	/*
	 * Devuelve el residente del pago despues de convertirla a tipo SimpleStringProperty.
	 * @return residente del pago.
	 */
	public SimpleStringProperty residenteProperty() {
		SimpleStringProperty str = new SimpleStringProperty(residente.getNombre() + " " + residente.getApellido());
		return str;
	}
	
	@Override
	public String toString() {
		return "Pago{ " + "identificación: " 
				+ id + " Valor del pago: " 
				+ valorPago + " Fecha del pago: " 
				+ fechaPago + " Mes del pago: " + mesAPagar 
				+ " Residente que pagó: " 
				+ residente.getNombre() + " " 				+ residente.getApellido();	
	}
}
