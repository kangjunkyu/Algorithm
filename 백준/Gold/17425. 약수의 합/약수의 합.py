import sys

t = int(sys.stdin.readline().strip())
arr = [int(sys.stdin.readline().strip()) for _ in range(t)]

max = 1000001  

fx = [1] * (max + 1)
gx = [0] * (max + 1)

for i in range(2, max + 1):
    for j in range(1, (max // i) + 1):
        fx[i * j] += i

for i in range(1, max + 1):
    gx[i] = gx[i - 1] + fx[i]

for num in arr:
    print(gx[num])