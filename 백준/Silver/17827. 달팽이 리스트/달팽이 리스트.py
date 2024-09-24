n,m,v = map(int,input().split())
v = v-1
c = list(map(int,input().split()))
answer = list()
len_recurse = n-v

for i in range(m):
    k = int(input())
    if k<n:
        answer.append(c[k])
    else:
        tmp = (k-v)%len_recurse
        answer.append(c[v+tmp])

for ans in answer:
    print(ans)