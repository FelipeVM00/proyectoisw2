package isw.proyecto.controlador;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.ParqueaderoDeCarro;
import isw.proyecto.modelo.ParqueaderoDeMoto;
import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.Visitante;
import isw.proyecto.modelo.dao.PagoDAO;
import isw.proyecto.modelo.dao.ParqueaderoDAO;
import isw.proyecto.modelo.dao.impl.DAOFactory;
import isw.proyecto.util.ExpresionesUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.StageStyle;

public class ParqueaderoControlador implements Initializable{

	
	/**
	 * declarando Botones
	 */
	@FXML
    private JFXButton asignarParqueoIndvCarro;
	@FXML
    private JFXButton sorteoAleatorioCarro;
	@FXML
    private JFXButton asignarParqueoIndvMoto;
    @FXML
    private JFXButton sorteoAleatorioMoto;
	
    
    /**
	 * declarando TabPane
	 */
	@FXML
    private JFXTabPane pestañasPane;

	
	/**
	 * declarando TextField
	 */
    @FXML
    private JFXTextField numeroParqueoCarro;
    @FXML
    private JFXTextField nombreResidenteCarro;
    @FXML
    private JFXTextField placaVehiculoCarro;
    @FXML
    private JFXTextField cedulaResidenteCarro;
    @FXML
    private JFXTextField bucarAsignacionCarro;
    @FXML
    private JFXTextField numeroParqueoMoto;
    @FXML
    private JFXTextField nombreResidenteMoto;
    @FXML
    private JFXTextField placaVehiculoMoto;
    @FXML
    private JFXTextField buscarAsignacionMoto;
    @FXML
    private JFXTextField cedulaResidenteMoto;
    
    
    /**
	 * declarando RadioButton
	 */
    @FXML
    private JFXRadioButton tipoResidenteCarro;
    @FXML
    private JFXRadioButton tipoVisitanteCarro;
    @FXML
    private JFXRadioButton tipoResidenteMoto;
    @FXML
    private JFXRadioButton tipoVisitanteMoto;
    
    
    /**
	 * declarando TableView
	 */
    @FXML
    private TableView<Parqueadero> tablaAsignacionCarros;
    @FXML
    private TableView<Parqueadero> tablaAsignacionMot;

    
    /**
	 * declarando TableColumn
	 */
    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoMot;
    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignMot;
    @FXML
    private TableColumn<Parqueadero, String> columnaPlacaCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaPlacaMot;
    
   
    @FXML
    private ToggleGroup tipoVisitante;
    
    /*
     * Variable para realizar la conexión a la base de datos.
     */
    private ParqueaderoDAO parqueaderoDAO = DAOFactory.getParqueaderoDAO();
    
    /*
     * Lista de nombres de residentes para autocompletar en la busqueda.
     */
    private List<String> nombresResidentes = new ArrayList<String>();
    
    private ObservableList<Parqueadero> parqueaderosCarro = FXCollections.observableArrayList();
    private ObservableList<Parqueadero> parqueaderosMoto = FXCollections.observableArrayList();

