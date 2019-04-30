package isw.proyecto.controlador;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;

import isw.proyecto.modelo.*;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.util.ExpresionesUtil;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

public class EmpresasControlador implements Initializable {

	/**
	 * declarando botones
	 */
	@FXML
	private Button aniadirBT;
	@FXML
	private Button modificarBT;
	@FXML
	private Button eliminarBT;
	@FXML
	private Button nuevoBT;

	/**
	 * declarando textfields
	 */
	@FXML
	private TextField nombreTF;
	@FXML
	private TextField numeroContratoTF;
	@FXML
	private TextField telefonoTF;
	@FXML
	private TextField valorContratoTF;
	@FXML
	private JFXTextField campoBusqueda;

	/**
	 * declarando DatePicker
	 */
	@FXML
	private JFXDatePicker fechaInicioDP;

	@FXML
	private JFXDatePicker fechaTerminacionDP;

	/**
	 * declarando radio buttons
	 */
	@FXML
	private JFXRadioButton tipoEmpresaAseoRB;
	@FXML
	private JFXRadioButton tipoEmpresaMantenimientoRB;
	@FXML
	private JFXRadioButton tipoEmpresaVigilanciaRB;

	/**
	 * Lista de nombres de empresas para autocompletar en la busqueda.
	 */
	private List<String> nombresEmpresas = new ArrayList<String>();

	@FXML
	private TableView<EmpresaContratada> tablaContratos;
	@FXML
	private TableColumn<EmpresaContratada, String> nombreCL;
	@FXML
	private TableColumn<EmpresaContratada, String> tipoEmpresaCL;
	@FXML
	private TableColumn<EmpresaContratada, String> numeroContratoCL;
	@FXML
	private TableColumn<EmpresaContratada, String> telefonoCL;
	@FXML
	private TableColumn<EmpresaContratada, String> fechaInicioContratoCL;
	@FXML
	private TableColumn<EmpresaContratada, String> fechaTerminacionContratoCL;
	@FXML
	private TableColumn<EmpresaContratada, String> valorContratoCL;
	ObservableList<EmpresaContratada> contratos = FXCollections.observableArrayList();

	/**
	 * inicializa ToggleGroup
	 */
	@FXML
	private ToggleGroup tipoEmpresa;

	private int posicionEmpresaEnTabla;
	private EmpresaContratada empresa;

	/**
	 * Metodo que realiza las acciones tras pulsar el boton "Nuevo"
	 *
	 * @param event
	 */
	@FXML
	private void nuevo(ActionEvent event) {
		nombreTF.setText("");
		numeroContratoTF.setText("");
		telefonoTF.setText("");
		fechaInicioDP.setValue(null);
		fechaTerminacionDP.setValue(null);
		valorContratoTF.setText("");
		modificarBT.setDisable(true);
		eliminarBT.setDisable(true);
		aniadirBT.setDisable(false);
	}

