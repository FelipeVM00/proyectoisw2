package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.EmpresaContratada;
import isw.proyecto.modelo.dao.EmpresaDAO;
import isw.proyecto.modelo.dao.impl.EmpresaDAOImpl;

public class EmpresaDAOProxy implements EmpresaDAO {

private static EmpresaDAO object;
	
	@Override
	public void crear(EmpresaContratada c) {
		if(object == null) {
			object = new EmpresaDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public EmpresaContratada leer(EmpresaContratada key) {
		if(object == null) {
			object = new EmpresaDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(EmpresaContratada c) {
		if(object == null) {
			object = new EmpresaDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(EmpresaContratada key) {
		if(object == null) {
			object = new EmpresaDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<EmpresaContratada> leerTodo() {
		if(object == null) {
			object = new EmpresaDAOImpl();
		}
		return object.leerTodo();
	}
	
}
