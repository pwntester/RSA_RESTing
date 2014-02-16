package com.pwntester.rest;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;
import org.restlet.Component;
import org.restlet.data.MediaType;
import org.restlet.Restlet;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.CookieSetting;
import org.restlet.util.Series;

public class TestServer extends ServerResource {

	public static void main(String[] args) throws Exception{
		
        // Create Component 
        Component comp = new Component();
        Server server = comp.getServers().add(Protocol.HTTP, 8180);

        // Attach resource to default host
        comp.getDefaultHost().attach("/xml", XMLResource.class);  
        comp.getDefaultHost().attach("/rce", ObjectResource.class);
        comp.getDefaultHost().attach("/contact", ContactResource.class);
        comp.getDefaultHost().attach("/test", TestResource.class);  
        comp.getDefaultHost().attach("/representation", RepresentationResource.class);  
        comp.getDefaultHost().attach("/xss", XSSResource.class);  // send payload in xss parameter: http://localhost:8182/xss?xss=%3Cscript%3Ealert%281%29%3C%2fscript%3E
        comp.getDefaultHost().attach("/xss/{xss}", XSS2Resource.class);  // send payload in xss path segment: http://localhost:8182/xss/%3Cscript%3Ealert%281%29%3C%2fscript%3E
        comp.getDefaultHost().attach("/private", PrivacyResource.class);
        comp.getDefaultHost().attach("/sysinfo", SystemInformationResource.class);
        comp.getDefaultHost().attach("/cookie", CookieResource.class);
         



        // Create a Restlet  
        Restlet xssRestlet = new Restlet(comp.getContext()) {  
            @Override  
            public void handle(Request request, Response response) {  
                
                String message = (String) request.getOriginalRef().getQuery(true);
                System.out.println("message" + message + " " + MediaType.TEXT_JAVASCRIPT );
                // [RuleTest] Cross-Site Scripting Reflected
                response.setEntity(message, MediaType.TEXT_HTML);  
            }  
        };  
        comp.getDefaultHost().attach("/xssrestlet", xssRestlet);  // send payload in any parameter: http://localhost:8182/xssrestlet?xss=%3Cscript%3Ealert%281%29%3C/script%3E

        // Create a Restlet  
        Restlet pvxssRestlet = new Restlet(comp.getContext()) {  
            @Override  
            public void handle(Request request, Response response) {  
                
                String message = (String) request.getOriginalRef().getQuery();
                System.out.println("message" + message + " " + MediaType.TEXT_JAVASCRIPT );
                // [RuleTest] Cross-Site Scripting Poor Validation
                response.setEntity(message, MediaType.TEXT_HTML);  
            }  
        };  
        comp.getDefaultHost().attach("/pvxssrestlet", pvxssRestlet);  // send payload in any parameter: http://localhost:8182/pvxssrestlet?xss=%3Cscript%3Ealert%281%29%3C/script%3E

        // Create another Restlet that has Header Manipulation: Cookie weakness
        Restlet cookieHeaderRestlet = new Restlet(comp.getContext()) {  
            @Override  
            public void handle(Request request, Response response) {  
                
                String message = (String) request.getOriginalRef().getQuery(true);
                System.out.println("message" + message + " " + MediaType.TEXT_JAVASCRIPT );

                CookieSetting cs = new CookieSetting("author", message);
                Series<CookieSetting> s = response.getCookieSettings();
                s.add(cs);
                // [RuleTest] Header Manipulation Cookies
                response.setCookieSettings(s);  
                response.setEntity("message received", MediaType.TEXT_HTML);
            }  
        };  
        comp.getDefaultHost().attach("/cookieHeaderRestlet", cookieHeaderRestlet); // send payload in any parameter: http://localhost:8182/cookieHeaderRestlet?bad=USETHEFORCE



        comp.start();

        System.out.println("Server started on port " + server.getPort());
        System.out.println("Press key to stop server");
        System.in.read();
        System.out.println("Stopping server");
        comp.stop();
        System.out.println("Server stopped");
    }  
      
    public void sink(Object o){}

}
