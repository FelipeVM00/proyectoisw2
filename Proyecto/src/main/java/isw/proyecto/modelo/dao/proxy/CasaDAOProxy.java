package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Casa;
import isw.proyecto.modelo.dao.CasaDAO;
import isw.proyecto.modelo.dao.impl.CasaDAOImpl;

public class CasaDAOProxy implements CasaDAO {

private static CasaDAO object;
	
	@Override
	public void crear(Casa c) {
		if(object == null) {
			object = new CasaDAOImpl();
		}
		
		object.crear(c);
	}

	@Override
	public Casa leer(Casa key) {
		if(object == null) {
			object = new CasaDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Casa c) {
		if(object == null) {
			object = new CasaDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Casa key) {
		if(object == null) {
			object = new CasaDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Casa> leerTodo() {
		if(object == null) {
			object = new CasaDAOImpl();
		}
		return object.leerTodo();
	}
	
}
