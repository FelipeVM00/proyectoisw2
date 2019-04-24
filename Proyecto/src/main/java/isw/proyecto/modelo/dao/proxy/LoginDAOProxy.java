package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Login;
import isw.proyecto.modelo.dao.LoginDAO;
import isw.proyecto.modelo.dao.impl.LoginDAOImpl;

public class LoginDAOProxy implements LoginDAO{

private static LoginDAO object;
	
	@Override
	public void crear(Login c) {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		
		object.crear(c);
		
	}

	@Override
	public Login leer(Login key) {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Login c) {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		
		object.actualizar(c);
		
	}

	@Override
	public void eliminar(Login key) {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		
		object.eliminar(key);
		
	}

	@Override
	public List<Login> leerTodo() {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		return object.leerTodo();
	}

	@Override
	public boolean validarCuenta(Login login) {
		if(object == null) {
			object = new LoginDAOImpl();
		}
		return object.validarCuenta(login);
	}

}
