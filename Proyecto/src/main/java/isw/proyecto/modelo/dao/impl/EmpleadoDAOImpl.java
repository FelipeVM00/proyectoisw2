package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Empleado;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.EmpleadoDAO;

public class EmpleadoDAOImpl implements EmpleadoDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Empleado c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado leer(Empleado key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Empleado c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Empleado key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> leerTodo() {
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
