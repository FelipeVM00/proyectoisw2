package isw.proyecto.modelo;

public abstract class Vivienda {

	private int id;
	private Residente residente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Residente getResidente() {
		return residente;
	}
	public void setResidente(Residente residente) {
		this.residente = residente;
	}
	
}
