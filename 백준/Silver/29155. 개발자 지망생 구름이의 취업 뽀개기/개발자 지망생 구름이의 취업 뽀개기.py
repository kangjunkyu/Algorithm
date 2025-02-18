# 10
# 3 1 1 1 1
# 2 7
# 1 4
# 1 4
# 5 100
# 1 1
# 4 40
# 1 4
# 2 5
# 3 20
# 1 7

# 417

# 첫째 줄에 구름이가 살펴본 문제 수 
# $N$이 주어진다. 
# $(5 \leq N \leq 1\,000)$ 

# 둘째 줄에 각 난이도별로 풀어야 하는 문제 수 
# $p_1, p_2, p_3, p_4, p_5$가 공백으로 구분되어 주어진다. 
# $(1 \leq p_i \lt N;$ 
# $1 \leq i \leq 5)$ 

# 셋째 줄부터 
# $N$개의 줄에 걸쳐 문제의 난이도 
# $k_i$와 푸는 데 걸리는 시간 
# $t_i$가 공백으로 구분되어 주어진다. 
# $(1 \leq k_i \leq 5;$ 
# $1 \leq t_i \leq 300)$ 

#  
# $1\leq j \leq 5$인 
# $j$에 대하여 난이도 
# $j$인 문제의 개수는 
# $p_j$ 이상이다.

N = int(input())
problems = list(map(int,input().split()))
times = [[] for _ in range(5)]
for _ in range(N):
    lev,time = map(int,input().split())
    times[lev-1].append(time)

for time in times:
    if time:
        time.sort()

res = -60

for i in range(5):
    before_time = 0
    isFirst = True
    while problems[i] > 0:
        for j in range(len(times[i])):  
            if isFirst:
                res += times[i][j]
                before_time = times[i][j]
                isFirst = False
            else:
                res += abs(before_time - times[i][j])
                res += times[i][j]
                before_time = times[i][j]
            problems[i] -=1
            if problems[i] == 0:
                res += 60
                break

print(res)