package org.pwntester.restlet;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;

public class Server extends ServerResource {


    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8180);
        component.getDefaultHost().attach("/contacts", ContactResource.class);
        component.start();
    }

}