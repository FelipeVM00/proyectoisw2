package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.ZonaResidencial;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ZonaResidencialDAO;

public class ZonaResidencialDAOImpl implements ZonaResidencialDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(ZonaResidencial c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ZonaResidencial leer(ZonaResidencial key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ZonaResidencial c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(ZonaResidencial key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ZonaResidencial> leerTodo() {
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
