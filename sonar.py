# sonay.py

import random
import sys

def drawBoard(board):
    # Draw the board data structure.

    hline = '    ' # initial space for the numbers down the left side of the board
    for i in range(1, 6):
        hline += (' ' * 9) + str(i)

    # print the numbers across the top
    print(hline)
    print('    ' + ('0123456789' * 6))
    print()

    # print each of the 15 rows
    for  i in range(15):
        # single-digit numbers need to be padded with an extra space
        if  i < 10:
            extraSpace = ' '
        else:
            extraSpace = ''
        print('%s%s %s %s' % (extraSpace, i , getRow(board, i), i))

    # print the numbers across the bottom
    print()
    print('    ' + ('0123456789' * 6))
    print(hline)


def getRow(board, row):
    # Return a string from the board data structure at a certain row.
    boardRow = ''
    for i in range(60):
        boardRow += board[i][row]
    return boardRow

def getNewBoard():
    # Create a new 60x15 board data structure.
    board = []
    for x in range(60): # the main list is a list of 60 lists
        board.append([])
        for y in range(15): # each list in the main list has 15 single-character strings
            # use different characters for the ocean to make it more readable.
            if random.randint(0, 1) == 0:
                board[x].append('~')
            else:
                board[x].append('`')
    return board

def getRandomChests(numChests):
    # Creatr a list of chest data structures ( two-item lists of x, y int coordinates)
    chests = []
    for i in range(numChests):
        chests.append([random.randint(0, 59), random.randint(1, 14)])
        return chests
