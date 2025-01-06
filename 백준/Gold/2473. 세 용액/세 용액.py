N = int(input())
fluid = list(map(int, input().split()))

ans = []
min = 100000000001

fluid.sort()

for i in range(N-2):
    res = fluid[i]

    left = i+1
    right = N-1

    while left < right:
        sum = res + fluid[left] + fluid[right]

        if abs(sum) < min:
            min = abs(sum)
            ans = [res, fluid[left], fluid[right]]
        
        if(sum < 0):
            left += 1
        else:
            right -=1

print(*ans)