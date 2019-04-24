package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.dao.ParqueaderoDAO;
import isw.proyecto.modelo.dao.impl.ParqueaderoDAOImpl;

public class ParqueaderoDAOProxy implements ParqueaderoDAO {

private static ParqueaderoDAO object;
	
	@Override
	public void crear(Parqueadero c) {
		if(object == null) {
			object = new ParqueaderoDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Parqueadero leer(Parqueadero key) {
		if(object == null) {
			object = new ParqueaderoDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Parqueadero c) {
		if(object == null) {
			object = new ParqueaderoDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Parqueadero key) {
		if(object == null) {
			object = new ParqueaderoDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Parqueadero> leerTodo() {
		if(object == null) {
			object = new ParqueaderoDAOImpl();
		}
		return object.leerTodo();
	}

}
