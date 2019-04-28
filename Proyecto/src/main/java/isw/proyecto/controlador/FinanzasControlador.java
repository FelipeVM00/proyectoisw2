package isw.proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

public class FinanzasControlador implements Initializable{
	
	@FXML
    private JFXTabPane pestañasPane;

    @FXML
    private Label fondosLabel;

    @FXML
    private TableView<Pago> tablaTransacciones;

    @FXML
    private TableColumn<Pago, String> columnaFecha;

    @FXML
    private TableColumn<Pago, String> columnaDescripcion;

    @FXML
    private TableColumn<Pago, String> columnaMonto;

    @FXML
    private TableView<Pago> tablaPagos;

    @FXML
    private TableColumn<Pago, String> columnaID;

    @FXML
    private TableColumn<Pago, String> columnaMes;

    @FXML
    private TableColumn<Pago, String> columnaValor;

    @FXML
    private TableColumn<Pago, String> columnaResidente;

    @FXML
    private JFXTextField campoBusqueda;
    
    @FXML
    private JFXTextField campoNombre;

    @FXML
    private JFXTextField campoMesAPagar;

    @FXML
    private JFXDatePicker campoFecha;

    @FXML
    private JFXTextField campoValorPago;

    @FXML
    private JFXButton btnMulta;

    @FXML
    private JFXButton btnDescuento;

    @FXML
    private JFXButton btnRecargo;

    @FXML
    private JFXTextField campoValorA;

    @FXML
    private Label textoValorA;

    @FXML
    private JFXTextArea campoDetalles;

    @FXML
    private JFXButton btnOk;
    
    @FXML
    private Pane paneAñadir;
    
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();
    
    private Boolean terminoAñadir;
    
    private String[] nombresResidentes = {"felipe", "andres", "david"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		cambiarEstilo();
		inicializarColumnas();
		paneAñadir.setVisible(false);
		inicializarBuscador();
		TextFields.bindAutoCompletion(campoNombre, nombresResidentes);
		llenarTablaPagos();	
	}

	private void cambiarEstilo() {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
	}
	
	private void llenarTablaPagos() {
		Pago pago = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("Felipe").setApellido("Vargas").build());
		Pago pago2 = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("asdadasd").setApellido("asdasd").build());
		Pago pago3 = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("Fel3241pe").setApellido("Vasdadeas").build());
		pagos.add(pago);
		pagos.add(pago2);
		pagos.add(pago3);	
	}
	
	private void inicializarBuscador() {
		FilteredList<Pago> datosFiltrados = new FilteredList<>(pagos, p->true); 		
		campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
			datosFiltrados.setPredicate(pagoo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (pagoo.getResidente().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (pagoo.getResidente().getApellido().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });		
		SortedList<Pago> datosOrdenados = new SortedList<>(datosFiltrados);	
		datosOrdenados.comparatorProperty().bind(tablaPagos.comparatorProperty());
		tablaPagos.setItems(datosOrdenados);
	}
	
	private void inicializarColumnas() {
		columnaID.setCellValueFactory(cell -> cell.getValue().idProperty());
		columnaMes.setCellValueFactory(cell -> cell.getValue().mesAPagarProperty());
		columnaValor.setCellValueFactory(cell -> cell.getValue().valorPagoProperty());
		columnaResidente.setCellValueFactory(cell -> cell.getValue().residenteProperty());
	}
	
	public static void mostrarAlerta(String titulo, String msg) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(titulo);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
	
	@FXML
	void clickBtnDescuento(ActionEvent event) {
		terminoAñadir = false;	
		paneAñadir.setVisible(true);
		campoDetalles.clear();
		if(terminoAñadir) {			
			textoValorA.setText("Valor descuento:");
		}else {
			mostrarAlerta("No terminó de añadir el descuento", "Por favor termine de añadir el descuento.");
		}
	}	  

	@FXML
	void clickBtnMulta(ActionEvent event) {
		paneAñadir.setVisible(true);
		if(terminoAñadir) {			
			textoValorA.setText("Valor multa:");
		}else {
			mostrarAlerta("No terminó de añadir la multa", "Por favor termine de añadir la multa.");
		}
	}

	@FXML
	void clickBtnRecargo(ActionEvent event) {
		paneAñadir.setVisible(true);
		if(terminoAñadir) {			
			textoValorA.setText("Valor recargo:");
		}else {
			mostrarAlerta("No terminó de añadir el recargo", "Por favor termine de añadir el recargo.");
		}
	}    
	
    @FXML
    void clickBtnOk(ActionEvent event) {
    	
    }
}
