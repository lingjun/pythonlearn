# some method to find caipiao number (yy)
import random

red = set()
blue = set()

times = 0

redAll = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33])
blueAll = set([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16])

print("Start:")
print("Please input how many times you want to discard? (0-10)")
innum = input()
while True:
    if innum not in '0 1 2 3 4 5 6 7 8 9 10'.split():
        print("Please input how many times you want to discard? (0-10)")
        innum = input()
    else:
        times = int(innum)
        break

leftRed = redAll
leftBlue = blueAll

while times >0:
    tempRed = list(range(1,34))
    random.shuffle(tempRed)
    selected = set([])
    for i in range(6):
        selected.add(tempRed[i])
    print("Selected Red:")
    print(selected)
    leftRed = leftRed - selected
    
    selectedBlue = set([random.randint(1,16)])
    leftBlue = leftBlue - selectedBlue
    times=times-1;

print("======RED=====")
print("leftRed length: " + str(len(leftRed)))
print(leftRed)
print("======BLUE=====")
print("leftBlue length: " + str(len(leftBlue)))
print(leftBlue)

print("Times: " + str(innum))

print("Now fortune coming:")
fortuneList = list(leftRed) 
random.shuffle(fortuneList)
print("Fortune red:")
print(fortuneList[0:6])
print("Fortune blue:")
print(list(leftBlue)[random.randint(0,len(list(leftBlue))-1)])