    private Parqueadero parqueadero;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarColumnas();
		inicializarBuscadorCarros();
		inicializarBuscadorMotos();
		llenarTablas();
		
	}
    
    private void inicializarColumnas() {
    	columnaNumParqueaderoCar.setCellValueFactory(cell -> cell.getValue().numeroProperty());
    	columnaNumParqueaderoMot.setCellValueFactory(cell -> cell.getValue().numeroProperty());
    	columnaResidenteAsignCar.setCellValueFactory(cell -> cell.getValue().ocupanteProperty());
    	columnaResidenteAsignMot.setCellValueFactory(cell -> cell.getValue().ocupanteProperty());
    	columnaPlacaCar.setCellValueFactory(cell -> cell.getValue().placaProperty());
    	columnaPlacaMot.setCellValueFactory(cell -> cell.getValue().placaProperty());
  
    }

    
    private void llenarTablas() {
		parqueaderosCarro.addAll(parqueaderoDAO.leerTodo());
    	parqueaderosMoto.addAll(parqueaderoDAO.leerTodo());
	}
    
    /*
	 * Metodo para inicializar los buscadores de nombres para su autocompletacion
	 */
	private void inicializarBuscadorCarros() {
		
		for(Parqueadero p : tablaAsignacionCarros.getItems()) {
			nombresResidentes.add(columnaResidenteAsignCar.getCellObservableValue(p).getValue());
		}
		FilteredList<Parqueadero> datosFiltrados = new FilteredList<>(parqueaderosCarro, p->true); 		
		bucarAsignacionCarro.textProperty().addListener((observable, oldValue, newValue) -> {
			datosFiltrados.setPredicate(parqueaderoo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (parqueaderoo.getOcupante().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; 
            });
        });		
		SortedList<Parqueadero> datosOrdenados = new SortedList<>(datosFiltrados);	
		datosOrdenados.comparatorProperty().bind(tablaAsignacionCarros.comparatorProperty());
		tablaAsignacionCarros.setItems(datosOrdenados);
	}
	
	/*
	 * Metodo para inicializar los buscadores de nombres para su autocompletacion
	 */
	private void inicializarBuscadorMotos() {
		
		for(Parqueadero p : tablaAsignacionMot.getItems()) {
			nombresResidentes.add(columnaResidenteAsignMot.getCellObservableValue(p).getValue());
		}
		FilteredList<Parqueadero> datosFiltrados = new FilteredList<>(parqueaderosMoto, p->true); 		
		buscarAsignacionMoto.textProperty().addListener((observable, oldValue, newValue) -> {
			datosFiltrados.setPredicate(parqueaderoo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (parqueaderoo.getOcupante().getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });		
		SortedList<Parqueadero> datosOrdenados = new SortedList<>(datosFiltrados);	
		datosOrdenados.comparatorProperty().bind(tablaAsignacionMot.comparatorProperty());
		tablaAsignacionMot.setItems(datosOrdenados);
}
	@FXML
	private void nuevoCarro(ActionEvent evento) {
		
		numeroParqueoCarro.setText("");
		nombreResidenteCarro.setText("");
		placaVehiculoCarro.setText("");
		cedulaResidenteCarro.setText("");
		asignarParqueoIndvCarro.setDisable(false);
		
	}
	
	@FXML
	public void nuevoMoto(ActionEvent evento) {
		
		numeroParqueoMoto.setText("");
		nombreResidenteMoto.setText("");
		placaVehiculoMoto.setText("");
		cedulaResidenteMoto.setText("");
		asignarParqueoIndvMoto.setDisable(false);
		
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
     * Metodo para validar que la informacion ingresada en los campos sea correcta
     * @return Si es valida o no
     */
    private boolean validarInfoCarro() {
    	String nombre = nombreResidenteCarro.getText().replaceAll("\\s*$","");
    	if(!ExpresionesUtil.tieneSoloLetras(nombre)) {
    		System.out.println(nombre.replaceAll("\\s+",""));
    		mostrarAlerta("Error de ingreso", "En el campo de residente solo pueden ir letras", Alert.AlertType.ERROR);
    		return false;
    	}
    	else if(!ExpresionesUtil.tieneSoloNumeros(cedulaResidenteCarro.getText())) {
    		mostrarAlerta("Error de ingreso", "En el campo de cedula solo pueden ir numeros", Alert.AlertType.ERROR);
    		return false;
    	}
    	return true;
    }
    
    private boolean validarInfoMoto() {
    	String nombre = nombreResidenteMoto.getText().replaceAll("\\s*$","");
    	if(!ExpresionesUtil.tieneSoloLetras(nombre)) {
    		System.out.println(nombre.replaceAll("\\s+",""));
    		mostrarAlerta("Error de ingreso", "En el campo de residente solo pueden ir letras", Alert.AlertType.ERROR);
    		return false;
    	}
    	else if(!ExpresionesUtil.tieneSoloNumeros(cedulaResidenteMoto.getText())) {
    		mostrarAlerta("Error de ingreso", "En el campo de cedula solo pueden ir numeros", Alert.AlertType.ERROR);
    		return false;
    	}
    	return true;
    }
    
    
	@FXML
    void clickBotonAsignarCar(ActionEvent event) {

		if(validarInfoCarro()) {
			
			String[] nombre = nombreResidenteCarro.getText().split(" ");
			parqueadero = new ParqueaderoDeCarro();
			parqueadero.setNumero(Integer.valueOf(numeroParqueoCarro.getText()));
			parqueadero.setOcupante((Residente) new Residente.ResidenteBuilder().setNombre(nombre[0]).setApellido(nombre[1]).build());
			parqueadero.setPlaca(placaVehiculoCarro.getText());
			parqueadero.setNumeroPiso(1);
			parqueadero.setVisitante((Visitante) new Visitante.VisitanteBuilder().setNombre(" ").setApellido(" ").build());
			
			parqueaderoDAO.crear(parqueadero);
			parqueaderosCarro.add(parqueadero);
			
			
		}
		
    }

    @FXML
    void clickBotonAsignarMot(ActionEvent event) {
    		
    		String[] nombre = nombreResidenteMoto.getText().split(" ");
    		parqueadero = new ParqueaderoDeMoto();
    		parqueadero.setNumero(Integer.valueOf(numeroParqueoMoto.getText()));
    		parqueadero.setOcupante((Residente) new Residente.ResidenteBuilder().setNombre(nombre[0]).setApellido(nombre[1]).build());
    		parqueadero.setPlaca(placaVehiculoMoto.getText());
    		
    		parqueaderoDAO.crear(parqueadero);
    		parqueaderosMoto.add(parqueadero);
    		
    }

    @FXML
    void clickBotonSorteoCar(ActionEvent event) {

    }

    @FXML
    void clickBotonSorteoMot(ActionEvent event) {

    }
}
