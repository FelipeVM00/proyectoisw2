package isw.proyecto.modelo.facade;

import isw.proyecto.modelo.facade.subsistemas.SistemaControlVisitantes;
import isw.proyecto.modelo.facade.subsistemas.SistemaQuejas;

public class SubSistemasFacadeImpl implements ISubSistemasFacade{

	SistemaControlVisitantes sistemaControlVisitantes;
	SistemaQuejas sistemaQuejas;

	@Override
	public void pedirReporte() {	
		sistemaControlVisitantes.generarReporteVisitas();
	}

	@Override
	public void pedirQuejas() {
		sistemaQuejas.generarReporteQuejas();
	}
	
}
