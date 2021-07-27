package automationCII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemDefinition {

	private int testInstanceId;
	private String testId;
	private int timetaken;
	private Boolean isSubmit;
	private InteractionDefinition item = new InteractionDefinition();
	
	public void setTestInstanceId(int tin_ID) {
		this.testInstanceId = tin_ID;
	}
	
	public int getTestInstanceId() {
		return testInstanceId;
	}
	
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	public String getTestId() {
		
		return testId;
	}
	public void settimetaken(int timetaken) {
		this.timetaken = timetaken;
	}
	
	public int gettimetaken() {
		
		return timetaken;
	}
	
	public void setIsSubmit(Boolean isSubmit) {
		this.isSubmit = isSubmit;
	}
	
	public Boolean getIsSubmit() {
		
		return isSubmit;
	}
	
	
	public void setItem(String Id, String identifier, String response) {		
		item.id=Id;
		item.setInteractions(identifier, response);
		
	}
	
	public InteractionDefinition getItem() {
		return item;
	}
	
}
