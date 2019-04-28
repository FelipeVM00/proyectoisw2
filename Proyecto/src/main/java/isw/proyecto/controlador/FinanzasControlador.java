package isw.proyecto.controlador;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.dao.impl.PagoDAOImpl;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import isw.proyecto.modelo.decorators.DescuentoEspecial;
import isw.proyecto.modelo.decorators.Multa;
import isw.proyecto.modelo.decorators.PagoDecorator;
import isw.proyecto.modelo.decorators.RecargoEspecial;
import isw.proyecto.util.ExpresionesUtil;
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
    private JFXTextField campoValor;

    @FXML
    private Label textoValorA;

    @FXML
    private JFXTextArea campoDetalles;

    @FXML
    private JFXButton btnOk;
    
    @FXML
    private JFXButton btnRecibir;
    
    @FXML
    private Pane paneAñadir;
    
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();
       
    private List<String> nombresResidentes = new ArrayList<String>();
    
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    private PagoAdministracion pago;
    
    private PagoDecorator decorador = null;
    
    private PagoDAOImpl pagoDAO = new PagoDAOImpl();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		cambiarEstilo();
		inicializarColumnas();
		paneAñadir.setVisible(false);
		inicializarBuscador();
		TextFields.bindAutoCompletion(campoNombre, nombresResidentes);
		TextFields.bindAutoCompletion(campoMesAPagar, meses);
		llenarTablaPagos();	
	}

	private void cambiarEstilo() {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
	}
	
	private void llenarTablaPagos() {
		pagos.addAll(pagoDAO.leerTodo());
	}
	
	private void inicializarBuscador() {
		
		for(Pago p : tablaPagos.getItems()) {
			nombresResidentes.add(columnaResidente.getCellObservableValue(p).getValue());
		}
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
		columnaFecha.setCellValueFactory(cell -> cell.getValue().fechaPagoProperty());
		columnaValor.setCellValueFactory(cell -> cell.getValue().valorPagoProperty());
		columnaResidente.setCellValueFactory(cell -> cell.getValue().residenteProperty());
	}
	
	public static void mostrarAlerta(String titulo, String msg, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(titulo);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
	
	@FXML
	void clickBtnDescuento(ActionEvent event) {
		paneAñadir.setVisible(true);
		btnRecibir.setVisible(false);
		campoDetalles.clear();		
		if(campoValor != null) {
			campoValor.clear();
		}
		textoValorA.setText("Valor descuento:");
	}	  

	@FXML
	void clickBtnMulta(ActionEvent event) {
		paneAñadir.setVisible(true);
		btnRecibir.setVisible(false);
		campoDetalles.clear();
		if(campoValor != null) {
			campoValor.clear();
		}
		textoValorA.setText("Valor multa:");
	}

	@FXML
	void clickBtnRecargo(ActionEvent event) {
		paneAñadir.setVisible(true);
		btnRecibir.setVisible(false);
		campoDetalles.clear();			
		if(campoValor != null) {
			campoValor.clear();
		}
		textoValorA.setText("Valor recargo:");		
	}    
	
    @FXML
    void clickBtnOk(ActionEvent event) {
    	mostrarAlerta("Operación exitosa !!!", "El valor se añadió satisfactoriamente", Alert.AlertType.INFORMATION);  	
    	if(textoValorA.getText().contains("multa")) {
    		decorador = new Multa(pago, campoDetalles.getText(), Double.valueOf(campoValor.getText()));
    		campoValorPago.setText(Integer.toString(Integer.valueOf(campoValorPago.getText()) + Integer.valueOf(campoValor.getText())));
    	} 
    	else if(textoValorA.getText().contains("descuento")) {
    		decorador = new DescuentoEspecial(pago, campoDetalles.getText(), Double.valueOf(campoValor.getText()));
    		campoValorPago.setText(Integer.toString(Integer.valueOf(campoValorPago.getText()) - Integer.valueOf(campoValor.getText())));
    	}
    	else if(textoValorA.getText().contains("recargo")) {
    		decorador = new RecargoEspecial(pago, campoDetalles.getText(), Double.valueOf(campoValor.getText()));
    		campoValorPago.setText(Integer.toString(Integer.valueOf(campoValorPago.getText()) + Integer.valueOf(campoValor.getText())));
    	}
    	paneAñadir.setVisible(false);
    	btnRecibir.setVisible(true);
    }
    
    @FXML
    void clickBtnRecibir(ActionEvent event) {
    	if(validarInfo()) {  		
    		String[] nombre = campoNombre.getText().split(" ");
        	pago = new PagoAdministracion();
        	pago.setFechaPago(campoFecha.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
        	pago.setMesAPagar(campoMesAPagar.getText());
        	pago.setValorPago(Integer.valueOf(campoValorPago.getText()));
        	pago.setResidente((Residente) new Residente.ResidenteBuilder().setNombre(nombre[0]).setApellido(nombre[1]).build());
        	pagoDAO.crear(pago);
        	pagos.add(pago);
    	}
    }
    
    private boolean validarInfo() {
    	String nombre = campoNombre.getText().replaceAll("\\s*$","");
    	if(!ExpresionesUtil.tieneSoloLetras(nombre)) {
    		System.out.println(nombre.replaceAll("\\s+",""));
    		mostrarAlerta("Error de ingreso", "En el campo de residente solo pueden ir letras", Alert.AlertType.ERROR);
    		return false;
    	}
    	else if(!ExpresionesUtil.tieneSoloNumeros(campoValorPago.getText())) {
    		mostrarAlerta("Error de ingreso", "En el campo de valor solo pueden ir numeros", Alert.AlertType.ERROR);
    		return false;
    	}
    	return true;
    }
}
