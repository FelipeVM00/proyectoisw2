package isw.proyecto.modelo;

public abstract class Parqueadero {

	private int numero;
	private int numeroPiso;
	private Residente ocupante;
	private Visitante visitante;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public Residente getOcupante() {
		return ocupante;
	}

	public void setOcupante(Residente ocupante) {
		this.ocupante = ocupante;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
	
}
