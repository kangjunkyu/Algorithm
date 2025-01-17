N = int(input())
K = int(input())
sensor = list(map(int, input().split()))
# 센서 위치 정렬
sensor.sort()

diff = []
# 센서 사이의 거리를 구해서 정렬
for i in range(1, N):
    diff.append(sensor[i] - sensor[i - 1])

diff.sort()

# 작은거 내보내자 -> K - 1개만큼
for _ in range(K - 1):
    if diff:
        diff.pop()

print(sum(diff)) # 나머지 더하기