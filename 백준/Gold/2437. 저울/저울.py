N = int(input())
arr = list(map(int, input().split()))

arr.sort()
sum = 0
for i in range(N):
    if sum+1 < arr[i]:
        break

    sum += arr[i]

print(sum+1)