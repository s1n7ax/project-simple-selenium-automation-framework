package gtn.automation.core.runtime_helper.logger;

import java.util.Iterator;
import java.util.List;

import dnl.utils.text.table.TextTable;

public class TestCaseSummaryLogger implements SummaryLogger {
	private String[] tcSumHeaders;
	private String[] tsSumHeaders;

	private String[][] tcSumcontent;
	private String[][] tsSumcontent;

	private List<TestCaseSummaryModel> tcContentList;

	public TestCaseSummaryLogger(List<TestCaseSummaryModel> tempContent) {
		tcSumHeaders = new String[] { "Test Case Name", "Browser", "Status", "Started At", "Ended At",
				"Duration (minutes)" };

		this.tcContentList = tempContent;

		this.tcSumcontent = new String[tempContent.size()][];
	}

	@Override
	public void printTable() {

		tcSumcontent = get2dArrTCContent(tcContentList);

		// print test case summary
		System.out.println("========= Test Case Summary =========");
		TextTable table1 = new TextTable(tcSumHeaders, tcSumcontent);
		table1.printTable();

		// some spaces after table
		System.out.println("\n\n");

		// print test suite summary
		System.out.println("========= Execution Summary =========");
		System.out.println("Total dutaion for the  execution: " + getTSContent(tcContentList));

		// some spaces after table
		System.out.println("\n\n");
	}

	private String[][] get2dArrTCContent(List<TestCaseSummaryModel> content) {
		String[][] result = new String[tcContentList.size()][];
		Iterator<TestCaseSummaryModel> iterator = content.iterator();

		for (int i = 0; iterator.hasNext(); i++) {

			// same as the number of columns
			String[] temp = new String[tcSumHeaders.length];

			TestCaseSummaryModel model = iterator.next();

			temp[0] = model.getName();
			temp[1] = model.getStatus();
			temp[2] = model.getBrowser();
			temp[3] = model.getStartTime();
			temp[4] = model.getEndTime();
			temp[5] = model.getDuration();

			result[i] = temp;
		}

		return result;
	}

	private String getTSContent(List<TestCaseSummaryModel> content) {
		Iterator<TestCaseSummaryModel> iterator = content.iterator();
		
		long totDuration = 0;
		
		while(iterator.hasNext()) {
			TestCaseSummaryModel model = iterator.next();
			
			totDuration += model.getDurationInMils();
		}
		
		return TestCaseSummaryModel.getMinSecStringFromLong(totDuration);
	}

}
