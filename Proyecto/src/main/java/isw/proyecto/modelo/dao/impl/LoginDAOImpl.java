package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Login;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.LoginDAO;

public class LoginDAOImpl implements LoginDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Login c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login leer(Login key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Login c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Login key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Login> leerTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarCuenta(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String encriptarInfo(String info, String pass) throws Exception {
		return algoritmoEncript.encriptarInfo(info, pass);
	}

	public IAlgoritmoEncript getAlgoritmoEncript() {
		return algoritmoEncript;
	}

	public void setAlgoritmoEncript(IAlgoritmoEncript algoritmoEncript) {
		this.algoritmoEncript = algoritmoEncript;
	}
}
