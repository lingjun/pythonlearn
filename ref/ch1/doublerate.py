principal = 1000 # initial money
rate = 0.05      # rate
numyears = 5     # years
year = 1
while year <= numyears:
    principal = principal * (1 + rate)
    print "%3d %0.2f" % (year, principal)
    year += 1
