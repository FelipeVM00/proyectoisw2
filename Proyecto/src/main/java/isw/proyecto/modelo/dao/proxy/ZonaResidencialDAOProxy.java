package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.ZonaResidencial;
import isw.proyecto.modelo.dao.ZonaResidencialDAO;
import isw.proyecto.modelo.dao.impl.ZonaResidencialDAOImpl;

public class ZonaResidencialDAOProxy implements ZonaResidencialDAO {

private static ZonaResidencialDAO object;
	
	@Override
	public void crear(ZonaResidencial c) {
		if(object == null) {
			object = new ZonaResidencialDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public ZonaResidencial leer(ZonaResidencial key) {
		if(object == null) {
			object = new ZonaResidencialDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(ZonaResidencial c) {
		if(object == null) {
			object = new ZonaResidencialDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(ZonaResidencial key) {
		if(object == null) {
			object = new ZonaResidencialDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<ZonaResidencial> leerTodo() {
		if(object == null) {
			object = new ZonaResidencialDAOImpl();
		}
		return object.leerTodo();
	}

}
