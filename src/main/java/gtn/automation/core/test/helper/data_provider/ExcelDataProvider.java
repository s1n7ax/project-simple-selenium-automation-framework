package gtn.automation.core.test.helper.data_provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.bind.PropertyException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider implements UserDataProviderIntf{
	private String dataPackagePath = "src/resources/data";
	private Path projectPath = Paths.get(System.getProperty("user.dir"));
	private Path absDataPath = Paths.get(projectPath.toString(), dataPackagePath);
	
	private XSSFSheet excelWSheet;
	private XSSFWorkbook excelWBook;
	
	// get provider by excel file and sheet name
	public Object[][] getProvider(String excelFileName, String excelSheetName) throws IOException, PropertyException {
		if(excelFileName == null)
			throw new PropertyException("Unable to find property data_excel_file in TestNg XML");
		
		if(excelSheetName == null)
			throw new PropertyException("Unable to find property data_excel_file_sheet_name in TestNg XML");		
		
		
		Path fileAbsPath = Paths.get(absDataPath.toString(), excelFileName);
		return getMatrixFromExcel(fileAbsPath.toString(), excelSheetName);
	}

	public Object[][] getMatrixFromExcel(String excelPath, String sheetName) throws IOException{
		// complete excel will be read and written in to this linked list
		LinkedList<LinkedList<String>> result = new LinkedList<>();
				
		FileInputStream excelFile = new FileInputStream(new File(excelPath));
		excelWBook = new XSSFWorkbook(excelFile);
		excelWSheet = excelWBook.getSheet(sheetName);
		
		Iterator<Row> rowIterator = excelWSheet.iterator();
		
		// this is to ignore the headers
		rowIterator.next();

		// each row
		while (rowIterator.hasNext()) {
			Row currentRow = rowIterator.next();
			Iterator<Cell> cellIterator = currentRow.cellIterator();

			LinkedList<String> tempRow = new LinkedList<String>();

			// each cell
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();

				tempRow.add(currentCell.getStringCellValue());
			}

			result.add(tempRow);
		}

		return _2DLinkedListTo2DArr(result);
	}

	/*
	 * Convert 2d string linked list to 2d string array
	 */
	public String[][] _2DLinkedListTo2DArr(LinkedList<LinkedList<String>> rows) {
		int noOfRows = rows.size();

		String[][] result = new String[noOfRows][];

		for (int i = 0; i < noOfRows; i++) {
			LinkedList<String> row = rows.get(i);
			int noOfCells = row.size();
			
			result[i] = new String[noOfCells];
			
			for (int j = 0; j < noOfCells; j++) {
				result[i][j] = row.get(j);
			}
		}

		return result;
	}

}
