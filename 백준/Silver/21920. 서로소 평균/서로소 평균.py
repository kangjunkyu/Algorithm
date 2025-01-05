def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return a


N = int(input())
arr = list(map(int, input().split()))
x = int(input()) 

result = 0
cnt = 0

for i in range(N):
    if gcd(arr[i], x) == 1:
        result += arr[i]
        cnt += 1

if cnt == 0:
    print("0")
else:
    print(round(result / cnt))
