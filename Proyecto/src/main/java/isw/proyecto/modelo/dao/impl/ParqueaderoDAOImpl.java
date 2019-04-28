package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ParqueaderoDAO;

public class ParqueaderoDAOImpl implements ParqueaderoDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Parqueadero c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parqueadero leer(Parqueadero key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Parqueadero c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Parqueadero key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Parqueadero> leerTodo() {
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
