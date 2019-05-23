package isw.proyecto.modelo.factorymethod;

import java.io.IOException;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.drawing.ChartType;
import com.grapecity.documents.excel.drawing.IShape;
import com.grapecity.documents.excel.drawing.RowCol;

import javafx.collections.ObservableList;

public class ArchivoXLSX implements IReporte{
	
	public ArchivoXLSX() {
		
	}

	@Override
	public <T> void generarReporte(String nombreArchivo, ObservableList<T> lista) throws IOException {

		Workbook workbook = new Workbook();

		IWorksheet worksheet = workbook.getWorksheets().get(0);

		IShape shape = worksheet.getShapes().addChart(ChartType.ColumnClustered, 300, 10, 300, 300);
		worksheet.getRange("A:D").setValue(new Object[][]{
			{null, "S1", "S2", "S3"},
			{"Item1", 10, 25, 25},
			{"Item2", -51, -36, 27},
			{"Item3", 52, -85, -30},
			{"Item4", 22, 65, 65},
			{"Item5", 23, 69, 69}
		});
		
		shape.getChart().getSeriesCollection().add(worksheet.getRange("A1:D6"), RowCol.Columns, true, true);

		workbook.save(nombreArchivo + ".xlsx");
	}

}
