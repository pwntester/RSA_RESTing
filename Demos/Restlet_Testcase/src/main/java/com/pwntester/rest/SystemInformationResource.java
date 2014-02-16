package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;

public class SystemInformationResource extends ServerResource {

	private String result = "";
	@Get("html")
	public String toString() {  
		try {
			/*SYSTEM INFO*/
			log("getServerInfo: Agent: " + getServerInfo().getAgent() );	
			log("getServerInfo: Address: " + getServerInfo().getAddress()  );
			log("getServerInfo: Port: " + getServerInfo().getPort()  );
			
		} catch (Exception e) {
			
		}

		// [RuleTest] System Information Leak
	    return result;  
	}  

	private void log(String text) {
		result += text + "\n";
	}
	
}
