package gtn.automation.testing.pages;

public enum HomePageLocatorsEnum {
	
	lnk_HomeNavigator("//li[text()='<>']/a");
	
	
	
	private final String text;

    private HomePageLocatorsEnum(String text) {
    	this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
