N = int(input())
arr = list(map(int, input().split()))

stack = []

ans = [0] * N

for i, tower in enumerate(arr):
    while stack and stack[-1][1] <= tower:
        stack.pop()

    if stack:
        ans[i] = stack[-1][0]

    stack.append((i +1, tower))

print(*ans, sep=" ")