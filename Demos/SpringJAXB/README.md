## SpringJAXB

Test application vulnerable to XXE:

XXE request:
curl --header "content-type: application/xml" --header "Accept: application/xml" --data @contact-xxe.xml -X POST  "http://localhost:8080/contacts"

XSS request:
curl -X GET  "http://localhost:8080/contacts/%3Csvg%20onload=alert%281%29%3E"