package gtn.automation.test.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dnl.utils.text.table.TextTable;

public class PrintTables {

	private String headersArr[];
	private String tBodyArr[][];

	public PrintTables(WebElement table) {
		headersArr = getHeaderNamesByTableElement(table);
		tBodyArr = getTBodyByTableElement(table);
	}
	
	public void print() {
		TextTable tt = new TextTable(headersArr, tBodyArr);
		tt.printTable();
		
		// space
		System.out.println("\n\n");
	}

	public void print(String message) {
		System.out.println(message);
		
		// space
		System.out.println();
		
		print();
	}

	public String[] getHeaderNamesByTableElement(WebElement table) {
		List<WebElement> theads = table.findElements(By.xpath("//thead/tr/th"));
		int theadCount = theads.size();

		String[] _headersArr = new String[theadCount];

		for (int i = 0; i < theadCount; i++) {
			_headersArr[i] = theads.get(i).getText();
		}

		return _headersArr;
	}

	public String[][] getTBodyByTableElement(WebElement table) {
		
		// all the rows
		List<WebElement> tRows = table.findElements(By.xpath("//tbody/tr"));
		
		// row count
		int tRowCount = tRows.size();
		
		String[][] _tBodyArr = new String[tRowCount][];
		
		// looping each row
		for(int i = 0; i < tRowCount; i++) {
			// all cells of a row
			List<WebElement> row = tRows.get(i).findElements(By.tagName("td"));
			
			// number of cells in a row
			int cellCountInRow = row.size();
			
			// looping each cell in a row
			_tBodyArr[i] = new String[cellCountInRow];
			for(int j = 0; j < cellCountInRow; j++) {
				// get the text of a cell
				_tBodyArr[i][j] = row.get(j).getText();
			}
		}
		
		return _tBodyArr;
	}
}
