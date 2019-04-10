package isw.proyecto.modelo.dao;

import isw.proyecto.modelo.Login;

public interface LoginDAO extends OperacionesDB<Login>{
	public boolean validarCuenta(Login login);
}
