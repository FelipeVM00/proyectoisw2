package isw.proyecto.controlador;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;

import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.dao.ReporteDAO;
import isw.proyecto.modelo.dao.impl.DAOFactory;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.factorymethod.ReporteFactory;
import isw.proyecto.modelo.factorymethod.TipoArchivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/*
 * Esta clase es el controlador de la vista Reportes.
 */
public class ReportesControlador{

	/*
	 * Boton para generar el reporte general de pagos.
	 */
	@FXML
    private JFXButton btnReportePagos;

	/*
	 * Boton para generar el reporte general de empresa.
	 */
    @FXML
    private JFXButton btnReporteEmpresas;

    /*
     * Boton para generar el reporte general de parqueaderos.
     */
    @FXML
    private JFXButton btnReporteParqueaderos;

    /*
     * Boton para generar el reporte general de reidentes.
     */
    @FXML
    private JFXButton btnReporteResidentes;

    /*
     * Boton para generar el reporte general de visitantes.
     */
    @FXML
    private JFXButton btnReporteVisitantes;
    
    /*
     * Variable para realizar la conexion a la base de datos.
     */
    private ReporteDAO reporteDAO = DAOFactory.getReporteDAO();
      
    /*
     * Lista observable para almacenar los pagos de ser necesario incluirlos en una tabla.
     */
    private ObservableList<Pago> pagosO = FXCollections.observableArrayList();
    
    
    private ObservableList<Parqueadero> parqueaderoO = FXCollections.observableArrayList();

    /*
     * Metodo que escucha cuando se hace click en el boton de empresas.
     */
    @FXML
    void cllickBtnReporteEmpresas(ActionEvent event) {

    }

    /*
     * Metodo que escucha cuando se hace click en el boton de pagos.
     */
    @FXML
    void cllickBtnReportePagos(ActionEvent event) {
    	pagosO.addAll(reporteDAO.leerPagos());
    	try {
			ReporteFactory.getTipoArchivo(TipoArchivo.TXT).generarReporte("Reporte_Pagos_Administracion", pagosO);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    /*
     * Metodo que escucha cuando se hace click en el boton de parqueaderos.
     */
    @FXML
    void cllickBtnReporteParqueaderos(ActionEvent event) {

    	parqueaderoO.addAll(reporteDAO.leerParqueaderos());
    	try {
			ReporteFactory.getTipoArchivo(TipoArchivo.TXT).generarReporte("Reporte_Parqueaderos", parqueaderoO);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /*
     * Metodo que escucha cuando se hace click en el boton de residentes.
     */
    @FXML
    void cllickBtnReporteResidentes(ActionEvent event) {

    }

    /*
     * Metodo que escucha cuando se hace click en el boton de visitantes.
     */
    @FXML
    void cllickBtnReporteVisitantes(ActionEvent event) {

    }

}
