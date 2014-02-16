package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;
import org.restlet.Response;
import org.restlet.data.CookieSetting;
import org.restlet.util.Series;

public class CookieResource extends ServerResource {

	
	@Get("html")
	public String toString() {  
		try {
			Response response = getResponse();
			CookieSetting cs = new CookieSetting("author", getQueryValue("value"));
			Series<CookieSetting> s = response.getCookieSettings();
			s.add(cs);
			// [RuleTest] Header Manipulation Cookies
			response.setCookieSettings(s); 

		} catch (Exception e) {
			
		}
	    return "Check your cookies";  
	}  
}
