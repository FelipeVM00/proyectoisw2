package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Cuenta;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.CuentaDAO;

public class CuentaDAOImpl implements CuentaDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Cuenta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta leer(Cuenta key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Cuenta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cuenta key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cuenta> leerTodo() {
		// TODO Auto-generated method stub
		return null;
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
