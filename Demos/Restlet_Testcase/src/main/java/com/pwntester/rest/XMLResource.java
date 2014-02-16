package com.pwntester.rest;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.ext.xml.XmlRepresentation;
import org.restlet.representation.Representation;

public class XMLResource extends ServerResource {

	@Post("xml")
	public Contact createContact(Contact c) {
		try {
			System.out.println("getRequest().getAttributes(): " + getRequest().getAttributes());
			System.out.println("getRequest().getEntityAsText(): " + getRequest().getEntityAsText());
			System.out.println("getRequest().getEntity(): " + getRequest().getEntity());
			System.out.println("getRequest().getEntity().getText(): " + getRequest().getEntity().getText());
			System.out.println("getRequestEntity().getText(): " + getRequestEntity().getText());
			System.out.println("c.getName(): " + c.getName());
			System.out.println("Contact received: " + c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
