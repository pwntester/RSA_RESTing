package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;

public class TestResource extends ServerResource {

	private String result = "";
	@Get
	public String toString() {  
		try {
			log("Entity as text: " + getRequest().getEntityAsText());
			log("Entity: " + getRequest().getEntity());
			log("onerror: " + getRequest().getOnError());
			log("onsent: " + getRequest().getOnSent());
			log("getAttribute: " + getAttribute("payload"));
			log("getHostRef: " + getRequest().getHostRef() );
			log("getAttributes: " + getRequest().getAttributes()  );
			log("getAttributes user: " + getRequest().getAttributes().get("user")  );
			log("getHostRef: " + getHostRef()  );
			log("getLocationRef: " + getLocationRef()  );
			log("getOriginalRef: " + getOriginalRef()  );
			log("getReference: " + getReference()  );
			log("getReferrerRef: " + getReferrerRef()  );
			log("getMatrix: " + getMatrix()  );
			log("getMatrixValue: " + getMatrixValue("payload")  );
			log("getQuery: " + getQuery()  );
			log("getQueryValue: " + getQueryValue("payload")  );
			log("getRequestAttributes: " + getRequestAttributes()  );
			log("getRequestCacheDirectives: " + getRequestCacheDirectives()  );
			log("getRootRef() : " + getRootRef() );
			log("getServerInfo: " + getServerInfo().getAgent()  );
			log("getContext().getAttributes(): " + getContext().getAttributes()  );
			log("getContext().getParameters(): " + getContext().getParameters()  );
			log("getRequestEntity().getText()  : " + getRequestEntity().getText()    );
		} catch (Exception e) {
			
		}


	    return result;  
	}  

	private void log(String text) {
		result += text + "\n";
	}
	
}
