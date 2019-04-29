package isw.proyecto.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import isw.proyecto.modelo.EmpresaContratada;
import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.Visitante;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ReporteDAO;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import isw.proyecto.modelo.factorymethod.DBFactory;
import isw.proyecto.modelo.factorymethod.DBType;
import isw.proyecto.modelo.factorymethod.IDBAdapter;
import isw.proyecto.modelo.factorymethod.IReporte;

public class ReporteDAOImpl implements ReporteDAO, IEncriptador{

	private IAlgoritmoEncript algoritmoEncript;

	private static final String SQL_READALL = "SELECT * FROM pagos";
	
	private IDBAdapter dbAdapter = DBFactory.getDBadapter(DBType.MySQL);
	
	private Connection conn;
	
	@Override
	public List<Pago> leerPagos() {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		String nombre[];
		try {
			ps = conn.prepareStatement(SQL_READALL);
			res = ps.executeQuery();
					
			while(res.next()) {
				nombre= res.getString(5).split(" ");
				pagos.add(new PagoAdministracion(Integer.valueOf(res.getString(1)), 
						Double.valueOf(res.getString(2)), 
						res.getString(3), res.getString(4), 
						(Residente) new Residente.ResidenteBuilder().setNombre(nombre[0]).setApellido(nombre[1]).build()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pagos;
	}

	@Override
	public List<EmpresaContratada> leerEmpresas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Residente> leerResidentes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Visitante> leerVisitantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parqueadero> leerParqueaderos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(IReporte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IReporte leer(IReporte key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(IReporte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(IReporte key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IReporte> leerTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encriptarInfo(String info, String pass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
