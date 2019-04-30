package isw.proyecto.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import isw.proyecto.modelo.EmpresaContratada;
import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.EmpresaDAO;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import isw.proyecto.modelo.factorymethod.DBFactory;
import isw.proyecto.modelo.factorymethod.DBType;
import isw.proyecto.modelo.factorymethod.IDBAdapter;

public class EmpresaDAOImpl implements EmpresaDAO, IEncriptador {

	private IAlgoritmoEncript algoritmoEncript;

	private static final String SQL_INSERT = "INSERT INTO empresas (nombre, tipoEmpresa, numeroContrato, telefono, fechaInicio, fechaTerminacion, valorContrato) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM empresas WHERE id = ?";
	private static final String SQL_UPDATE = "UPDATE empresas SET nombre = ?, tipoEmpresa = ?, numeroContrato = ?, telefono = ?, fechaInicio = ?, fechaTerminacion = ?, valorContrato = ? WHERE id = ?";
	private static final String SQL_READ = "SELECT * FROM empresas WHERE id = ?";
	private static final String SQL_READALL = "SELECT * FROM empresas";

	private IDBAdapter dbAdapter = DBFactory.getDBadapter(DBType.MySQL);

	private Connection conn;

	public EmpresaDAOImpl() {

	}

	@Override
	public void crear(EmpresaContratada c) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		try {
			conn = dbAdapter.getConnection();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(1, c.getNombre());
			ps.setString(2, c.getTipoEmpresa());
			ps.setString(3, c.getNumeroContrato());
			ps.setString(4, Integer.toString(c.getTelefono()));
			ps.setString(5, c.getFechaInicio().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(6, c.getFechaTerminacion().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(7, Double.toString(c.getValorContrato()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public EmpresaContratada leer(EmpresaContratada key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(EmpresaContratada c) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SQL_UPDATE);

			ps.setString(1, c.getNombre());
			ps.setString(2, c.getTipoEmpresa());
			ps.setString(3, c.getNumeroContrato());
			ps.setString(4, Integer.toString(c.getTelefono()));
			ps.setString(5, c.getFechaInicio().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(6, c.getFechaTerminacion().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(7, Double.toString(c.getValorContrato()));

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void eliminar(EmpresaContratada key) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmpresaContratada> leerTodo() {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		ArrayList<EmpresaContratada> empresas = new ArrayList<EmpresaContratada>();
		String nombre[];
		try {
			ps = conn.prepareStatement(SQL_READALL);

			res = ps.executeQuery();

			while (res.next()) {
				res.getString(1);
				res.getString(2);
				res.getString(3);
				res.getString(4);
				res.getString(5);
				res.getString(6);
				res.getString(7);
				//empresas.add(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
				//Help me, Ayuda
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

		return empresas;
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
