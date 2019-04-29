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
import isw.proyecto.modelo.dao.PagoDAO;
import isw.proyecto.modelo.dao.impl.DAOFactory;
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

/*
 * Esta clase es el controlador de la vista Finanzas.
 */
public class FinanzasControlador implements Initializable{
	
	/*
	 * Panel principal de pestañas.
	 */
	@FXML
    private JFXTabPane pestañasPane;

	/*
	 * Texto de fondos editable.
	 */
    @FXML
    private Label fondosLabel;

    /*
     * Tabla de las transacciones de la cuenta de la zona residencial.
     */
    @FXML
    private TableView<Pago> tablaTransacciones;

    /*
     * Columna de fecha en la tabla de transacciones.
     */
    @FXML
    private TableColumn<Pago, String> columnaFecha;

    /*
     * Columna de descripcion en la tabla de transacciones.
     */
    @FXML
    private TableColumn<Pago, String> columnaDescripcion;

    /*
     * Columna de monto en la tabla de transacciones.
     */
    @FXML
    private TableColumn<Pago, String> columnaMonto;

    /*
     * Tabla de pagos de administración.
     */
    @FXML
    private TableView<Pago> tablaPagos;

    /*
     * Columna de id en la tabla de pagos.
     */
    @FXML
    private TableColumn<Pago, String> columnaID;

    /*
     * Columna de mes en la tabla de pagos.
     */
    @FXML
    private TableColumn<Pago, String> columnaMes;

    /*
     * Columna de valor en la tabla de pagos.
     */
    @FXML
    private TableColumn<Pago, String> columnaValor;

    /*
     * Columna de residente en la tabla de pagos.
     */
    @FXML
    private TableColumn<Pago, String> columnaResidente;

    /*
     * Campo para buscar un residente en la tabla de pagos.
     */
    @FXML
    private JFXTextField campoBusqueda;
    
    /*
     * Campo para ingresar el nombre del residente.
     */
    @FXML
    private JFXTextField campoNombre;

    /*
     * Campo para ingresar el mes a pagar.
     */
    @FXML
    private JFXTextField campoMesAPagar;

    /*
     * DatePicker para elegir la fecha del pago
     */
    @FXML
    private JFXDatePicker campoFecha;

    /*
     * Campo para ingresar el valor del pago.
     */
    @FXML
    private JFXTextField campoValorPago;

    /*
     * Boton para agregar una multa al pago.
     */
    @FXML
    private JFXButton btnMulta;

    /*
     * Boton para agregar un descuento al pago.
     */
    @FXML
    private JFXButton btnDescuento;

    /*
     * Boton para agregar un recargo al pago.
     */
    @FXML
    private JFXButton btnRecargo;

    /*
     * Campo para ingresar el valor a añadir al pago.
     */
    @FXML
    private JFXTextField campoValor;

    /*
     * Texto del tipo de decorador.
     */
    @FXML
    private Label textoValorA;

    /*
     * Campo para ingresar los detalles de la multa, descuento o recargo.
     */
    @FXML
    private JFXTextArea campoDetalles;

    /*
     * Boton para confirmar la multa, descuento o recargo.
     */
    @FXML
    private JFXButton btnOk;
    
    /*
     * Boton para confirmar que se recibe un pago y guardarlo en la base de datos.
     */
    @FXML
    private JFXButton btnRecibir;
    
    /*
     * Panel para añadir una multa, descuento o recargo.
     */
    @FXML
    private Pane paneAñadir;
    
    /*
     * Lista de pagos para añadir a la vista de la tabla.
     */
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();
       
    /*
     * Lista de nombres de residentes para autocompletar en la busqueda.
     */
    private List<String> nombresResidentes = new ArrayList<String>();
    
    /*
     * Lista de meses para autocompletar en su ingreso.
     */
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    /*
     * Variable de tipo PagoAdministracion para poder recibir un pago.
     */
    private PagoAdministracion pago;
    
    /*
     * Variable para almacenar la implementacion del patron decorator.
     */
    private PagoDecorator decorador = null;
    
    /*
     * Variable para realizar la conexión a la base de datos.
     */
    private PagoDAO pagoDAO = DAOFactory.getPagoDAO();

    /*
     * Se inicializan los principales componentes de la vista.
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
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

	/*
	 * Metodo para cambiar el estilo de la vista añadiendole el archivo custom.css.
	 */
	private void cambiarEstilo() {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
	}
	
	/*
	 * Metodo para rellenar la tabla de pagos haciendo la consulta a la base de datos.
	 */
	private void llenarTablaPagos() {
		pagos.addAll(pagoDAO.leerTodo());
	}
	
	/*
	 * Metodo para inicializar los buscadores de nombres para su autocompletacion
	 */
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
	/*
	 * Metodo para inicializar las columnas de la tabla de pagos.
	 */
	private void inicializarColumnas() {
		columnaID.setCellValueFactory(cell -> cell.getValue().idProperty());
		columnaMes.setCellValueFactory(cell -> cell.getValue().mesAPagarProperty());
		columnaFecha.setCellValueFactory(cell -> cell.getValue().fechaPagoProperty());
		columnaValor.setCellValueFactory(cell -> cell.getValue().valorPagoProperty());
		columnaResidente.setCellValueFactory(cell -> cell.getValue().residenteProperty());
	}
	
	/*
	 * Metodo de utilidad para mostrar una alerta en pantalla.
	 * @param titulo titulo de la alerta.
	 * @param msg mensaje de la alerta.
	 * @param tipo tipo de alerta.
	 */
	public static void mostrarAlerta(String titulo, String msg, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(titulo);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
	
	/*
	 * Metodo que escucha cuando se hace click en el boton de descuento.
	 */
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

	/*
	 * Metodo que escucha cuando se hace click en el boton de multa.
	 */
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

    /*
     * Metodo que escucha cuando se hace click en el boton de recargo.
     */
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
	
	/*
	 * Metodo que escucha cuando se hace click en el boton de OK.
	 */
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
    
    /*
     * Metodo que escucha cuando se hace click en el boton de recibir pago.
     */
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
    
    /*
     * Metodo para validar que la informacion ingresada en los campos sea correcta
     * @return Si es valida o no
     */
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
