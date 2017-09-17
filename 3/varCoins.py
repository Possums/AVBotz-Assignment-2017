import numpy as np

def leastCoins(coinList,change,minCoins):
   for cents in range(change+1):
      coinCount = cents
      for j in [c for c in coinList if c <= cents]:
            if minCoins[cents-j] + 1 < coinCount:
               coinCount = minCoins[cents-j]+1
      minCoins[cents] = coinCount
   return minCoins[change]

data = np.loadtxt("coins2.in")
amount = int(data[0])
coins = data.astype(int)[1:]
minCoins = [0]*(int(amount+1))
answer = leastCoins(coins, amount, minCoins)
file = open("coins2.out", "w+")
file.write(str(answer))
print(answer)
