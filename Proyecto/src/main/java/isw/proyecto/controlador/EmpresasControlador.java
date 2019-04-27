package isw.proyecto.controlador;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import isw.proyecto.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpresasControlador implements Initializable {

	// declarando botones
	@FXML
	private Button aniadirBT;
	@FXML
	private Button modificarBT;
	@FXML
	private Button eliminarBT;
	@FXML
	private Button nuevoBT;

	// declarando textfields
	@FXML
	private TextField nombreTF;
	@FXML
	private TextField numeroContratoTF;
	@FXML
	private TextField telefonoTF;
	@FXML
	private TextField fechaInicioTF;
	@FXML
	private TextField fechaTerminacionTF;
	@FXML
	private TextField valorContratoTF;
	
	//declarando radio buttons
	@FXML
	private RadioButton tipoEmpresaAseoRB;
	@FXML
	private RadioButton tipoEmpresaMantenimientoRB;
	@FXML
	private RadioButton tipoEmpresaVigilanciaRB;

	// declarando tablas y columnas
	@FXML
	private TableView<EmpresaContratada> tablaContratos;
	@FXML
	private TableColumn nombreCL;
	@FXML
	private TableColumn tipoEmpresaCL;
	@FXML
	private TableColumn numeroContratoCL;
	@FXML
	private TableColumn telefonoCL;
	@FXML
	private TableColumn fechaInicioContratoCL;
	@FXML
	private TableColumn fechaTerminacionContratoCL;
	@FXML
	private TableColumn valorContratoCL;
	ObservableList<EmpresaContratada> contratos;

	private int posicionEmpresaEnTabla;

	@FXML
	private void nuevo(ActionEvent event) {
		nombreTF.setText("");
		//tipoEmpresaTF.setText("");
		numeroContratoTF.setText("");
		telefonoTF.setText("");
		fechaInicioTF.setText("");
		fechaTerminacionTF.setText("");
		valorContratoTF.setText("");
		modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
	}

	@FXML
	private void aniadir(ActionEvent event) {
		EmpresaContratada empresas = new EmpresaAseo();
		empresas.nombre.set(nombreTF.getText());
		//empresas.tipoEmpresa.set(tipoEmpresaTF.getText());
		empresas.numeroContrato.set(numeroContratoTF.getText());
		empresas.telefono.set(telefonoTF.getText());
		empresas.fechaInicio.set(fechaInicioTF.getText());
		empresas.fechaTerminacion.set(fechaTerminacionTF.getText());
		empresas.valorContrato.set(valorContratoTF.getText());
		contratos.add(empresas);
	}

	@FXML
	private void modificar(ActionEvent event) {
		EmpresaContratada empresas = new EmpresaAseo();
		empresas.nombre.set(nombreTF.getText());
		//empresas.tipoEmpresa.set(tipoEmpresaTF.getText());
		empresas.numeroContrato.set(numeroContratoTF.getText());
		empresas.telefono.set(telefonoTF.getText());
		empresas.fechaInicio.set(fechaInicioTF.getText());
		empresas.fechaTerminacion.set(fechaTerminacionTF.getText());
		empresas.valorContrato.set(valorContratoTF.getText());
		contratos.set(posicionEmpresaEnTabla, empresas);
	}

	@FXML
	private void eliminar(ActionEvent event) {
		contratos.remove(posicionEmpresaEnTabla);
	}

	private final ListChangeListener<EmpresaContratada> selectorTablaEmpresas = new ListChangeListener<EmpresaContratada>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends EmpresaContratada> c) {
			ponerEmpresaSeleccionada();
		}
	};

	
	 //PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaContratos"
	 
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

	// Metodo para poner en los textFields la tupla que selccionemos
	 
	private void ponerEmpresaSeleccionada() {
		final EmpresaContratada empresas = getTablaEmpresaSeleccionada();
		posicionEmpresaEnTabla = contratos.indexOf(empresas);

		if (empresas != null) {

			// Pongo los textFields con los datos correspondientes
			nombreTF.setText(empresas.getNombre());
			//tipoEmpresaTF.setText(empresas.getTipoEmpresa());
			numeroContratoTF.setText(empresas.getNumeroContrato());
			telefonoTF.setText(empresas.getTelefono());
			fechaInicioTF.setText(empresas.getFechaInicio());
			fechaTerminacionTF.setText(empresas.getFechaTerminacion());
			valorContratoTF.setText(empresas.getValorContrato());

			// Pongo los botones en su estado correspondiente
			modificarBT.setDisable(false);
			eliminarBT.setDisable(false);
			aniadirBT.setDisable(true);
		}
	}

	// Metodo para inicializar la tabla
	 
	private void inicializarTablaContratos() {
		nombreCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("nombre"));
		tipoEmpresaCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("tipo de empresa"));
		numeroContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("numero de contrato"));
		telefonoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("telefono"));
		fechaInicioContratoCL.setCellValueFactory(
				new PropertyValueFactory<EmpresaContratada, String>("fecha de inicio de contrato"));
		fechaTerminacionContratoCL.setCellValueFactory(
				new PropertyValueFactory<EmpresaContratada, String>("fecha de termino de contrato"));
		valorContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("valor contrato"));

		contratos = FXCollections.observableArrayList();
		tablaContratos.setItems(contratos);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// Inicializamos la tabla
		this.inicializarTablaContratos();
		
		// Ponemos estos dos botones para que no se puedan seleccionar
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

		// Seleccionar las tuplas de la tabla de las empresas
		final ObservableList<EmpresaContratada> tablaPersonaSel = tablaContratos.getSelectionModel().getSelectedItems();
		tablaPersonaSel.addListener(selectorTablaEmpresas);
		
		// Inicializamos la tabla con algunos datos aleatorios
        for (int i = 0; i < 20; i++) {
            EmpresaContratada c1 = new EmpresaAseo();
            c1.nombre.set("Nombre empresa " + i);
            c1.numeroContrato.set("abcd" + i);
            c1.telefono.set("12345"+i);
            c1.fechaInicio.set("12345"+i);
            c1.fechaTerminacion.set("12345"+i);
            contratos.add(c1);
        }

	}

}
