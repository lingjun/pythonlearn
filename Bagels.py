import random

def getHints(guess, secret):
    # Return a string with the pico, fermi, bagles clues to the user.
    if guess == secret:
        return 'You got it!'

    clue = []

    for i in range(len(guess)):
        if guess[i] == secret[i]:
            clue.append('Fermi')
        elif guess[i] in secret:
            clue.append('Pico')
    if len(clue) == 0:
        return 'Bagels'

    clue.sort()
    return ' '.join(clue)
    
def isOnlyDigits(num):
    # Return True if num is a string made up of only digits. Otherwise returns False
    if num == '':
        return False

    for i in num:
        if i not in '0 1 2 3 4 5 6 7 8 9'.split():
            return False

    return True

def playAgain():
    # This function returns True if the player wants to play again, ootherwise it returns False
    print('Do you want to play again? (yes or no?)')
    return input().lower().startswith('y')

def getSecretNum(numDigits):
    # Returns a string that is numDigits long, made up of unique random digits
    numbers = list(range(10))
    random.shuffle(numbers)
    secretNum = ''
    for i in range(numDigits):
        secretNum += str(numbers[i])
    return secretNum

NUMDIGITS = 3
MAXGUESS = 10

print('I am thinking of a %s-digit number. Try to guess what it is.' % (NUMDIGITS))
print('Here are some clues:')
print('When I say:   That means:')
print('  Pico        One digit is correct but in the wrong position.')
print('  Fermi       One digit is correct and in the right position.')
print('  Bagles      No digit is correct.')

while True:
    secret = getSecretNum(NUMDIGITS)
    print('I have thought up a number. You have %s guesses to get it.' %(MAXGUESS))

    numGuesses = 1
    while numGuesses <= MAXGUESS:
        guess = ''
        while len(guess) != NUMDIGITS or not isOnlyDigits(guess):
            print('Guess #%s: ' % (numGuesses))
            guess = input()

        clue = getHints(guess, secret)
        print(clue)
        numGuesses += 1

        if guess == secret:
            break
        if numGuesses > MAXGUESS:
            print('You ran out of gueses. The answer was %s.' % (secret))

    if not playAgain():
        break
    
