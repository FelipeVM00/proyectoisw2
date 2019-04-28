package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.EmpresaContratada;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.EmpresaDAO;

public class EmpresaDAOImpl implements EmpresaDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(EmpresaContratada c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpresaContratada leer(EmpresaContratada key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(EmpresaContratada c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(EmpresaContratada key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpresaContratada> leerTodo() {
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
