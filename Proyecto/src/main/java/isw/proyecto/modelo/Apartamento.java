package isw.proyecto.modelo;

public class Apartamento extends Vivienda{

	private int numeroPiso;
	private int bloque;
	
	public Apartamento() {
		super();
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public int getBloque() {
		return bloque;
	}

	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	
	
}
