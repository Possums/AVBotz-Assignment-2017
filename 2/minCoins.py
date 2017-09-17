import numpy as np
value = np.loadtxt("coins.in")
amount = value * 100
quarters = amount // 25
dimes = amount % 25 // 10
nickels = amount % 25 % 10 // 5
pennies = amount % 25 % 10 % 5
print(quarters+dimes+nickels+pennies)
file = open("coins.out", "w+")
file.write(str(quarters + dimes + nickels + pennies))
