import sys
input = sys.stdin.readline
sys.setrecursionlimit(500000)

N, M = map(int, input().rstrip().split())
graph = []
count = 0
for _ in range(N):
    line = list(map(int, input().rstrip().split()))
    row = []
    for i in range(M):
        k = line[3*i] + line[3*i+1] + line[3*i+2]
        row.append(k/3)
    graph.append(row)
T = int(input())

def dfs(row, col, T):
    global count
    if row >= N or row < 0 or col >= M or col < 0:
        return 0
    elif graph[row][col] < T:
        return 0
    else:
        graph[row][col] = -1
        dfs(row+1, col, T)
        dfs(row-1, col, T)
        dfs(row, col+1, T)
        dfs(row, col-1, T)
        return 1
    return 0

for row in range(N):
    for col in range(M):
        if graph[row][col] >= T:
            count += dfs(row, col, T)

print(count)