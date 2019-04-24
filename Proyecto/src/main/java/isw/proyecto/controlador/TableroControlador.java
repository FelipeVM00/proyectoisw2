package isw.proyecto.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class TableroControlador implements Initializable {

    @FXML
    private AnchorPane holderPane;
    
    @FXML
    private JFXButton btnHome;
    
    @FXML
    private JFXButton btnAgenda;
    
    @FXML
    private JFXButton btnFinanzas;
    
    @FXML
    private JFXButton btnParqueadero;
    
    @FXML
    private JFXButton btnResidentes;
    
    @FXML
    private JFXButton btnEmpresas;
    
    @FXML
    private JFXButton btnReportes;
    
    @FXML
    private JFXButton btnQuejas;
    
    @FXML
    private JFXButton btnConfig;
       
    AnchorPane home, agenda, finanzas, parqueadero, residentes, empresas, reportes, quejas, config;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Carga todos los archivos fxml en cache
        try {
             home = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Home.fxml"));
             agenda = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Agenda.fxml"));
             finanzas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Finanzas.fxml"));
             parqueadero = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Parqueadero.fxml"));
             residentes = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Residentes.fxml"));
             empresas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Empresas.fxml"));
             reportes = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Reportes.fxml"));
             quejas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Quejas.fxml"));
             config = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Configuracion.fxml"));
             setNode(home);
        } catch (IOException ex) {
            Logger.getLogger(TableroControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    /*
     * Establece el modulo a mostarse en el tablero 
     * @param node el modulo clickeado
     */
    private void setNode(Node node) {
    	if(! holderPane.getChildren().contains(node)) {
    		holderPane.getChildren().clear();
            holderPane.getChildren().add((Node) node);
            FadeTransition ft = new FadeTransition(Duration.millis(1000));
            ft.setNode(node);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
    	}    
    }

    @FXML
    private void switchAgenda(ActionEvent event) {
        setNode(agenda);
    }
    
    @FXML
    private void switchEmpresas(ActionEvent event) {
        setNode(empresas);
    }
    
    @FXML
    private void switchHome(ActionEvent event) {
        setNode(home);
    }
    
    @FXML
    private void switchFinanzas(ActionEvent event) {
        setNode(finanzas);
    }
    
    @FXML
    private void switchParqueadero(ActionEvent event) {
        setNode(parqueadero);
    }
    
    @FXML
    private void switchReportes(ActionEvent event) {
        setNode(reportes);
    }
    
    @FXML
    private void switchResidentes(ActionEvent event) {
        setNode(residentes);
    }

    @FXML
    private void switchQuejas(ActionEvent event) {
        setNode(quejas);
    }
    
    @FXML
    private void switchConfig(ActionEvent event) {
        setNode(config);
    }
}
