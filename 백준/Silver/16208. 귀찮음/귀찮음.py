n = int(input())

length = list(map(int, input().split()))

total = 0
for i in range(n):
    total += length[i]

length.sort()

next = total
cost = 0
for i in range(n-1):
    next -= length[i]
    cost += (next*length[i])

print(cost)