package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;
import org.restlet.data.Reference;

public class XSS2Resource extends ServerResource {

	@Get("html")
	public String toString() {  
		System.out.println(Reference.decode((String) getRequest().getAttributes().get("xss")));
		// [RuleTest] Cross-Site Scripting Reflected
	    return    Reference.decode((String) getRequest().getAttributes().get("xss"));
	}  

}
