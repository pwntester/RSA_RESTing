package org.pwntester.restlet;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import org.restlet.data.Status;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.restlet.data.MediaType;

public class ContactResource extends ServerResource {

	@Get
	public ObjectRepresentation<Contact> getContact() {
		ObjectRepresentation<Contact> contact = new ObjectRepresentation<Contact>(new Contact());
		contact.setMediaType(MediaType.APPLICATION_JAVA_OBJECT_XML);
		return contact;
	}

	@Put
	public void updateContact (Representation entity) throws IOException {
		try {

            ObjectRepresentation<Contact> repObject = new ObjectRepresentation<Contact>(entity);
			Contact contact = repObject.getObject();
			System.out.println("name : " + contact.getName());
			System.out.println("firstname : " + contact.getLastName());
			setStatus(Status.SUCCESS_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
