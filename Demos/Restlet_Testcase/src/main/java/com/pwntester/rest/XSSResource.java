package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;

public class XSSResource extends ServerResource {

	@Get("html")
	public String toString() {  
		// Retrieve query value of argument xss (e.g. http://localhost:8182/xss?xss=%3Cscript%3Ealert%281%29%3C%2fscript%3E)
		// [RuleTest] Cross-Site Scripting Reflected
		return getQueryValue("xss") ;  
	}  

}
