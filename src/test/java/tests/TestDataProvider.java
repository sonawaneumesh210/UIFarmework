package tests;

import org.testng.annotations.DataProvider;

import utils.ReadExcelSheet;

public class TestDataProvider {
	
	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {
		String path = "C:/Users/Usonawane/eclipse-workspace/UiFramework/src/main/resources/creds_sheet.xlsx";
		return ReadExcelSheet.getExcelData(path, "creds");

	}
}
