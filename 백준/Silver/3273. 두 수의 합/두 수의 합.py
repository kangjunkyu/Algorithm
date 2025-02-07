# 9
# 5 12 7 10 9 1 2 3 11
# 13

N = int(input())
arr = list(map(int, input().split()))
X = int(input())

arr.sort()

cnt = 0
start = 0
end = N - 1

while start < end:
    if arr[start] + arr[end] == X:
        cnt +=1
        start += 1
    elif arr[start] + arr[end] < X:
        start += 1
    elif arr[start] + arr[end] > X:
        end -= 1

print(cnt)