package isw.proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		cambiarEstilo();
		Pago pago = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("Felipe").setApellido("Vargas").build());
		Pago pago2 = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("asdadasd").setApellido("asdasd").build());
		Pago pago3 = new PagoAdministracion(200.0, "26/04/2019", "Abril", (Residente) new Residente.ResidenteBuilder().setNombre("Fel3241pe").setApellido("Vasdadeas").build());
		pagos.add(pago);
		pagos.add(pago2);
		pagos.add(pago3);	
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
		columnaID.setCellValueFactory(cell -> cell.getValue().idProperty());
		columnaMes.setCellValueFactory(cell -> cell.getValue().mesAPagarProperty());
		columnaValor.setCellValueFactory(cell -> cell.getValue().valorPagoProperty());
		columnaResidente.setCellValueFactory(cell -> cell.getValue().residenteProperty());
		
	}

	private void cambiarEstilo() {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
	}
    
}