	/*
	 * Metodo de utilidad para mostrar una alerta en pantalla.
	 * 
	 * @param titulo titulo de la alerta.
	 * 
	 * @param msg mensaje de la alerta.
	 * 
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

	/**
	 * Metodo que realiza las acciones tras pulsar el boton "Añadir"
	 *
	 * @param event
	 */
	@FXML
	void aniadir(ActionEvent event) {
		RadioButton seleccionado = (RadioButton) tipoEmpresa.getSelectedToggle();
		if (validarInfo()) {
			String[] nombre = nombreTF.getText().split(" ");
			if (seleccionado.getText().contains("Aseo")) {
				empresa = new EmpresaAseo();
				empresa.setNombre(nombreTF.getText());
				empresa.setNumeroContrato(numeroContratoTF.getText());
				empresa.setTelefono(Integer.valueOf(telefonoTF.getText()));
				empresa.setTipoEmpresa(seleccionado.getText());
				empresa.setFechaInicio(
						fechaInicioDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setFechaTerminacion(
						fechaTerminacionDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setValorContrato(Double.valueOf(valorContratoTF.getText()));
				contratos.add(empresa);
			} else if (seleccionado.getText().contains("Mantenimiento")) {
				empresa = new EmpresaMantenimiento();
				empresa.setNombre(nombreTF.getText());
				empresa.setNumeroContrato(numeroContratoTF.getText());
				empresa.setTelefono(Integer.valueOf(telefonoTF.getText()));
				empresa.setTipoEmpresa(seleccionado.getText());
				empresa.setFechaInicio(
						fechaInicioDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setFechaTerminacion(
						fechaTerminacionDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setValorContrato(Double.valueOf(valorContratoTF.getText()));
				contratos.add(empresa);
			} else if (seleccionado.getText().contains("Vigilancia")) {
				empresa = new EmpresaVigilancia();
				empresa.setNombre(nombreTF.getText());
				empresa.setNumeroContrato(numeroContratoTF.getText());
				empresa.setTelefono(Integer.valueOf(telefonoTF.getText()));
				empresa.setTipoEmpresa(seleccionado.getText());
				empresa.setFechaInicio(
						fechaInicioDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setFechaTerminacion(
						fechaTerminacionDP.getValue().format(DateTimeFormatter.ofPattern("d/MM/yyyy")).toString());
				empresa.setValorContrato(Double.valueOf(valorContratoTF.getText()));
				contratos.add(empresa);
			}
		}
	}

	/**
	 * Metodo que realiza las acciones tras pulsar el boton "Modificar"
	 *
	 * @param event
	 */
	@FXML
	private void modificar(ActionEvent event) {

	}

	/**
	 * Metodo que realiza las acciones tras pulsar el boton "Eliminar"
	 *
	 * @param event
	 */
	@FXML
	private void eliminar(ActionEvent event) {
		contratos.remove(posicionEmpresaEnTabla);
	}

	/**
	 * Listener de la tabla EmpresaContratada
	 */
	private final ListChangeListener<EmpresaContratada> selectorTablaEmpresas = new ListChangeListener<EmpresaContratada>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends EmpresaContratada> c) {
			ponerEmpresaSeleccionada();
		}
	};

	/**
	 * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaContratos"
	 */
	public EmpresaContratada getTablaEmpresaSeleccionada() {
		if (tablaContratos != null) {
			List<EmpresaContratada> tabla = tablaContratos.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final EmpresaContratada competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;
	}

	/**
	 * Metodo para poner en los textFields la tupla que selccionemos
	 */

	private void ponerEmpresaSeleccionada() {
		final EmpresaContratada empresas = getTablaEmpresaSeleccionada();
		posicionEmpresaEnTabla = contratos.indexOf(empresas);

		if (empresas != null) {

			/**
			 * Pongo los textFields con los datos correspondientes
			 */
			nombreTF.setText(empresas.getNombre());
			// tipo empresa
			numeroContratoTF.setText(empresas.getNumeroContrato());
			telefonoTF.setText(empresas.getTelefono().toString());
			fechaInicioDP.setValue(empresas.getFechaInicio());
			fechaTerminacionDP.setValue(empresas.getFechaTerminacion());
			valorContratoTF.setText(empresas.getValorContrato().toString());

			/**
			 * Pongo los botones en su estado correspondiente
			 */
			modificarBT.setDisable(false);
			eliminarBT.setDisable(false);
			aniadirBT.setDisable(true);
		}
	}

	/**
	 * Metodo para validar que la informacion ingresada en los campos sea correcta
	 * 
	 * @return Si es valida o no
	 */
	private boolean validarInfo() {
		String nombre = nombreTF.getText().replaceAll("\\s*$", "");
		if (!ExpresionesUtil.tieneSoloLetras(nombre)) {
			System.out.println(nombre.replaceAll("\\s+", ""));
			mostrarAlerta("Error de ingreso", "En el campo de Nombre solo pueden ir letras", Alert.AlertType.ERROR);
			return false;
		} else if (!ExpresionesUtil.tieneSoloNumeros(telefonoTF.getText())) {
			mostrarAlerta("Error de ingreso", "En el campo de Telefono solo pueden ir numeros", Alert.AlertType.ERROR);
			return false;
		} else if (!ExpresionesUtil.tieneSoloNumeros(numeroContratoTF.getText())) {
			mostrarAlerta("Error de ingreso", "En el campo de numero de contrato solo pueden ir numeros",
					Alert.AlertType.ERROR);
			return false;
		} else if (!ExpresionesUtil.tieneSoloNumeros(valorContratoTF.getText())) {
			mostrarAlerta("Error de ingreso", "En el campo de valor de contrato solo pueden ir numeros",
					Alert.AlertType.ERROR);
			return false;
		}
		return true;
	}

	/**
	 * Metodo para inicializar la tabla
	 */
	private void inicializarTablaContratos() {
		nombreCL.setCellValueFactory(cell -> cell.getValue().nombreProperty());
		tipoEmpresaCL.setCellValueFactory(cell -> cell.getValue().tipoEmpresaProperty());
		numeroContratoCL.setCellValueFactory(cell -> cell.getValue().numeroContratoProperty());
		telefonoCL.setCellValueFactory(cell -> cell.getValue().telefonoProperty());
		fechaInicioContratoCL.setCellValueFactory(cell -> cell.getValue().fechaInicioProperty());
		fechaTerminacionContratoCL.setCellValueFactory(cell -> cell.getValue().fechaTerminacionProperty());
		valorContratoCL.setCellValueFactory(cell -> cell.getValue().valorContratoProperty());
	}

	private void inicializarBuscador() {
		for (EmpresaContratada p : tablaContratos.getItems()) {
			nombresEmpresas.add(nombreCL.getCellObservableValue(p).getValue());
		}
		FilteredList<EmpresaContratada> datosFiltrados = new FilteredList<>(contratos, p -> true);
		campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
			datosFiltrados.setPredicate(contratoo -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (contratoo.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (contratoo.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});
		SortedList<EmpresaContratada> datosOrdenados = new SortedList<>(datosFiltrados);
		datosOrdenados.comparatorProperty().bind(tablaContratos.comparatorProperty());
		tablaContratos.setItems(datosOrdenados);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/**
		 * Inicializamos la tabla
		 */
		inicializarTablaContratos();
		inicializarBuscador();

		/**
		 * Ponemos estos dos botones para que no se puedan seleccionar
		 */
		modificarBT.setDisable(true);
		eliminarBT.setDisable(true);
	}

}
