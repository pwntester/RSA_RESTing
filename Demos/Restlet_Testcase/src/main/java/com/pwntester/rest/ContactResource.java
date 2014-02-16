package com.pwntester.rest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
    public void storeItem(Representation entity) throws IOException {
        ObjectRepresentation<Contact> repObject;
        try {



            //System.out.println(entity.getText());
            repObject = new ObjectRepresentation<Contact>(entity);
            Contact Contact;
            Contact = repObject.getObject();
            System.out.println("name : " + Contact.getName());
            System.out.println("lasName : " + Contact.getLastName());
            setStatus(Status.SUCCESS_OK);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

