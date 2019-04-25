package isw.proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import java.time.LocalDate;
import java.time.LocalTime;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class AgendaControlador implements Initializable{

	@FXML
	private AnchorPane anchorpane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarAgenda();	
	}
	
	private void inicializarAgenda() {
		anchorpane.getChildren().add(crearCalendarios());
	}
	
	private CalendarView crearCalendarios() {
		CalendarView calendarView = new CalendarView(); 
        Calendar asambleas = new Calendar("Asambleas"); 
        Calendar reuniones = new Calendar("Reuniones");      
        asambleas.setStyle(Style.STYLE2); 
        reuniones.setStyle(Style.STYLE3);     
        CalendarSource myCalendarSource = new CalendarSource("Tipos de reuniones"); 
        myCalendarSource.getCalendars().addAll(asambleas, reuniones);
        

        calendarView.getCalendarSources().addAll(myCalendarSource); 
        calendarView.setRequestedTime(LocalTime.now());

        Thread updateTimeThread = new Thread() {
                @Override
                public void run() {
                        while (true) {
                                Platform.runLater(() -> {
                                        calendarView.setToday(LocalDate.now());
                                        calendarView.setTime(LocalTime.now());
                                });

                                try {
                                        sleep(10000);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }

                        }
                };
        };
        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();
        calendarView.getStylesheets().add("/isw/proyecto/vista/custom.css");
        calendarView.setPrefSize(1219, 713);
        calendarView.setBackground(new Background(new BackgroundFill(Color.web("#4d4e4f"), CornerRadii.EMPTY, Insets.EMPTY)));
        return calendarView;
	}
 
}
