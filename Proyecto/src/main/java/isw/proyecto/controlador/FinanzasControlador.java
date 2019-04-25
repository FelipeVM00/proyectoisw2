package isw.proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;

public class FinanzasControlador implements Initializable{
	
	@FXML
    private JFXTabPane pestañasPane;

    @FXML
    private Label fondosLabel;

    @FXML
    private JFXTreeTableView<?> transaccionesTabla;

    @FXML
    private TreeTableColumn<Pago, String> columnaFecha;

    @FXML
    private TreeTableColumn<Pago, String> columnaDescripcion;

    @FXML
    private TreeTableColumn<Pago, String> columnaMonto;

    @FXML
    private TreeTableColumn<Pago, String> columnaID;

    @FXML
    private TreeTableColumn<Pago, String> columnaMesAPagar;

    @FXML
    private TreeTableColumn<Pago, String> columnaFechaPago;

    @FXML
    private TreeTableColumn<Pago, String> columnaValorPago;

    @FXML
    private TreeTableColumn<Pago, String> columnaResidente;
    
    @FXML
    private JFXTreeTableView<?> tablaPagos;

    @FXML
    private JFXTextField campoBusqueda;
    
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		cambiarEstilo();	
	}

	private void cambiarEstilo() {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
	}
    
}
