# Open a file, then read and print
f = open("doublerate.py")
line = f.readline()
while line:
    print line,
    line = f.readline()
f.close()
