n = int(input())
metrix = []
for _ in range(n):
    row = list(map(int, input().split()))
    metrix.append(row)

arr = [0] * n
for i in range(n):
    for j in range(n):
        if i == j:
            continue
        else:
            arr[i] |= metrix[i][j]

print(*arr)
