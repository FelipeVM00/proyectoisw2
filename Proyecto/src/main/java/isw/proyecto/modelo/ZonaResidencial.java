package isw.proyecto.modelo;

import java.util.Set;

public class ZonaResidencial {

	private static ZonaResidencial singleton;
	private int estrato;
	private Set<Administrador> adminsACargo;
	private Set<Bloque> conjuntoDeBloques;
	private Set<Casa> conjuntoDeCasas;
	private Set<ZonaParqueadero> zonaParqueadero;
	private Set<EmpresaContratada> empresasContratadas;
	
	
	private ZonaResidencial() {
		
	}
	
	private static synchronized void crearInstancia() {
		if(singleton == null) {
			singleton = new ZonaResidencial();
		}
	}
	
	public static ZonaResidencial getInstancia() {
		if(singleton == null) {
			crearInstancia();
		}
		return singleton;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public Set<Administrador> getAdminsACargo() {
		return adminsACargo;
	}

	public void setAdminsACargo(Set<Administrador> adminsACargo) {
		this.adminsACargo = adminsACargo;
	}

	public Set<Bloque> getConjuntoDeBloques() {
		return conjuntoDeBloques;
	}

	public void setConjuntoDeBloques(Set<Bloque> conjuntoDeBloques) {
		this.conjuntoDeBloques = conjuntoDeBloques;
	}

	public Set<Casa> getConjuntoDeCasas() {
		return conjuntoDeCasas;
	}

	public void setConjuntoDeCasas(Set<Casa> conjuntoDeCasas) {
		this.conjuntoDeCasas = conjuntoDeCasas;
	}

	public Set<ZonaParqueadero> getZonaParqueadero() {
		return zonaParqueadero;
	}

	public void setZonaParqueadero(Set<ZonaParqueadero> zonaParqueadero) {
		this.zonaParqueadero = zonaParqueadero;
	}

	public Set<EmpresaContratada> getEmpresasContratadas() {
		return empresasContratadas;
	}

	public void setEmpresasContratadas(Set<EmpresaContratada> empresasContratadas) {
		this.empresasContratadas = empresasContratadas;
	}
	
	
}
