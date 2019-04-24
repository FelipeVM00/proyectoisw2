package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Bloque;
import isw.proyecto.modelo.dao.BloqueDAO;
import isw.proyecto.modelo.dao.impl.BloqueDAOImpl;

public class BloqueDAOProxy implements BloqueDAO {

private static BloqueDAO object;
	
	@Override
	public void crear(Bloque c) {
		if(object == null) {
			object = new BloqueDAOImpl();
		}
		object.crear(c);
	}

	@Override
	public Bloque leer(Bloque key) {
		if(object == null) {
			object = new BloqueDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Bloque c) {
		if(object == null) {
			object = new BloqueDAOImpl();
		}
		object.actualizar(c);

	}

	@Override
	public void eliminar(Bloque key) {
		if(object == null) {
			object = new BloqueDAOImpl();
		}
		object.eliminar(key);

	}

	@Override
	public List<Bloque> leerTodo() {
		if(object == null) {
			object = new BloqueDAOImpl();
		}
		return object.leerTodo();
	}

}
