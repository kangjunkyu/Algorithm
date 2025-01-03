N, D = map(int, input().split())

arr = list(map(int, input().split()))
ans = 0

max = max(arr)

len = max - D

if len < 0:
    len = 0

for i in range(N):
    if arr[i] - len > 0:
        ans += arr[i] - len

print(ans)