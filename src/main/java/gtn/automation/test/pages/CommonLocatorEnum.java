package gtn.automation.test.pages;

public enum CommonLocatorEnum {
	tf_Inputs("//label[text()='<>']/following::input[1]"),
	tf_InputsById("//input[@id='<>']"),
	
	ele_lblPageHeaderCommon("//small[text()='<>']"),
	ele_lblStatusMessage(""),
	ele_ddSelects("//label[text()='<>']/following::select[1]"),
	ele_DivByClass("//div[@class='<>']"),
	
	btn_Buttons("//button[text()='<>']"),
	btn_ButtonsById("//button[@id='<>']"),
	btn_InputButtons("//input[@type='button' and @value='<>']"),
	btn_AncButtons("//a[@type='button' and text()='<>']"),
	btn_FileInputs("//input[@type='file' and @id='<>']"),
	
	frm_IFrameByName("//iframe[@name='<>']"),
	
	tbl_TablesById("//table[@id='<>']");
	
	
	
	private String text;
	
	public String getText() {
		return text;
	}
	
	private CommonLocatorEnum(String text) {
		this.text = text;
	}
}
