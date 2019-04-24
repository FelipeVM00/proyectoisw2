package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Arrendatario;
import isw.proyecto.modelo.dao.ArrendatarioDAO;
import isw.proyecto.modelo.dao.impl.ArrendatarioDAOImpl;

public class ArrendatarioDAOProxy implements ArrendatarioDAO {

private static ArrendatarioDAO object;
	
	@Override
	public void crear(Arrendatario c) {
		if(object == null) {
			object = new ArrendatarioDAOImpl();
		}
		object.crear(c);

	}

	@Override
	public Arrendatario leer(Arrendatario key) {
		if(object == null) {
			object = new ArrendatarioDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Arrendatario c) {
		if(object == null) {
			object = new ArrendatarioDAOImpl();
		}
		object.actualizar(c);

	}

	@Override
	public void eliminar(Arrendatario key) {
		if(object == null) {
			object = new ArrendatarioDAOImpl();
		}
		object.eliminar(key);

	}

	@Override
	public List<Arrendatario> leerTodo() {
		if(object == null) {
			object = new ArrendatarioDAOImpl();
		}
		return object.leerTodo();
	}

}
