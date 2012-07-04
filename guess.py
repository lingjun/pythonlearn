# This is a guess the number game.
import random

guessesTaken = 0

print("What's your name?")
myName = input()

number = random.randint(1,20)
print("Well, " + myName + ", I am thinking of a number between 1 and 20.")

while guessesTaken < 6:
    print("Taken a guess.") # There are four spaces in front of print
    guess = input()
    guess = int(guess)

    guessesTaken = guessesTaken + 1

    if guess < number:
        print("You guess is too low.")

    if guess > number:
        print("You guess is too high.")

    if guess == number:
        break

if guess == number:
    guessesTaken = str(guessesTaken)
    print("Good job, " + myName + "! You guess my number in " + guessesTaken + " guesses!")

if guess != number:
    number = str(number)
    print("Nope. The number I was thinking of is " + number)
