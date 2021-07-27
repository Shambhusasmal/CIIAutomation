package automationCII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InteractionDefinition {
	String id;
	
	ArrayList<Map> interactions = new ArrayList<Map>();
	
	public void setid(String id) {		
		this.id = id;					
	}
	
	public String getid() {
		return id;
	}
	
	public void setInteractions(String identifier, String value) {	
		HashMap<String, String> interactionsMap = new HashMap<String, String>();
		interactionsMap.put("identifier", identifier);
		interactionsMap.put("response", value);		
		interactions.add(interactionsMap);
	}
	
	public List<Map> getInteractions() {
		return interactions;
	}
	

}
