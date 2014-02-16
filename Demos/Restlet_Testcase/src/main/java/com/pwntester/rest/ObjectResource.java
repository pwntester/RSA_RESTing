package com.pwntester.rest;

import java.io.IOException;
import org.restlet.data.Status;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.restlet.data.MediaType;

public class ObjectResource extends ServerResource {

	@Get
	public ObjectRepresentation<Contact> getContact() {
		ObjectRepresentation<Contact> contact = new ObjectRepresentation<Contact>(new Contact());
		contact.setMediaType(MediaType.APPLICATION_JAVA_OBJECT_XML);
		return contact;
	}

	@Post
	public void storeContact(Representation entity) throws IOException { 
		ObjectRepresentation<Contact> repObject;
		try {
            Contact contact = new ObjectRepresentation<Contact>(entity).getObject();
            String name = contact.getName();
			System.out.println(name);
			setStatus(Status.SUCCESS_OK);
		} catch (IllegalArgumentException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}	
	}

}
