package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;

public class PrivacyResource extends ServerResource {

	private final String password = "USE THE FORCE!";

	private String getPassword() {
		return password;
	}

	private String result = "";
	@Get("html")
	public String toString() {  
		try {
			log("Privacy Information: " + getPassword());	/* Intentional Trivial Privacy Violation */

		} catch (Exception e) {
			
		}

		// [RuleTest] Privacy Violation
	    return result;  
	}  

	private void log(String text) {
		result += text + "\n";
	}
	
}
