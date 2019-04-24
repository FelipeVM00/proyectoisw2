package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Empleado;
import isw.proyecto.modelo.dao.EmpleadoDAO;
import isw.proyecto.modelo.dao.impl.EmpleadoDAOImpl;

public class EmpleadoDAOProxy implements EmpleadoDAO {

private static EmpleadoDAO object;
	
	@Override
	public void crear(Empleado c) {
		if(object == null) {
			object = new EmpleadoDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Empleado leer(Empleado key) {
		if(object == null) {
			object = new EmpleadoDAOImpl();
		}
		
		return object.leer(key);
	}

	@Override
	public void actualizar(Empleado c) {
		if(object == null) {
			object = new EmpleadoDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Empleado key) {
		if(object == null) {
			object = new EmpleadoDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Empleado> leerTodo() {
		if(object == null) {
			object = new EmpleadoDAOImpl();
		}
		return object.leerTodo();
	}

}
