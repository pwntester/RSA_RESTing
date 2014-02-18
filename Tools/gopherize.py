#!/usr/bin/python2
import sys
import getopt
def Usage():
    print("""Usage: %s [-0] host:port
    -0      Substitute 0x00 for bytes 0x80-0xff
            """ % (sys.argv[0]))

def main():
    optlist, args = getopt.getopt(sys.argv[1:], '0')
    opts = {x:y for (x,y) in optlist} 
    if len(args) != 1:
        Usage()
        return 1
    try:
        hostport = args[0]
    except ValueError as e:
        print("Error! port must be numeric!")
        Usage()
        return 2
    data = []
    prev = '\x00'
    for char in sys.stdin.read():
        if char == '\x0a' and prev != '\x0d':
            data.append('\x0d')
        if '-0' in opts and ord(char) >= 0x80:
            char = '\x00'
        data.append(char)
        prev = char
    urlenc = [ "%%%0.2x" % ord(x) for x in data]
    url = "gopher://" + hostport + "/1" + "".join(urlenc)
    print(url)
    return 0
sys.exit(main())
