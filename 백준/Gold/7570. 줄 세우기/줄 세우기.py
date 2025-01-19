N = int(input())
arr = list(map(int, input().split()))

# cnt = 1
# max = 1

# for i in range(1, N):
#     if arr[i] > arr[i-1]:
#         cnt+=1
#         if max < cnt:
#             max = cnt
#     else:
#         cnt = 1

dp = [0] * (N + 1)

for i in range(N):
    dp[arr[i]] = dp[arr[i] - 1] + 1

dp.sort()

print(N - dp[N])
