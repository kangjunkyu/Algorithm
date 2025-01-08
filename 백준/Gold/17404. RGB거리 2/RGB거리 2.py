N = int(input())
arr = []
max = 100000
ans = max
for _ in range(N):
    arr.append(list(map(int, input().split())))

for i in range(3):
    dp = [[max, max, max] for _ in range(N)]
    dp[0][i] = arr[0][i]
    for j in range(1, N):
        dp[j][0] = min(dp[j-1][1], dp[j-1][2]) + arr[j][0]
        dp[j][1] = min(dp[j-1][0], dp[j-1][2]) + arr[j][1]
        dp[j][2] = min(dp[j-1][0], dp[j-1][1]) + arr[j][2]
    
    for j in range(3):
        if i!= j:
            ans = min(ans, dp[N-1][j])

print(ans)