package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ResidenteDAO;

public class ResidenteDAOImpl implements ResidenteDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Residente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Residente leer(Residente key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Residente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Residente key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Residente> leerTodo() {
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
