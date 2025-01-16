import heapq as hq

n=int(input())
array=[]
for i in range(n):
    a,b=map(int,input().split())
    array.append([a,b])
array.sort(key=lambda t: (t[0],t[1]))

ans=[]
for x,y in array:
    if len(ans)==0:
        hq.heappush(ans,y)
    else:
        if ans[0]<=x:
            hq.heappop(ans)
            hq.heappush(ans,y)
        else:
            hq.heappush(ans,y)
print(len(ans))