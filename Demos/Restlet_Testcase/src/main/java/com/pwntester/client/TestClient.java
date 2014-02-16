package com.pwntester.client;

import org.restlet.resource.ClientResource;
import org.restlet.data.Parameter;
import org.restlet.data.MediaType;
import org.restlet.data.Cookie;
import org.restlet.util.Series;

public class TestClient {

	public static void main(String[] args) throws Exception{
		
		ClientResource client = new ClientResource("http://localhost:8182/test");
		String password = "USETHEFORCE";
		// [RuleTest] Privacy Violation
		client.addQueryParameter(new Parameter("pwd", password));
		// [RuleTest] Privacy Violation
		client.addSegment(password);
		// [RuleTest] Privacy Violation
		Cookie cs = new Cookie("sessionpwd", password);
		Series<Cookie> s = new Series(Cookie.class);
		s.add(cs);
		client.setCookies(s);

		System.out.println("Response attribute " + client.getAttribute("Cookie"));

		client.get().write(System.out);
		try {
			ClientResource xmlclient = new ClientResource("http://localhost:8182/xml");
			xmlclient.accept(MediaType.APPLICATION_XML);
			String body = "<contact> <name>test</name> <lastName>" + password + "</lastName> </contact>";
			// [RuleTest] Privacy Violation
			xmlclient.post(body, MediaType.APPLICATION_XML).write(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// client.setCookies
		// client.setHostRef
		// client.setOriginalRef
		// client.setReference
		// client.setReferrerRef
		// client.setClientInfo
	
	}
}
