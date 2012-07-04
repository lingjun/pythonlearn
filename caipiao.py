# some method to find caipiao number (yy)

red = set()
blue = set()

times = 0

redAll = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33])
blueAll = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16])

while True:
   # print("Start")
    flag = input();
    if(int(flag)==0):
        break
    red.add(int(flag))
    red.add(int(input()))
    red.add(int(input()))
    red.add(int(input()))
    red.add(int(input()))
    red.add(int(input()))
    blue.add(int(input()))
    print("======RED=====")
    leftRed = redAll-red
    print("leftRed length: " + str(len(leftRed)))
    print(leftRed)
    print("======BLUE=====")
    leftBlue = blueAll-blue
    print("leftBlue length: " + str(len(leftBlue)))
    print(leftBlue)
    times + 1
    print("Times: " + str(times))

print("Times: " + str(times))



    
