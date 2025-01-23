import sys
input = sys.stdin.readline
n=int(input())
tmp=[]

for i in range(1,n+1):
    x,y,v=map(int,input().split())
    # x의 제곱 + y의 제곱의 값을 구하고 그에 대한 제곱근의 값을 그준으로 잡는다. 그걸 v로 나눈다.
    # 직선거리를 위한 유클리드
    # 그리고 .해당 값이 같을 경우를 위해 i를 x[1]에 넣는다.
    d = (x**2+y**2)**0.5
    tmp.append((d/v,i))
# x를 람다로 하여 x[0] 즉 값이 같을 경우엔 index로 sort를 한다.
tmp.sort(key=lambda x:(x[0],x[1]))
for i in range(n):
    print(tmp[i][1])