package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Cuenta;
import isw.proyecto.modelo.dao.CuentaDAO;
import isw.proyecto.modelo.dao.impl.CuentaDAOImpl;

public class CuentaDAOProxy implements CuentaDAO {

private static CuentaDAO object;
	
	@Override
	public void crear(Cuenta c) {
		if(object == null) {
			object = new CuentaDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Cuenta leer(Cuenta key) {
		if(object == null) {
			object = new CuentaDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Cuenta c) {
		if(object == null) {
			object = new CuentaDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Cuenta key) {
		if(object == null) {
			object = new CuentaDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Cuenta> leerTodo() {
		if(object == null) {
			object = new CuentaDAOImpl();
		}
		return object.leerTodo();
	}

}
