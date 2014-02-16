package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.StringRepresentation;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepresentationResource extends ServerResource {

	@Post
	public void createContact(StringRepresentation c) {
		try {
			// [RuleTest] Sink
			sink(c);
			// [RuleTest] Sink
			sink(c.getText());

			System.out.println("getRequest().getAttributes(): " + getRequest().getAttributes());
			System.out.println("getRequest().getEntityAsText(): " + getRequest().getEntityAsText());
			System.out.println("getRequest().getEntity(): " + getRequest().getEntity());
			System.out.println("getRequest().getEntity().getText(): " + getRequest().getEntity().getText());
			System.out.println("getRequestEntity().getText(): " + getRequestEntity().getText());
			System.out.println("c.getText(): " +  c.getText());

			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				br = new BufferedReader(new InputStreamReader(getRequestEntity().getStream()));
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("Contact received: " + sb.toString());
		} catch (Exception e) {}

	}

	public void sink(Object o) {}
	
}
